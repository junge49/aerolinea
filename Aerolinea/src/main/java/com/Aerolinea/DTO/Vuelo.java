package com.Aerolinea.DTO;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String salida;
	private String destino;
	private Date fecha;
	private Time hora;
	private Integer costo;
	private Integer noAsientos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public Integer getNoAsientos() {
		return noAsientos;
	}
	public void setNoAsientos(Integer noAsientos) {
		this.noAsientos = noAsientos;
	}	
}
