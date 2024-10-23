package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ContactoRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IContactoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactoService implements IContactoService {
    private final ContactoRepository contactoRepository;

    @Override
    public List<Contacto> listarContacto() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto obtenerContactoxId(Integer id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public Contacto registrarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    @Override
    public Contacto actualizarContacto(Integer id, Contacto contacto) {

        Optional<Contacto> contactoOpt = contactoRepository.findById(id);
        if (contactoOpt.isPresent()) {
            Contacto contactoExistente = contactoOpt.get();
            contactoExistente.setDescContacto(contacto.getDescContacto());
            contactoExistente.setNroContacto(contacto.getIdContacto());
            contactoExistente.setNroContacto(contacto.getNroContacto());
            return contactoRepository.save(contactoExistente);
        } else {
            throw new EntityNotFoundException("Contacto con id " + id + " no encontrado");
        }
    }
}