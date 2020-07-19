package com.salaoarrazus.controller.exception;

import java.util.NoSuchElementException;

import com.salaoarrazus.SalaoArrazusApplication;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ExceptionConfig {

    private static Logger logger = LoggerFactory.getLogger(SalaoArrazusApplication.class);

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ModelAndView constraintViolationException(Exception ex) {
        logger.error("# Exception constraintViolationException, com LocalizedMessage: " + ex.getLocalizedMessage() + " - cause: " + ex.getCause());
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", HttpStatus.CONFLICT.value() + " - " + HttpStatus.CONFLICT.name());
        mv.addObject("descricaoCode",
                "A solicitação não pôde ser concluída devido a um conflito com o estado atual do recurso.");
        mv.addObject("detalhe", "Não é possivel alterar esse dado, pois agora está vinculado a outras informações.");
        mv.setViewName("exceptions/general-exception.html");
        return mv;
    }

    @ExceptionHandler({BindException.class, NoSuchElementException.class})
    public ModelAndView bindNoSuchException(Exception ex) {
        logger.error("# Exception bindNoSuchException, com LocalizedMessage: " + ex.getLocalizedMessage() + " - cause: " + ex.getCause());
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", HttpStatus.BAD_REQUEST.value() + " - " + HttpStatus.BAD_REQUEST.name());
        mv.addObject("descricaoCode",
                "O servidor não entendeu a requisição pois está com uma sintaxe inválida.");
        mv.addObject("detalhe", "Validar os dados informados, há algo incorreto.");
        mv.setViewName("exceptions/general-exception.html");
        return mv;
    }
}