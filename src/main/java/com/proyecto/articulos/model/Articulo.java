
package com.proyecto.articulos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    public Articulo(){}
    public Articulo(String nombre, Long id, double precio){
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
    }

    //getters
    public String getNombre(){return this.nombre;}
    public Long getId(){return this.id;}
    public double precio(){return this.precio;}

    //setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setId(Long id){
        this.id  = id;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    @Override
    public String toString(){
        String mostrar = "nombre: "+getNombre() + ", Código: " + getId() + ", Precio: " + Double.toString(precio);
        return mostrar;
    }

}
