package com.mx.truper.OrdersTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.truper.OrdersTest.entities.OrdenesTable;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenesTable, Long> {

}
