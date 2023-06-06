package com.irrigation.aliaa.dto;

import java.time.LocalTime;
import lombok.Data;

@Data
public class SensorDTO {

	private String name;
	private LocalTime startHour;
	private LocalTime endHour;
	private Boolean isCompleted;
	private double waterQuantity;

}
