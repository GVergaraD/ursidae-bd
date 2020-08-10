package com.example.demo.NotFoundA;

import com.example.demo.NotFoundE.CamaNFE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CamaNFA {
    @ResponseBody
    @ExceptionHandler(CamaNFE.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CamaNFHandler(CamaNFE excep) {
        return excep.getMessage();
    }
}
