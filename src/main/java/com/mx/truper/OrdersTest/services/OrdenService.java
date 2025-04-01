package com.mx.truper.OrdersTest.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mx.truper.OrdersTest.entities.OrdenesTable;
import com.mx.truper.OrdersTest.entities.ProductosTable;
import com.mx.truper.OrdersTest.repository.OrdenRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrdenService {

	private final OrdenRepository ordenRepository;
	
	public OrdenService(OrdenRepository ordenRepository) {
		
		super();
		this.ordenRepository = ordenRepository;
		
	}

	public void actualizaPrecio(OrdenesTable orden) {

		Optional<OrdenesTable> ordenTable = ordenRepository.findById(orden.getId());

		if (ordenTable.isPresent()) {

			ordenTable.get().getProductos().forEach(producto -> {
				if (producto.getCodigo().equals(orden.getProductos().get(0).getCodigo())) {
					producto.setPrecio(orden.getProductos().get(0).getPrecio());
				}
			});

			ordenRepository.save(ordenTable.get());

		} else {

			log.info("Orden inexistente");

		}

	}

	public OrdenesTable consultaOrden(Long ordenId) {

		Optional<OrdenesTable> ordenTable = ordenRepository.findById(ordenId);

		return ordenTable.isPresent() ? ordenTable.get() : new OrdenesTable();

	}

	public Long crearOrden(OrdenesTable orden) {

		orden.setTotal(calculaTotal(orden.getProductos()));

		// ordenTable.setTotal(BigDecimal.valueOf(orden.getProductos().stream().mapToDouble(producto
		// -> producto.getPrecio().doubleValue()).sum()));

		orden = ordenRepository.save(orden);

		return orden.getId();

	}

	/**
	 * Este metodo calcula con mayor precision que usar una lamba con tipos Double
	 */
	private BigDecimal calculaTotal(List<ProductosTable> list) {

		BigDecimal total = BigDecimal.ZERO;

		for (ProductosTable productosTable : list) {
			total = total.add(productosTable.getPrecio());
		}

		return total;

	}

}
