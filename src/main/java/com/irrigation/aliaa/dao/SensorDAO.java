package com.irrigation.aliaa.dao;

import org.springframework.stereotype.Repository;

import com.irrigation.aliaa.pojo.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SensorDAO extends JpaRepository<Sensor, Integer> {

	public Sensor findByName(String sensorName);

}
