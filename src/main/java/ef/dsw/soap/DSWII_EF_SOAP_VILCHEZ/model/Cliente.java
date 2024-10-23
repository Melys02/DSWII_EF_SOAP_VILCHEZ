package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Setter
@Getter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String tipoCliente;
    private String fechaRegistro;

}
