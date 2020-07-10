package com.Aerolinea.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boleto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idVuelo;
	private String nombre;
	private Integer noAsiento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNoAsiento() {
		return noAsiento;
	}
	public void setNoAsiento(Integer noAsiento) {
		this.noAsiento = noAsiento;
	}
}
