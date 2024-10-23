package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
