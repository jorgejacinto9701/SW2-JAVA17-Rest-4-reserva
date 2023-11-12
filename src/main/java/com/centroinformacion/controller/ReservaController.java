package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.centroinformacion.entity.Alumno;
import com.centroinformacion.entity.Libro;

@RestController
@RequestMapping("/rest/reserva")
public class ReservaController {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL_ALUMNO = "http://alumno-service/rest/alumno";
	private static final String URL_LIBRO = "http://libro-service/rest/libro";
	
	@GetMapping()
	public String ejecucion() {
		
		ResponseEntity<List<Alumno>> responseEntity = 	restTemplate.exchange(ReservaController.URL_ALUMNO, HttpMethod.GET, null, new ParameterizedTypeReference<List<Alumno>>(){});
		List<Alumno> lstAlumno = responseEntity.getBody();
		
		ResponseEntity<List<Libro>> responseEntity2 = 	restTemplate.exchange(ReservaController.URL_LIBRO, HttpMethod.GET, null, new ParameterizedTypeReference<List<Libro>>(){});
		List<Libro> lstLibro = responseEntity2.getBody();
		
		return "Se ejecuto Alumno ==> " + lstAlumno.size() + "  Libro ==> " + lstLibro.size();
	}
}
