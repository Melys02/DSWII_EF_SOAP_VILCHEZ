package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import ch.qos.logback.core.net.server.Client;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;

import java.util.List;

public interface IClienteSevice {

    List<Cliente> listarClientes();
    Cliente obtenerClientexId(Integer id);
    Cliente registrarCliente(Cliente cliente);
    Cliente actualizarCliente(Integer id, Cliente cliente);

}
