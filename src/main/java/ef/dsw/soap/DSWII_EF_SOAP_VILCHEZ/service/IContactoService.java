package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import soap.dsw.ef.ws.objects.*;

public interface IContactoService {
    GetContactoRequest listarContacto();
    GetContactoResponse obtenerContactoxId(Integer id);
    PostContactoRequest registrarContacto(PostContactoRequest request);
    PutContactoResponse actualizarContacto(PutContactoRequest request);
}
