package com.yogesh.storeservice.model.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Y_PRODUCT", schema = "MASTERENTITLEMENTDATA")
@SequenceGenerator(name = "seq", sequenceName = "MASTERENTITLEMENTDATA.Y_PRODUCT_ID_SEQ", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "ID")
	private Integer productId;

	@Column(name = "CODE")
	private String productCode;

	@Column(name = "NAME")
	private String productName;

	@Column(name = "POINTS")
	private Integer productPoints;

}
