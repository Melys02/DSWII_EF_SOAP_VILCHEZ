package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ClienteRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IClienteSevice;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteSevice {

    private final ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientexId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        if (clienteOpt.isPresent()) {
            Cliente clienteExistente = clienteOpt.get();
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setCorreo(cliente.getCorreo());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDireccion(cliente.getDireccion());

            return clienteRepository.save(clienteExistente);
        } else {
            throw new EntityNotFoundException("Cliente con id " + id + " no encontrado");
        }
    }
}
