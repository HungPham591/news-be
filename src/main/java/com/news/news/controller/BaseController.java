package com.news.news.controller;

import com.news.news.dto.response.ResponseModel;
import org.hibernate.JDBCException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

public class BaseController<T> {
    @ExceptionHandler(JDBCException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage InvalidDataException(Exception ex, WebRequest request) {
        System.out.println(ex);
        return new ErrorMessage("Data invalid !!!");
    }

    public ResponseModel<T> success(T data) {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setElements(Arrays.asList(data));

        ResponseModel.Status status = new ResponseModel.Status();
        status.setSuccess(true);
        status.setCode(200);

        responseModel.setStatus(status);

        return responseModel;
    }

    public ResponseModel<T> success(List<T> data, Integer pageCount, Integer page, Integer size, Long total) {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setElements(data);

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

    public ResponseModel<T> error(Integer code, String message){
        ResponseModel<T> responseModel = new ResponseModel<>();

        ResponseModel.Status status = new ResponseModel.Status();
        status.setSuccess(false);
        status.setCode(code);
        status.setErrors(message);

        responseModel.setStatus(status);

        return responseModel;
    }
}
