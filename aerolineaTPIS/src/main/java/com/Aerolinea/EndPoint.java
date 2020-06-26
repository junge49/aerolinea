package com.Aerolinea;

import org.example.aerolinea.ComprarBoletoRequest;
import org.example.aerolinea.ComprarBoletoResponse;
import org.example.aerolinea.ConsultaBoletoRequest;
import org.example.aerolinea.ConsultarBoletoResponse;
import org.example.aerolinea.EliminarBoletoRequest;
import org.example.aerolinea.EliminarBoletoResponse;
import org.example.aerolinea.ModificarBoletoRequest;
import org.example.aerolinea.ModificarBoletoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EndPoint {

	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ComprarBoletoRequest")
	
	@ResponsePayload
	public ComprarBoletoResponse comprarBoleto(@RequestPayload ComprarBoletoRequest datos) {
		ComprarBoletoResponse boleto = new ComprarBoletoResponse();
		boleto.setExito("Su compra ha sido exitosa. ");
		boleto.setIdBoleto(datos.getIdBoleto());
		boleto.setSalida(datos.getSalida());
		boleto.setDestino(datos.getDestino());
		boleto.setNoAsiento(datos.getNoAsiento());
		boleto.setFecha(datos.getFecha());
		boleto.setHora(datos.getHora());
		boleto.setCosto(datos.getCosto());
		boleto.setNombrePasajero(datos.getNombrePasajero());
		
		return boleto;
	}
	
@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ConsultaBoletoRequest")
	
	@ResponsePayload
	public ConsultarBoletoResponse consultaBoleto(@RequestPayload ConsultaBoletoRequest datos) {
		ConsultarBoletoResponse boleto = new ConsultarBoletoResponse();
		boleto.setExito("Su boleto es: . ");
		boleto.setIdBoleto(datos.getIdBoleto());
		
		return boleto;
	}

@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "EliminarBoletoRequest")

@ResponsePayload
public EliminarBoletoResponse eliminarBoleto(@RequestPayload EliminarBoletoRequest datos) {
	EliminarBoletoResponse boleto = new EliminarBoletoResponse();
	boleto.setExito("Su boleto "+ datos.getIdBoleto() +" ha sido cancelado con éxito. ");
	
	return boleto;
}

@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ModificarBoletoRequest")

@ResponsePayload
public ModificarBoletoResponse modificarBoleto(@RequestPayload ModificarBoletoRequest datos) {
	ModificarBoletoResponse boleto = new ModificarBoletoResponse();
	boleto.setExito("Su boleto "+ datos.getIdBoleto() +" ha sido cancelado con éxito. ");
	
	return boleto;
}
	
}
