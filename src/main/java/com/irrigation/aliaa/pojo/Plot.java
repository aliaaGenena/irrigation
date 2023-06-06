/**
 * 
 */
package com.irrigation.aliaa.pojo;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ALAB39128
 *
 */

@Data
@Entity
@Table(name = "PLOT")
public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CROPTYPE")
	private String cropType;

	@Column(name = "AREA")
	private double area;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="plot")
	private List<Sensor> sensors;

}
