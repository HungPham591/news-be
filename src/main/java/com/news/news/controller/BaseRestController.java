package com.news.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.news.dto.response.BaseDto;
import com.news.news.dto.response.ResponseDto;
import com.news.news.entity.BaseEntity;
import com.news.news.service.BaseService;
import lombok.Data;
import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Controller
@Data
public abstract class BaseRestController<T extends BaseDto, E extends BaseEntity, ID extends Number> {
    protected BaseService<E, ID> service;
    private Class<T> responseClass;
    private Class<E> entityClass;
    public ObjectMapper objectMapper;
    public Logger logger;

    @GetMapping("/{id}")
    public ResponseDto<T> getById(@PathVariable ID id) {
        Optional<E> entityOptional = service.findById(id);
        if (entityOptional.isPresent()) {
            return success(entityOptional.get());
        } else {
            return error(404, "Entity with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseDto<T> create(@Valid @RequestBody E entity) {
        E savedEntity = service.save(entity);
        return success(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseDto<T> update(@PathVariable ID id, @Valid @RequestBody E entity) {
        if (!service.existsById(id)) {
            return error(400, "Not found");
        }
        E savedEntity = service.save(entity);
        return success(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<T> delete(@PathVariable ID id) {
        if (!service.existsById(id)) {
            return error(400, "Not found");
        }
        service.deleteById(id);
        return success(null);
    }

    public ResponseDto<T> success(E data) {
        T mappedData = convertValue(data, responseClass);

        ResponseDto<T> responseModel = new ResponseDto<>();
        responseModel.setElements(Collections.singletonList(mappedData));

        ResponseDto.Status status = new ResponseDto.Status();
        status.setSuccess(true);
        status.setCode(200);

        responseModel.setStatus(status);

        return responseModel;
    }

    public ResponseDto<T> success(List<E> data, Integer pageCount, Integer page, Integer size, Long total) {
        List<T> mappedData = convertListValue(data, responseClass);

        ResponseDto<T> responseModel = new ResponseDto<>();
        responseModel.setElements(mappedData);

        ResponseDto.Status status = new ResponseDto.Status();
        status.setSuccess(true);
        status.setCode(200);

        ResponseDto.Metadata metadata = new ResponseDto.Metadata();
        metadata.setPage(page);
        metadata.setPageCount(pageCount);
        metadata.setPerPage(size);
        metadata.setTotal(total);

        responseModel.setStatus(status);
        responseModel.setMetadata(metadata);

        return responseModel;
    }

    public ResponseDto<T> error(Integer code, String message) {
        ResponseDto<T> responseModel = new ResponseDto<>();

        ResponseDto.Status status = new ResponseDto.Status();
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

    @ExceptionHandler(JDBCException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage InvalidDataException(Exception ex, WebRequest request) {
        System.out.println(ex);
        return new ErrorMessage("Data invalid !!!");
    }
}
