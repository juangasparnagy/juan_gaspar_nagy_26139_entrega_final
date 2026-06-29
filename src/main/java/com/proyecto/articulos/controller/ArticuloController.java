package com.proyecto.articulos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import com.proyecto.articulos.model.Articulo;
import com.proyecto.articulos.service.ArticuloServiceImp;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")

public class ArticuloController {
    
    // Es ArticuloServiceImp porque el que no lleva Imp es la interfase
    // Sería como decir, "Es la clase que implementa la interfase Articuloservice"
    private final ArticuloServiceImp articuloservice;

    private void resuelve(){}

    @Autowired
    public ArticuloController(ArticuloServiceImp articuloservice){
        this.articuloservice = articuloservice;
    };

    @GetMapping
    public List<Articulo> listar(){
        return articuloservice.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> encontrarPorId(@PathVariable Long id){
        resuelve();
        // Como es un ResponseEntity, requiere de un map a una función Lambda y orElse. Y finalmente el build del notFound.
        // Faltaría estudiar bien el tema de como funciona el ResponseEntity
        return articuloservice.encontrarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Articulo crear(@RequestBody Articulo articulo){
        return articuloservice.guardarArticulo(articulo);
    }

    @PutMapping("/{id}")
    public Articulo modificar(Articulo articulo, Long id){
        return articuloservice.modificarArticulo(articulo, id);
    }
    @DeleteMapping("/{id}")
    public void borrar(Long id){
        articuloservice.borrarArticulo(id);
    }

}
