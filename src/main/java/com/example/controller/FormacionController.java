package com.example.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vo.FormacionResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*" )
public class FormacionController {
	
		
	private static Logger log = LoggerFactory.getLogger(FormacionController.class);
	
	 /**
     * Este metodo es el que se comunica con el front view y da de alta el prospecto en BPD.
     * @param input
	 * @return 
     * @return
     * @throws ClientesException
     */
    @ApiOperation(
    		value = "Genera un saludo con base en la hora del request", 
    		nickname = "Hola Mundo")
	@RequestMapping(
			value = "/{nombre}", method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"})
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = FormacionResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public @ResponseBody FormacionResponse homeTime(@PathVariable String nombre){
    	
    	FormacionResponse response = new FormacionResponse();
    	
    	response.setCodigoRespuesta("OK");
    	response.setMensaje("Hola " + nombre + " " + new Date());
    	return response;
	}

	/**
     * Este metodo es el que se comunica con el front view y da de alta el prospecto en BPD.
     * @param input
	 * @return 
     * @return
     * @throws ClientesException
     */
    @ApiOperation(
    		value = "Genera un echo con base en la hora del request", 
    		nickname = "Echo")
	@RequestMapping(
			value = "/echo/{echo}", method = {RequestMethod.GET},
			produces = {"application/json;charset=UTF-8"})
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = FormacionResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public @ResponseBody FormacionResponse echo(@PathVariable String echo){
    	
    	FormacionResponse response = new FormacionResponse();
    	
    	response.setCodigoRespuesta("OK");
    	response.setMensaje(echo+ " " + new Date());
    	return response;
	}
}
