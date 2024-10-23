package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service;

import soap.dsw.ef.ws.objects.*;

public interface IProductoService {
    GetProductoRequest listarProducto();
    GetProductoResponse obtenerProductoxId(Integer id);
    BuscarProductoResponse buscarProducto(String nombre);
    PostProductoResponse registrarProducto(PostProductoRequest request);
    PutProductoResponse actualizarProducto(PutProductoRequest request);
}
