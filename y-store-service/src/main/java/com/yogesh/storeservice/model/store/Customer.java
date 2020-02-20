package com.yogesh.storeservice.model.store;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Y_CUSTOMER", schema = "MASTERENTITLEMENTDATA")
@SequenceGenerator(name = "seq", sequenceName = "MASTERENTITLEMENTDATA.Y_CUSTOMER_ID_SEQ", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "ID")
	private Integer customerId;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "NAME")
	private String customerName;

	@Column(name = "TOTAL_DAY_POINT")
	private Integer totalDayPoints;

	@OneToMany 
	@JoinColumn(name = "ID")
	private List<Purchase> purchases = new ArrayList<Purchase>();

	
}
