//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.07.10 a las 04:47:47 PM CDT 
//


package org.example.aerolinea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="exito" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "exito"
})
@XmlRootElement(name = "EditarVueloResponse")
public class EditarVueloResponse {

    @XmlElement(required = true)
    protected String exito;

    /**
     * Obtiene el valor de la propiedad exito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExito() {
        return exito;
    }

    /**
     * Define el valor de la propiedad exito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExito(String value) {
        this.exito = value;
    }

}
