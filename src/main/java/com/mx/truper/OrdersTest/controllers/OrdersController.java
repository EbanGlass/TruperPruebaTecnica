package com.mx.truper.OrdersTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.truper.OrdersTest.beans.Orden;
import com.mx.truper.OrdersTest.services.OrdenService;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

	@Autowired
	private OrdenService service;

	@PostMapping
	public Long crearOrden(@RequestBody Orden orden) {

		return service.salvarOrden(orden);

	}

	@GetMapping(value = "/{id}")
	public Orden consultaOrden(@PathVariable("id") Long id) {

		return service.ConsultaOrden(id);

	}

}
