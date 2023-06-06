package com.irrigation.aliaa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.irrigation.aliaa.dto.SensorDTO;
import com.irrigation.aliaa.pojo.Sensor;

@Component
@Mapper(componentModel = "spring") 
public interface SensorMapper {

	SensorDTO map(Sensor sensor);

	Sensor map(SensorDTO sensorDTO);

	List<SensorDTO> map(List<Sensor> sensor);

}
