package com.example.demo.NotFoundA;

import com.example.demo.NotFoundE.SalaNFE;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SalaNFA {
    @ResponseBody
    @ExceptionHandler(SalaNFE.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String SalaNFHandler(SalaNFE excep) {
        return excep.getMessage();
    }

}
