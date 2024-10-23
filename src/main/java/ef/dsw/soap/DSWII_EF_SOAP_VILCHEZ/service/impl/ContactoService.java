package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.exception.NotFoundException;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ContactoRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IContactoService;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert.ContactConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soap.dsw.ef.ws.objects.*;

@RequiredArgsConstructor
@Service
public class ContactoService implements IContactoService {
    private final ContactoRepository contactoRepository;
    private final ContactConvert contactConvert;

    @Override
    public GetContactoRequest listarContacto() {
        GetContactoResponse getContactoResponse = new GetContactoResponse();
        getContactoResponse.getContacto().equals(
            contactConvert.mapToContactowsList(contactoRepository.findAll())
            );
        return null;
}

    @Override
    public GetContactoResponse obtenerContactoxId(Integer id) {
        GetContactoResponse contactoResponse = new GetContactoResponse();
        Contacto contacto = contactoRepository.findById(id).orElse(null);
        if(contacto == null){
            throw new NotFoundException("el contacto con Id" + id+"no existe");
        }
        contactoResponse.setContacto(
                contactConvert.mapToContactows(
                        contactoRepository.findById(id).orElse(null))
        );

        return contactoResponse;
    }

    @Override
    public PostContactoRequest registrarContacto(PostContactoRequest request) {
        PostContactoRequest postContactoRequest = new PostContactoRequest();
        Contacto nuevoContacto = contactoRepository.save(
                contactConvert.maptoContacto(request.getContacto())
        );
        postContactoRequest.setContacto(
                contactConvert.mapToContactows(nuevoContacto));
        return postContactoRequest;
    }

    @Override
    public PutContactoResponse actualizarContacto(PutContactoRequest request) {
        Integer id = request.getContacto().getIdcontacto();

        Contacto contactoExistente = contactoRepository.findById(id).orElseThrow(() ->
                new NotFoundException("El Contacto con ID " + id + " no existe.")
        );

        contactoExistente.setDescContacto(request.getContacto().getDescContacto());
        contactoExistente.setNroContacto(request.getContacto().getNroContacto());
        contactoExistente.setRefContacto(request.getContacto().getRefContacto());

        Contacto contactoActualizado = contactoRepository.save(contactoExistente);
        PutContactoResponse putContactoResponse = new PutContactoResponse();
        putContactoResponse.setContacto(
                contactConvert.mapToContactows(contactoActualizado)
        );

        return putContactoResponse;    }
}
