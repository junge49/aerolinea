package com.Aerolinea;

import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.aerolinea.AgregarVueloRequest;
import org.example.aerolinea.AgregarVueloResponse;
import org.example.aerolinea.BuscarVuelosRequest;
import org.example.aerolinea.BuscarVuelosResponse;
import org.example.aerolinea.ComprarBoletoRequest;
import org.example.aerolinea.ComprarBoletoResponse;
import org.example.aerolinea.ConsultarBoletoRequest;
import org.example.aerolinea.ConsultarBoletoResponse;
import org.example.aerolinea.ConsultarVueloRequest;
import org.example.aerolinea.ConsultarVueloResponse;
import org.example.aerolinea.EditarVueloRequest;
import org.example.aerolinea.EditarVueloResponse;
import org.example.aerolinea.EliminarBoletoRequest;
import org.example.aerolinea.EliminarBoletoResponse;
import org.example.aerolinea.EliminarVueloRequest;
import org.example.aerolinea.EliminarVueloResponse;
import org.example.aerolinea.ModificarBoletoRequest;
import org.example.aerolinea.ModificarBoletoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.Aerolinea.DTO.Boleto;
import com.Aerolinea.DTO.Vuelo;
import com.Aerolinea.Repositorio.IBoleto;
import com.Aerolinea.Repositorio.IVuelo;

@Endpoint
public class EndPoint {
	@Autowired
	private IBoleto iboleto;
	@Autowired
	private IVuelo ivuelo;

	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ComprarBoletoRequest")
	
	@ResponsePayload
	public ComprarBoletoResponse comprarBoleto(@RequestPayload ComprarBoletoRequest datos) {
		ComprarBoletoResponse boleto = new ComprarBoletoResponse();
		boleto.setExito("Su compra ha sido exitosa");
		Boleto ticket = new Boleto();
		ticket.setIdVuelo(datos.getIdVuelo());
		ticket.setNoAsiento(datos.getNoAsiento());
		ticket.setNombre(datos.getNombrePasajero());
		iboleto.save(ticket);
		/*boleto.setExito("Su compra ha sido exitosa.\n ID: "+ datos.getIdBoleto()+"\nSalida: "
				+ vuelo.getSalida() +"\nDestino: "+ vuelo.getDestino()+"\nNumero de asiento: "
				+datos.getNoAsiento()+"\nFecha: "+ vuelo.getFecha()+"\nHora de salida: "+vuelo.getHora()
				+"\nCosto: "+vuelo.getCosto()+"\nNombre de pasajero: "+datos.getNombrePasajero()+".");*/
		return boleto;
	}
	
@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ConsultarBoletoRequest")
	
	@ResponsePayload
	public ConsultarBoletoResponse consultaBoleto(@RequestPayload ConsultarBoletoRequest datos) {
		ConsultarBoletoResponse boleto = new ConsultarBoletoResponse();
		Boleto ticket = new Boleto();
		ticket= iboleto.findById(datos.getIdBoleto()).get();
		boleto.setIdBoleto(ticket.getId());
		boleto.setIdVuelo(ticket.getIdVuelo());
		boleto.setNoAsiento(ticket.getNoAsiento());
		boleto.setNombrePasajero(ticket.getNombre());
		return boleto;
	}

	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "EliminarBoletoRequest")
	
	@ResponsePayload
	public EliminarBoletoResponse eliminarBoleto(@RequestPayload EliminarBoletoRequest datos) {
		EliminarBoletoResponse boleto = new EliminarBoletoResponse();
		boleto.setExito("Su boleto "+ datos.getIdBoleto() +" ha sido cancelado con éxito. ");
		iboleto.deleteById(datos.getIdBoleto());
		return boleto;
	}

	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ModificarBoletoRequest")
	
	@ResponsePayload
	public ModificarBoletoResponse modificarBoleto(@RequestPayload ModificarBoletoRequest datos) {
		ModificarBoletoResponse boleto = new ModificarBoletoResponse();
		boleto.setExito("Su boleto "+ datos.getIdBoleto() +" ha sido modificado con éxito. ");
		return boleto;
	}
	
	//@PayloadRoot(namespace = "http://tempuri.org", localPart = "AgregarVuelo")
	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "AgregarVueloRequest")
	
	@ResponsePayload
	public AgregarVueloResponse agregarVuelo(@RequestPayload AgregarVueloRequest vuelo) {
		AgregarVueloResponse mensaje = new AgregarVueloResponse();
		mensaje.setExito("Su vuelo se ha agregado correctamente.");
		Vuelo v = new Vuelo();
		v.setSalida(vuelo.getSalida());
		v.setDestino(vuelo.getDestino());
		v.setFecha(new java.sql.Date( vuelo.getFecha().getYear()-1900,vuelo.getFecha().getMonth()-1,vuelo.getFecha().getDay()));
		v.setHora(new java.sql.Time(vuelo.getHora().getHour(), vuelo.getHora().getMinute(), vuelo.getHora().getSecond()));
		v.setCosto(vuelo.getCosto());
		v.setNoAsientos(vuelo.getNoAsientos());
		ivuelo.save(v);
		return mensaje;
	}
	
	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "ConsultarVueloRequest")
	
	@ResponsePayload
	public ConsultarVueloResponse consultarVuelo(@RequestPayload ConsultarVueloRequest vuelo) throws DatatypeConfigurationException {
		ConsultarVueloResponse mensaje = new  ConsultarVueloResponse();
		Vuelo v = new Vuelo();
		v=ivuelo.findById(vuelo.getId()).get();
		mensaje.setId(v.getId());
		mensaje.setDestino(v.getDestino());
		mensaje.setSalida(v.getSalida());
		GregorianCalendar d = new GregorianCalendar(); 
		d.setTime(v.getFecha());
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
		GregorianCalendar c = new GregorianCalendar(); 
		c.setTime(v.getHora());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		mensaje.setFecha(date);
		mensaje.setHora(date2);
		mensaje.setNoAsientos(v.getNoAsientos());
		mensaje.setCosto(v.getCosto());
		return mensaje;
	}
	
	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "EditarVueloRequest")
	
	@ResponsePayload
	public EditarVueloResponse editarVuelo(@RequestPayload EditarVueloRequest vuelo) {
		EditarVueloResponse mensaje = new  EditarVueloResponse();
		mensaje.setExito("El vuelo es este.");
		return mensaje;
	}
	
	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "EliminarVueloRequest")
	
	@ResponsePayload
	public EliminarVueloResponse eliminarVuelo(@RequestPayload EliminarVueloRequest vuelo) {
		EliminarVueloResponse mensaje = new  EliminarVueloResponse();
		mensaje.setExito("Vuelo eliminado.");
		ivuelo.deleteById(vuelo.getId());
		return mensaje;
	}
	
	@PayloadRoot(namespace = "http://www.example.org/aerolinea", localPart = "BuscarVuelosRequest")
	
	@ResponsePayload
	public BuscarVuelosResponse buscarVuelos(@RequestPayload BuscarVuelosRequest vuelo) throws DatatypeConfigurationException {
		BuscarVuelosResponse mensaje = new  BuscarVuelosResponse();
		Vuelo v = new Vuelo();
		Iterable<Vuelo> listaV = ivuelo.findAll();
		
		for (Vuelo ls : listaV){
			BuscarVuelosResponse.Vuelos vl = new BuscarVuelosResponse.Vuelos();
			vl.setId(ls.getId());
			vl.setSalida(ls.getSalida());
			vl.setDestino(ls.getDestino());
			GregorianCalendar d = new GregorianCalendar(); 
			d.setTime(ls.getFecha());
			XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
			GregorianCalendar c = new GregorianCalendar(); 
			c.setTime(ls.getHora());
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			vl.setFecha(date);
			vl.setHora(date2);
			vl.setCosto(ls.getCosto());
			mensaje.getVuelos().add(vl);
		}
		
		return mensaje;
	}
}
