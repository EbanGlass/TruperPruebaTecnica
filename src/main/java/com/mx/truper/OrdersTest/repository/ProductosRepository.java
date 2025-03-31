package com.mx.truper.OrdersTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.truper.OrdersTest.entities.ProductosTable;

public interface ProductosRepository extends JpaRepository<ProductosTable, Long> {

	static final String FIND_ALL = "SELECT * FROM PRODUCTOS p WHERE p.orden_id = :id";
	
	@Query(value = FIND_ALL, nativeQuery = true)
	List<ProductosTable> findAllByOrderId(Long id);
	
	
	
}
