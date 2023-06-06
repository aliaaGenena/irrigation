package com.irrigation.aliaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.irrigation.aliaa.dto.SensorDTO;
import com.irrigation.aliaa.requestModel.IrrigatePlotRq;
import com.irrigation.aliaa.service.IrrigationService;

@RestController
public class IrrigationController {

	@Autowired
	private IrrigationService irrigationService;

	@PostMapping("/addSensor")
	public ResponseEntity<Object> addSensor(@RequestBody SensorDTO sensorDTO) {

		irrigationService.addSensor(sensorDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/addSensorToPlot")
	public ResponseEntity addSensorToPlot(@RequestBody IrrigatePlotRq irrigatePlotRq) {
		irrigationService.addSensorToPlot(irrigatePlotRq);
		return new ResponseEntity(HttpStatus.OK);
	}

}
