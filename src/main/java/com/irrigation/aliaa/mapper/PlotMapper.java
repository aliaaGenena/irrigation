package com.irrigation.aliaa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import com.irrigation.aliaa.dto.PlotDTO;
import com.irrigation.aliaa.pojo.Plot;

@Component
@Mapper(componentModel = "spring") 
public interface PlotMapper {
	

    Plot map(PlotDTO plot);
    PlotDTO map(Plot plot);
    List<PlotDTO> map(List<Plot> plots);

}
