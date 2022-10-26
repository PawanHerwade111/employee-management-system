package com.employee.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "email", unique=true)
	private String email;
	
	@Column(name = "mob_no")
	private String mobileNo;
	
	@Column
	private String location;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	    
	@Column
	@UpdateTimestamp
	private LocalDateTime lastModifiedAt;
	
	@ManyToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "department", referencedColumnName = "dept_Id")
	private Department department;

}
