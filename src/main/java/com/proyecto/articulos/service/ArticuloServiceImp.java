package com.proyecto.articulos.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;   

import java.util.List;
import java.util.Optional;
import com.proyecto.articulos.model.Articulo;
import com.proyecto.articulos.repository.ArticuloRepository;


//Acá se puede poner más lógica de comercio si es necesario.

@Service
public class ArticuloServiceImp implements ArticuloService{

    private final ArticuloRepository articulorepository;

    //inyecto
    @Autowired
    public ArticuloServiceImp(ArticuloRepository articulorepository){
        this.articulorepository = articulorepository;
    }

    @Override
    public List<Articulo> listarTodos(){
        return articulorepository.findAll();
    }
    @Override
    public Optional<Articulo> encontrarPorId(Long id){
        return articulorepository.findById(id);
    }
    @Override
    public Articulo guardarArticulo(Articulo articulo){
        // Ya no es necesario lo anterior gracias a JpaRepository
        return articulorepository.save(articulo); 
    }
    @Override
        public Articulo modificarArticulo(Articulo articulo, Long id){
        articulo.setId(id);
        return articulorepository.save(articulo); //guarda el que recibió modificado;
    }
    @Override
    public void borrarArticulo(Long id){
        articulorepository.deleteById(id);
    };
}
