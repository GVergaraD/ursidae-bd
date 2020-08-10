package com.example.demo.NotFoundA;

import com.example.demo.NotFoundE.PRNFE;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PRNFA {
    @ResponseBody
    @ExceptionHandler(PRNFE.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String PRNFHandler(PRNFE excep) {
        return excep.getMessage();
    }
}
