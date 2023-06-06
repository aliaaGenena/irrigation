package com.irrigation.aliaa.pojo;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SENSOR")
public class Sensor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STARTHOUR")
	private LocalTime startHour;

	@Column(name = "ENDHOUR")
	private LocalTime endHour;

	@Column(name = "WATERQUANTITY")
	private double waterQuantity;
	
	@Column(name = "ISCOMPLETED")
	private Boolean isCompleted;

	@ManyToOne
	@JoinColumn(name="Plot_ID")
	private Plot plot;

}
