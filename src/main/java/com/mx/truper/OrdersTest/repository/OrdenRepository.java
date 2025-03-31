package com.mx.truper.OrdersTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.truper.OrdersTest.entities.OrdenTable;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenTable, Long> {

}
