package com.irrigation.aliaa.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.irrigation.aliaa.dao.PlotDAO;
import com.irrigation.aliaa.dao.SensorDAO;
import com.irrigation.aliaa.dto.SensorDTO;
import com.irrigation.aliaa.mapper.PlotMapper;
import com.irrigation.aliaa.mapper.SensorMapper;
import com.irrigation.aliaa.pojo.Plot;
import com.irrigation.aliaa.pojo.Sensor;
import com.irrigation.aliaa.requestModel.IrrigatePlotRq;

@Service
public class IrrigationService {

	@Autowired
	SensorDAO sensorDAO;

	@Autowired
	PlotDAO plotDAO;

	@Autowired
	SensorMapper sensorMapper;

	@Autowired
	PlotMapper plotMapper;

	public void addSensor(SensorDTO sensorDTO) {
		Sensor sensor = sensorMapper.map(sensorDTO);
		sensorDAO.save(sensor);
	}

	public void addSensorToPlot(IrrigatePlotRq irrigatePlotRq) {
		Sensor sensor = sensorDAO.findByName(irrigatePlotRq.getSensorName());
		Plot plot = plotDAO.findByName(irrigatePlotRq.getPlotName());
		sensor.setPlot(plot);
		sensorDAO.save(sensor);
	}

	@Scheduled(cron = "0 0 * * * *")
	public void execute() {
		System.out.println(" start sensor every hour ");
		List<Sensor> sensors = sensorDAO.findAll();

		for (Sensor sensor : sensors) {

			LocalTime now = LocalTime.now();

			if (now.isAfter(sensor.getStartHour()) && now.isBefore(sensor.getEndHour()) && !sensor.getIsCompleted()) {

				System.out.println(" start sensor " + sensor.getName());
				// Try to irrigate
				irrigate(sensor);

				// Update sensors
				sensor.setIsCompleted(true);
				sensorDAO.save(sensor);

			}

		}

		System.out.println(" End sensor");
	}

	private void irrigate(Sensor sensor) {
		System.out.println("Irrigating plot: " + sensor.getPlot().getName());
	}

	@Scheduled(cron = "0 0 0 * * *")
	public void resetSensors() {
		System.out.println(" Reset sensor every day ");
		List<Sensor> sensors = sensorDAO.findAll();
		for (Sensor sensor : sensors) {
			sensor.setIsCompleted(false);
			sensorDAO.save(sensor);

		}
	}

}
