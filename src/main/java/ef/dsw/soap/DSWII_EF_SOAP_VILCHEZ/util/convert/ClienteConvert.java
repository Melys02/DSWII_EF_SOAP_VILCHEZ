package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import org.springframework.stereotype.Component;
import soap.dsw.ef.ws.objects.Clientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConvert {
    public Cliente maptoCliente(Clientews clientews) {

        return Cliente.builder()
                .idcliente(clientews.getIdcliente())
                .nombre(clientews.getNombre())
                .apellido(clientews.getApellido())
                .correo(clientews.getCorreo())
            .direccion(clientews.getDireccion())
                .tipoCliente(clientews.getTipoCliente())
                .fechaRegistro(clientews.getFechaRegistro()).build();
    }
public Clientews mapToClientews(Cliente cliente){
        Clientews clientews = new Clientews();
        clientews.setIdcliente(cliente.getIdcliente());
        clientews.setNombre(cliente.getNombre());
        clientews.setApellido(cliente.getApellido());
        clientews.setCorreo(cliente.getCorreo());
        clientews.setDireccion(cliente.getDireccion());
        clientews.setTipoCliente(cliente.getTipoCliente());
        clientews.setFechaRegistro(cliente.getFechaRegistro());
        return clientews;
}
public List<Clientews> mapToClienteList(List<Cliente> clienteList){
    List<Clientews> clientewsList = new ArrayList<>();
    for (Cliente cliente : clienteList){
        clientewsList.add(mapToClientews(cliente));
    }
    return clientewsList;
}
    public List<Clientews> mapToClientewsList(List<Cliente> clienteList){
        List<Clientews> clientewsList = new ArrayList<>();
        for (Cliente cliente : clienteList){
            clientewsList.add(mapToClientews(cliente));
        }
        return clientewsList;
    }



}

