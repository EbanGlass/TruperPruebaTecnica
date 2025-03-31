package com.mx.truper.OrdersTest.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.mx.truper.OrdersTest.entities.ProductosTable;

import lombok.Data;

@Data
public class Orden {
	
	private Long id;
	
	private Long sucursalId;
	
	private Timestamp fecha;
	
	private BigDecimal total;
	
	private List<ProductosTable> productos;

}
