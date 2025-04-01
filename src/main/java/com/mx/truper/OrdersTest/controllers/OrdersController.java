package com.mx.truper.OrdersTest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.truper.OrdersTest.entities.OrdenesTable;
import com.mx.truper.OrdersTest.services.OrdenService;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

	private final OrdenService service;
	
	public OrdersController(OrdenService service) {
		super();
		this.service = service;
	}

	@PutMapping
	public void actualizarPrecioProductoOrden(@RequestBody OrdenesTable orden) {
		
		service.actualizaPrecio(orden);
		
	}

	@PostMapping
	public Long crearOrden(@RequestBody OrdenesTable orden) {

		return service.crearOrden(orden);

	}

	@GetMapping(value = "/{id}")
	public OrdenesTable consultaOrden(@PathVariable("id") Long id) {

		return service.consultaOrden(id);

	}

}
