package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ClienteRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IClienteSevice;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert.ClienteConvert;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soap.dsw.ef.ws.objects.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteSevice {

    private final ClienteRepository clienteRepository;
private  final ClienteConvert clienteConvert;

    @Override
    public GetClienteResponse listarClientes() {
        GetClienteResponse getClienteResponse = new GetClienteResponse();
        getClienteResponse.getCliente().equals(
                clienteConvert.mapToClientewsList(clienteRepository.findAll())
        );
        return null;
    }

    @Override
    public GetClienteResponse obtenerClientexId(Integer id) {
       GetClienteResponse clienteResponse = new GetClienteResponse();
       clienteResponse.setCliente(
               clienteConvert.mapToClientews(
                       clienteRepository.findById(id).orElse(null))
               );

        return clienteResponse;
    }

    @Override
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
        return null;
    }

    @Override
    public PutClienteResponse actualizarCliente(PutClienteRequest request) {
        return null;
    }
}
