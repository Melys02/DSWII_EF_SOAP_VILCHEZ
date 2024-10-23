package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository;


import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre(String nombre);

}
