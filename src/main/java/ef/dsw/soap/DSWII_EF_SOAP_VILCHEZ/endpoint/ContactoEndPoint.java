package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.endpoint;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.dsw.ef.ws.objects.*;
@Endpoint

public class ContactoEndPoint {
    private static final String NAMESPACE_URI = "http://www.ef.dsw.soap/ws/objects";
    @Autowired
    private IContactoService contactoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactosRequest")
    public GetContactoRequest getContactoResponse(@RequestPayload
                                          GetContactosRequest request){
        return contactoService.listarContacto();

    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactoRequest")
    @ResponsePayload
    public GetContactoResponse getContactoXid(
            @RequestPayload GetContactoRequest request){
        return contactoService.obtenerContactoxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postContactoRequest")
    @ResponsePayload
    public PostContactoRequest saveContacto(@RequestPayload
                                           PostContactoRequest request){
        return contactoService.registrarContacto(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putContactoRequest")
    @ResponsePayload
    public PutContactoResponse actualizarContacto(@RequestPayload PutContactoRequest request) {
        return contactoService.actualizarContacto(request);
    }

}
