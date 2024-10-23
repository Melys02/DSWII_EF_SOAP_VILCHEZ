package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.endpoint;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.dsw.ef.ws.objects.*;

@Endpoint

public class ProductoEndPoint {

    private static final String NAMESPACE_URI = "http://www.ef.dsw.soap/ws/objects";
    @Autowired
    private IProductoService productoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosRequest")
    public GetProductoRequest getProductos(@RequestPayload
                                          GetProductosRequest request){
        return productoService.listarProducto();

    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getProductoXid(
            @RequestPayload GetProductoRequest request){
        return productoService.obtenerProductoxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductoRequest")
    @ResponsePayload
    public PostProductoResponse saveProducto(@RequestPayload
                                           PostProductoRequest request){
        return productoService.registrarProducto(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putProductoRequest")
    @ResponsePayload
    public PutProductoResponse actualizarProducto(@RequestPayload PutProductoRequest request) {
        return productoService.actualizarProducto(request);
    }

}
