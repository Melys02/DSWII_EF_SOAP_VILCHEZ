package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "contacto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacto;
    private String descContacto;
    private int nroContacto;
    private String refContacto;

}
