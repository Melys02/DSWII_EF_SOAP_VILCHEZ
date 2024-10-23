package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import ch.qos.logback.core.net.server.Client;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import soap.dsw.ef.ws.objects.*;

import java.util.List;

public interface IClienteSevice {

    GetClienteResponse listarClientes();
    GetClienteResponse obtenerClientexId(Integer id);
    PostClienteResponse registrarCliente(PostClienteRequest request);
    PutClienteResponse actualizarCliente(PutClienteRequest request);

}
