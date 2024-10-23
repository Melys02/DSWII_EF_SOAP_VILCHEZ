package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;
import org.springframework.stereotype.Component;
import soap.dsw.ef.ws.objects.Clientews;
import soap.dsw.ef.ws.objects.Contactows;

import java.util.ArrayList;
import java.util.List;

@Component

public class ContactConvert {
    public Contacto maptoContacto(Contactows contactows) {

        Contacto contacto = new Contacto();
        contacto.setIdContacto(contactows.getIdcontacto());
        contacto.setDescContacto(contactows.getDescContacto());
        contacto.setNroContacto(contactows.getNroContacto());
        contacto.setRefContacto(contactows.getRefContacto());
        return contacto;
    }
    public Contactows mapToContactows(Contacto contacto){
        Contactows contactows = new Contactows();
        contactows.setIdcontacto(contacto.getIdContacto());
        contactows.setDescContacto(contacto.getDescContacto());
        contactows.setNroContacto(contacto.getNroContacto());
        contactows.setRefContacto(contacto.getRefContacto());
        return contactows;
    }
    public List<Contactows> mapToContactoList(List<Contacto> contactoList){
        List<Contactows> contactowsList = new ArrayList<>();
        for (Contacto contacto : contactoList){
            contactowsList.add(mapToContactows(contacto));
        }
        return contactowsList;
    }
    public List<Contactows> mapToContactowsList(List<Contacto> contactoList){
        List<Contactows> contactowsList = new ArrayList<>();
        for (Contacto contacto : contactoList){
            contactowsList.add(mapToContactows(contacto));
        }
        return contactowsList;
    }


}
