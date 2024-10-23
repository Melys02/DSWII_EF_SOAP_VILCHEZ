package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;

import java.util.List;

public interface IContactoService {
    List<Contacto> listarContacto();
    Contacto obtenerContactoxId(Integer id);
    Contacto registrarContacto(Contacto contacto);
    Contacto actualizarContacto(Integer id, Contacto contacto);
}
