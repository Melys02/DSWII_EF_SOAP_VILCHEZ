package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.util.convert;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Producto;
import org.springframework.stereotype.Component;
import soap.dsw.ef.ws.objects.Productows;

import java.util.ArrayList;
import java.util.List;

@Component

public class ProductoConvert {
    public Producto maptoProducto(Producto productows) {

        Producto producto = new Producto();
        producto.setIdproducto(productows.getIdproducto());
        producto.setNombre(productows.getNombre());
        producto.setDescripcion(productows.getDescripcion());
        producto.setPrecio(productows.getPrecio());
        producto.setMarca(productows.getMarca());
        producto.setStock(productows.getStock());
        producto.setCategoria(productows.getCategoria());
        producto.setFechaIngreso(productows.getFechaIngreso());

        return producto;
    }
    public Productows mapToProductows(Producto producto){
        Productows productows = new Productows();
        productows.setIdproducto(producto.getIdproducto());
        productows.setNombre(producto.getNombre());
        productows.setDescripcion(producto.getDescripcion());
        productows.setPrecio(producto.getPrecio());
        productows.setMarca(producto.getMarca());
        productows.setStock(producto.getStock());
        productows.setCategoria(producto.getCategoria());
        productows.setFechaIngreso(producto.getFechaIngreso());
        return productows;
    }
    public List<Productows> mapToProductoList(List<Producto> productoList){
        List<Productows> productowsList = new ArrayList<>();
        for (Producto producto : productoList){
            productowsList.add(mapToProductows(producto));
        }
        return productowsList;
    }
    public List<Productows> mapToProductowsList(List<Producto> productoList){
        List<Productows> productowsList = new ArrayList<>();
        for (Producto producto : productoList){
            productowsList.add(mapToProductows(producto));
        }
        return productowsList;
    }


}
