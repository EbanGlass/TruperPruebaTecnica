package com.mx.truper.OrdersTest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.truper.OrdersTest.entities.UserTable;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
	
	Optional<UserTable> findByUsername(String username);

}
