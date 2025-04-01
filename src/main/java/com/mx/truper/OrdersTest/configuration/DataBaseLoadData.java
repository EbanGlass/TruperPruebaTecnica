package com.mx.truper.OrdersTest.configuration;

import org.springframework.context.annotation.Configuration;

import com.mx.truper.OrdersTest.entities.SucursalesTable;
import com.mx.truper.OrdersTest.repository.SucursalesRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataBaseLoadData {
	
	private final SucursalesRepository sucursalesRepository;
	
	public DataBaseLoadData(SucursalesRepository sucursalesRepository) {
		super();
		this.sucursalesRepository = sucursalesRepository;
	}



	@PostConstruct
	public void init() {
		
		SucursalesTable sucursalesTable =  new SucursalesTable();
		
		sucursalesTable.setNombre("CDMX");
		
		sucursalesRepository.save(sucursalesTable);
		
	}

}
