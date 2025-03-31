package com.mx.truper.OrdersTest.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.truper.OrdersTest.beans.Orden;
import com.mx.truper.OrdersTest.entities.OrdenTable;
import com.mx.truper.OrdersTest.entities.ProductosTable;
import com.mx.truper.OrdersTest.repository.OrdenRepository;
import com.mx.truper.OrdersTest.repository.ProductosRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrdenService {
	
	@Autowired
	private OrdenRepository ordenRepository;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	//public void ActualizaPrecio()
	
	
	public Orden ConsultaOrden(Long ordenId) {
		
		Orden orden = new Orden();
		
		Optional<OrdenTable> ordenTable = ordenRepository.findById(ordenId);
		 
		orden.setId(ordenTable.get().getId());
		orden.setFecha(ordenTable.get().getFecha());
		orden.setSucursalId(ordenTable.get().getSucursalId());
		orden.setTotal(ordenTable.get().getTotal());
		
		orden.setProductos(productosRepository.findAllByOrderId(orden.getId()));
		
		return orden;
		
	}
	
	
	public Long salvarOrden(Orden orden) {
		
		log.info("service");
		
		OrdenTable ordenTable = new OrdenTable();
		ordenTable.setFecha(orden.getFecha());
		ordenTable.setSucursalId(orden.getSucursalId());
		
		BigDecimal total = new BigDecimal(0);
		ordenTable.setTotal(total);
		
		OrdenTable reg = ordenRepository.save(ordenTable);
		
		for (ProductosTable productosTable : orden.getProductos()) {
			
			productosTable.setOrdenId(reg.getId());
			
			productosRepository.save(productosTable);
			
		}
		
		return reg.getId();
		
	}

}
