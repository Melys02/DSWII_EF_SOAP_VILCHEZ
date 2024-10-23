package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.endpoint;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IClienteSevice;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.dsw.ef.ws.objects.*;

@Endpoint
public class ClienteEndPoint {
    private static final String NAMESPACE_URI = "http://www.ef.dsw.soap/ws/objects";
@Autowired
    private IClienteSevice clienteSevice;

@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientesRequest")
public GetClienteResponse getClientes(@RequestPayload
                                         GetClientesRequest request){
    return clienteSevice.listarClientes();

}
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClienteRequest")
    @ResponsePayload
    public GetClienteResponse getClienteXid(
            @RequestPayload GetClienteRequest request){
        return clienteSevice.obtenerClientexId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postClienteRequest")
    @ResponsePayload
    public PostClienteResponse saveCliente(@RequestPayload
                                               PostClienteRequest request){
        return clienteSevice.registrarCliente(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putClienteRequest")
    @ResponsePayload
    public PutClienteResponse actualizarCliente(@RequestPayload PutClienteRequest request) {
        return clienteSevice.actualizarCliente(request);
    }




}
