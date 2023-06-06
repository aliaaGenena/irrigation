package com.irrigation.aliaa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.aliaa.pojo.Plot;

@Repository
public interface PlotDAO extends JpaRepository<Plot, Integer> {

	public Plot findByName(String plotName);

}
