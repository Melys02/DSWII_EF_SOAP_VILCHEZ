package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.exception.NotFoundException;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Producto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ProductoRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IProductoService;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert.ProductoConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soap.dsw.ef.ws.objects.*;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService{
    private final ProductoRepository productoRepository;
private final ProductoConvert productoConvert;

    @Override
    public GetProductoRequest listarProducto() {
        GetProductoResponse getClienteResponse = new GetProductoResponse();
        getClienteResponse.getProducto().equals(
                productoConvert.mapToProductowsList(productoRepository.findAll())
        );
        return null;
    }

    @Override
    public GetProductoResponse obtenerProductoxId(Integer id) {
        GetProductoResponse productoResponse = new GetProductoResponse();
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto == null){
            throw new NotFoundException("el producto con Id" + id+"no existe");
        }
        productoResponse.setProducto(
                productoConvert.mapToProductows(
                        productoRepository.findById(id).orElse(null))
        );

        return productoResponse;
    }

    @Override
    public BuscarProductoResponse buscarProducto(String nombre) {
        BuscarProductoResponse buscarProductoResponse = new BuscarProductoResponse();
        return buscarProductoResponse;
    }

    public PostProductoResponse registrarProducto(PostProductoRequest request) {
        PostProductoResponse postProductoResponse = new PostProductoResponse();
        Producto nuevoProducto = productoRepository.save(
                productoConvert.maptoProducto(request.getProducto())
        );
        PostProductoResponse.setProducto(
                productoConvert.mapToProductows(nuevoProducto));
        return postProductoResponse;
    }

    @Override
    public PutProductoResponse actualizarProducto(PutProductoRequest request) {
        Integer id = request.getProducto().getIdproducto();

        Producto productoExistente = productoRepository.findById(id).orElseThrow(() ->
                new NotFoundException("El producto con ID " + id + " no existe.")
        );

        productoExistente.setNombre(request.getProducto().getNombre());
        productoExistente.setNombre(request.getProducto().getNombre());
        productoExistente.setDescripcion(request.getProducto().getDescripcion());
        productoExistente.setPrecio(request.getProducto().getPrecio());
        productoExistente.setMarca(request.getProducto().getMarca());
        productoExistente.setStock(request.getProducto().getStock());
        productoExistente.setCategoria(request.getProducto().getCategoria());
        productoExistente.setFechaIngreso(request.getProducto().getFechaIngreso());


        Producto productoActualizado = productoRepository.save(productoExistente);
        PutProductoResponse putProductoResponse = new PutProductoResponse();
        putProductoResponse.setProducto(
                productoConvert.mapToProductows(productoActualizado));

        return putProductoResponse;
    }

}
