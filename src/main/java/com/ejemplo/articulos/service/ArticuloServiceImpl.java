
// Paquete del servicio de implementación
package com.ejemplo.articulos.service;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotación que indica que esta clase es un servicio de Spring
@Service
public class ArticuloServiceImpl implements ArticuloService {

    // Inyección del repositorio que maneja los datos
    private final ArticuloRepository articuloRepository;

    // Constructor con @Autowired para inyectar dependencias
    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // Implementación para listar artículos
    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    // Implementación para buscar artículo por ID
    @Override
    // que es Optional?
    // Optional es una clase que representa un valor que puede o no estar presente.
    // Se usa para evitar NullPointerExceptions al trabajar con valores que pueden ser nulos.
    // En este caso, devuelve un Optional<Articulo> que puede contener un artículo
    // si se encuentra, o estar vacío si no se encuentra.
    // ¿Por qué usar Optional?
    // Permite manejar de manera segura la ausencia de un valor sin usar null.
    // Esto es útil para evitar errores comunes de programación relacionados con null.
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    // Implementación para guardar un nuevo artículo
    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    // Implementación para actualizar artículo
    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        articulo.setId(id); // Setea el ID existente
        return articuloRepository.save(articulo);
    }

    // Implementación para eliminar artículo
    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}
