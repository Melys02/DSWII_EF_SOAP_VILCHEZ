package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.exception.NotFoundException;
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
       Cliente cliente = clienteRepository.findById(id).orElse(null);
       if(cliente == null){
           throw new NotFoundException("el cliente con Id" + id+"no existe");
       }
       clienteResponse.setCliente(
               clienteConvert.mapToClientews(
                       clienteRepository.findById(id).orElse(null))
               );

        return clienteResponse;
    }

    @Override
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
        PostClienteResponse postClienteResponse = new PostClienteResponse();
        Cliente nuevoCliente = clienteRepository.save(
                clienteConvert.maptoCliente(request.getCliente())
        );
        postClienteResponse.setCliente(
                clienteConvert.mapToClientews(nuevoCliente));
        return postClienteResponse;
    }


    @Override
    public PutClienteResponse actualizarCliente(PutClienteRequest request) {
        Integer id = request.getCliente().getIdcliente();

        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() ->
                new NotFoundException("El cliente con ID " + id + " no existe.")
        );

        clienteExistente.setNombre(request.getCliente().getNombre());
        clienteExistente.setApellido(request.getCliente().getApellido());
        clienteExistente.setCorreo(request.getCliente().getCorreo());
        clienteExistente.setTelefono(request.getCliente().getTelefono());
        clienteExistente.setDireccion(request.getCliente().getDireccion());
        clienteExistente.setTipoCliente(request.getCliente().getTipoCliente());
        clienteExistente.setTipoCliente(request.getCliente().getFechaRegistro());


        Cliente clienteActualizado = clienteRepository.save(clienteExistente);
        PutClienteResponse putClienteResponse = new PutClienteResponse();
        putClienteResponse.setCliente(
                clienteConvert.mapToClientews(clienteActualizado)
        );

        return putClienteResponse;
    }

}
