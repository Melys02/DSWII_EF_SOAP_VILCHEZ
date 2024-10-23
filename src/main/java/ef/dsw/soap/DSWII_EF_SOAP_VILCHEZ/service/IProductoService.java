package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Cliente;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Producto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ProductoRepository;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProducto();
    Producto obtenerProductoxId(Integer id);
    List<Producto> buscarProducto(String nombre);
    Producto registrarProducto(Producto producto);
    Producto actualizarProducto(Integer id, Producto producto);
}
