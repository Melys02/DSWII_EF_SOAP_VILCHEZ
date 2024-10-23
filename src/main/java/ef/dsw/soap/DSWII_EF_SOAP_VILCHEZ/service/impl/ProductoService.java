package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.impl;

import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Contacto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.model.Producto;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.repository.ProductoRepository;
import ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.service.IProductoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService{
    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoxId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarProducto(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Integer id, Producto producto) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        if (productoOpt.isPresent()) {
            Producto productoExistente = productoOpt.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setMarca(producto.getMarca());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setStock(producto.getStock());

            return productoRepository.save(productoExistente);
        } else {
            throw new EntityNotFoundException("Producto con id " + id + " no encontrado");
        }
    }
    }
