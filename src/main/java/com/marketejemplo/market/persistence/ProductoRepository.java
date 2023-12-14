package com.marketejemplo.market.persistence;

import com.marketejemplo.market.domain.Product;
import com.marketejemplo.market.domain.repository.ProductRepository;
import com.marketejemplo.market.persistence.crud.ProductoCrudRepository;
import com.marketejemplo.market.persistence.entity.Producto;
import com.marketejemplo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    /* El mapper se encarga con getByCategory
    public List<Producto> getByCategoria(int idCategoria) {
        /* La idea es obtener todos los productos pertenecientes a la misma categoría por ejemplo limpieza
            y que estén ordenados por nombre
         *
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/

    /* El mapper se encarga con getScarseProducts
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }*/

    /* El mapper se encarga con getProduct
    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }*/

    /* El mapper se encarga con save
    // Alta de producto
    public Producto save(Producto p) {
        return productoCrudRepository.save(p);
    }*/

    // Baja de producto
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
