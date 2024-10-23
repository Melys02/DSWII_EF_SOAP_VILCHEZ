package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTecnico;

    private String nombre;

    private String especialidad;
    @OneToMany
    @JoinColumn(name = "IdTecnico")
    private List<Contacto> contactos;

}
