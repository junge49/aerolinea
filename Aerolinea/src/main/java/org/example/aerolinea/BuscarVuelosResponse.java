//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.07.10 a las 04:47:47 PM CDT 
//


package org.example.aerolinea;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vuelos" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="salida" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="destino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                   &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vuelos"
})
@XmlRootElement(name = "BuscarVuelosResponse")
public class BuscarVuelosResponse {

    @XmlElement(name = "Vuelos", required = true)
    protected List<BuscarVuelosResponse.Vuelos> vuelos;

    /**
     * Gets the value of the vuelos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vuelos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVuelos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuscarVuelosResponse.Vuelos }
     * 
     * 
     */
    public List<BuscarVuelosResponse.Vuelos> getVuelos() {
        if (vuelos == null) {
            vuelos = new ArrayList<BuscarVuelosResponse.Vuelos>();
        }
        return this.vuelos;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="salida" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="destino" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "salida",
        "destino",
        "fecha",
        "hora",
        "costo"
    })
    public static class Vuelos {

        protected int id;
        @XmlElement(required = true)
        protected String salida;
        @XmlElement(required = true)
        protected String destino;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fecha;
        @XmlElement(required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar hora;
        protected int costo;

        /**
         * Obtiene el valor de la propiedad id.
         * 
         */
        public int getId() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         */
        public void setId(int value) {
            this.id = value;
        }

        /**
         * Obtiene el valor de la propiedad salida.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSalida() {
            return salida;
        }

        /**
         * Define el valor de la propiedad salida.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSalida(String value) {
            this.salida = value;
        }

        /**
         * Obtiene el valor de la propiedad destino.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestino() {
            return destino;
        }

        /**
         * Define el valor de la propiedad destino.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestino(String value) {
            this.destino = value;
        }

        /**
         * Obtiene el valor de la propiedad fecha.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFecha() {
            return fecha;
        }

        /**
         * Define el valor de la propiedad fecha.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFecha(XMLGregorianCalendar value) {
            this.fecha = value;
        }

        /**
         * Obtiene el valor de la propiedad hora.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getHora() {
            return hora;
        }

        /**
         * Define el valor de la propiedad hora.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setHora(XMLGregorianCalendar value) {
            this.hora = value;
        }

        /**
         * Obtiene el valor de la propiedad costo.
         * 
         */
        public int getCosto() {
            return costo;
        }

        /**
         * Define el valor de la propiedad costo.
         * 
         */
        public void setCosto(int value) {
            this.costo = value;
        }

    }

}
