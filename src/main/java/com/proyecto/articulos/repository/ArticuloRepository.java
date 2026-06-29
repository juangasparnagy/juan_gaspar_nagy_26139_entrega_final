package com.proyecto.articulos.repository;

import  com.proyecto.articulos.model.Articulo;

import java.util.List;
import java.util.Optional;

//Importante, Importar este repositorio que ya tiene los métodos listos siempre
import org.springframework.data.jpa.repository.JpaRepository;
//Importante, Importar este esterotipo para la anotación @Repository que asigna la interface como repo que se conecta a la db.
import org.springframework.stereotype.Repository;

@Repository
//Nota, JpaRepository<Tipo, Id>, maneja recibiendo el Tipo de objeto y el tipo de Id. Usa Generics
// osea, se podría usar con JpaRepository<Usuario, int>, para usuario, dni, por ejemplo, creo.

public interface ArticuloRepository extends JpaRepository<Articulo, Long>  {
    
    // NADA DE ESTO ES NECESARIO YA A MENOS QUE AMPLÍE CON OTROS MÉTODOS EN UNA CLASE QUE IMPLEMENTE ESTOS MÉTODOS
    // List<Articulo> mostrarTodos();
    // void borrarPorId(Long id);
    // Articulo getById(Long id);
    // //un solo comando para crear y modificar, si es que recibe un id
    // Articulo salvar(Articulo articulo);
    //void modificar();

}
