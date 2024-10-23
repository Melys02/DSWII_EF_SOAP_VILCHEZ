//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.23 a las 06:47:30 AM PET 
//


package soap.dsw.ef.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contactows complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contactows"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idcontacto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descContacto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="refContacto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nroContacto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactows", propOrder = {
    "idcontacto",
    "descContacto",
    "refContacto",
    "nroContacto"
})
public class Contactows {

    protected int idcontacto;
    @XmlElement(required = true)
    protected String descContacto;
    @XmlElement(required = true)
    protected String refContacto;
    protected int nroContacto;

    /**
     * Obtiene el valor de la propiedad idcontacto.
     * 
     */
    public int getIdcontacto() {
        return idcontacto;
    }

    /**
     * Define el valor de la propiedad idcontacto.
     * 
     */
    public void setIdcontacto(int value) {
        this.idcontacto = value;
    }

    /**
     * Obtiene el valor de la propiedad descContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescContacto() {
        return descContacto;
    }

    /**
     * Define el valor de la propiedad descContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescContacto(String value) {
        this.descContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad refContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefContacto() {
        return refContacto;
    }

    /**
     * Define el valor de la propiedad refContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefContacto(String value) {
        this.refContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad nroContacto.
     * 
     */
    public int getNroContacto() {
        return nroContacto;
    }

    /**
     * Define el valor de la propiedad nroContacto.
     * 
     */
    public void setNroContacto(int value) {
        this.nroContacto = value;
    }

}
