package com.proyecto.articulos.service;


import java.util.List;
import java.util.Optional;

import com.proyecto.articulos.model.Articulo;

public interface ArticuloService {
    List<Articulo> listarTodos();
    //Optional porque puede no haber un artículo con id solicitado
    Optional<Articulo> encontrarPorId(Long id);
    // Va a usar el mismo método para guardar y modificar gracias a la sobrecarga de métodos.
    // Si el artículo se recibe sin id, lo crea, y si ya tiene id decide modificar.
    Articulo guardarArticulo(Articulo articulo);
    Articulo modificarArticulo(Articulo articulo, Long id);
    void borrarArticulo(Long id);
}
