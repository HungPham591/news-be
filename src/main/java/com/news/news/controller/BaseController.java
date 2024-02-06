package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.dto.response.ResponseModel;
import com.news.news.service.BaseService;
import org.hibernate.JDBCException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.yaml.snakeyaml.events.Event;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BaseController<T, E, ID> {
    protected BaseService<E, ID> service;
    private Class<T> responseClass;
    private Class<E> entityClass;
    public ObjectMapper objectMapper;

    public BaseController(BaseService<E, ID> service, Class<T> responseClass, Class<E> entityClass) {
        this.service = service;
        this.responseClass = responseClass;
        this.entityClass = entityClass;
    }

    public BaseController() {

    }

//    @GetMapping
//    public List<T> getAll() {
//        return success(service.findAll());
//    }

    @GetMapping("/{id}")
    public ResponseModel<T> getById(@PathVariable ID id) {
        Optional<E> entityOptional = service.findById(id);
        if (entityOptional.isPresent()) {
            return success(entityOptional.get());
        } else {
            return error(404, "Entity with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseModel<T> create(@Valid @RequestBody E entity) {
        E savedEntity = service.save(entity);
        return success(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseModel<T> update(@PathVariable ID id, @Valid @RequestBody E entity) {
        if (!service.existsById(id)) {
            return error(400, "Not found");
        }
        E savedEntity = service.save(entity);
        return success(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseModel<T> delete(@PathVariable ID id) {
        if (!service.existsById(id)) {
            return error(400, "Not found");
        }
        service.deleteById(id);
        return success(null);
    }

    @ExceptionHandler(JDBCException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage InvalidDataException(Exception ex, WebRequest request) {
        System.out.println(ex);
        return new ErrorMessage("Data invalid !!!");
    }

    public ResponseModel<T> success(E data) {
        T mappedData = convertValue(data, responseClass);

        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setElements(Collections.singletonList(mappedData));

        ResponseModel.Status status = new ResponseModel.Status();
        status.setSuccess(true);
        status.setCode(200);

        responseModel.setStatus(status);

        return responseModel;
    }

    public ResponseModel<T> success(List<E> data, Integer pageCount, Integer page, Integer size, Long total) {
        List<T> mappedData = convertListValue(data, responseClass);

        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setElements(mappedData);

        ResponseModel.Status status = new ResponseModel.Status();
        status.setSuccess(true);
        status.setCode(200);

        ResponseModel.Metadata metadata = new ResponseModel.Metadata();
        metadata.setPage(page);
        metadata.setPageCount(pageCount);
        metadata.setPerPage(size);
        metadata.setTotal(total);

        responseModel.setStatus(status);
        responseModel.setMetadata(metadata);

        return responseModel;
    }

    public ResponseModel<T> error(Integer code, String message) {
        ResponseModel<T> responseModel = new ResponseModel<>();

        ResponseModel.Status status = new ResponseModel.Status();
        status.setSuccess(false);
        status.setCode(code);
        status.setErrors(message);

        responseModel.setStatus(status);

        return responseModel;
    }

    public <T> T convertValue(Object fromValue, Class<T> toValueType) {
        Method convertValueMethod;
        try {
            convertValueMethod = objectMapper.getClass().getMethod("convertValue", Object.class, Class.class);
            return (T) convertValueMethod.invoke(objectMapper, fromValue, toValueType);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("Error converting value", e);
        }
    }

    public <T> List<T> convertListValue(List<?> fromValues, Class<T> toValueType) {
        List<T> convertedValues = new ArrayList<>();
        for (Object value : fromValues) {
            T convertedValue = convertValue(value, toValueType);
            convertedValues.add(convertedValue);
        }
        return convertedValues;
    }
}
