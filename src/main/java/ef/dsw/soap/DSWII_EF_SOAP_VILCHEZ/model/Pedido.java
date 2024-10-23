package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idpedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    private String fechaPedido;
    private double total;

}
