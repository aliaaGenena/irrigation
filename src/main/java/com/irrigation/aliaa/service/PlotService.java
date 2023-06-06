package com.irrigation.aliaa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.aliaa.dao.PlotDAO;
import com.irrigation.aliaa.dto.PlotDTO;
import com.irrigation.aliaa.mapper.PlotMapper;
import com.irrigation.aliaa.pojo.Plot;

@Service
public class PlotService {

	@Autowired
	PlotMapper plotMapper;

	@Autowired
	PlotDAO plotDAO;

	public void addPlot(PlotDTO plotDTO) {
		Plot plot = plotMapper.map(plotDTO);
		plotDAO.save(plot);

	}

	public void updatePlot(PlotDTO plotDTO) {

		Plot plot = plotDAO.findByName(plotDTO.getName());
		plot.setName(plotDTO.getName());
		plot.setArea(plotDTO.getArea());
		plot.setCropType(plotDTO.getCropType());

		plotDAO.save(plot);

	}

	public void deletePlot(String name) {
		Plot plot = plotDAO.findByName(name);
		plotDAO.delete(plot);
	}

	public List<PlotDTO> findAllPlots() {
		List<Plot> plots = plotDAO.findAll();
		return plotMapper.map(plots);
	}

	public PlotDTO findPlotById(int id) {
		Optional<Plot> plot = plotDAO.findById(id);
		return plotMapper.map(plot.get());
	}
	
	
	public PlotDTO findPlotByName(String name) {
		Plot plot = plotDAO.findByName(name);
		return plotMapper.map(plot);
	}

}
