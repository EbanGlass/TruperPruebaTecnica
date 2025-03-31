package com.mx.truper.OrdersTest.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ORDENES")
public class OrdenTable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "sucursal_id")
	private Long sucursalId;
	
	@Column(name = "fecha")
	private Timestamp fecha;
	
	@Column(name = "total")
	private BigDecimal total;

}
