package com.irrigation.aliaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.irrigation.aliaa.dto.PlotDTO;
import com.irrigation.aliaa.service.PlotService;

@RestController
public class PlotController {

	@Autowired
	PlotService plotService;

	@PostMapping("/addPlot")
	public ResponseEntity addPlot(@RequestBody PlotDTO plotDTO) {
		plotService.addPlot(plotDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/editPlot")
	public ResponseEntity editPlot(@RequestBody PlotDTO plotDTO) {

		plotService.updatePlot(plotDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/listAllPlot")
	public ResponseEntity<List<PlotDTO>> listAllPlot() {

		List<PlotDTO> plotList = plotService.findAllPlots();
		return new ResponseEntity<List<PlotDTO>>(plotList, HttpStatus.OK);
	}

	
	@GetMapping("/plot/name/{name}")
	public ResponseEntity<PlotDTO> findPlotByName(@PathVariable("name") String name) {

		PlotDTO plotDTO = plotService.findPlotByName(name);
		return new ResponseEntity<PlotDTO>(plotDTO, HttpStatus.OK);
	}
	
}
