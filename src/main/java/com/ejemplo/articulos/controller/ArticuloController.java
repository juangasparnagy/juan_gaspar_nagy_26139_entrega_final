
// Paquete del controlador
package com.ejemplo.articulos.controller;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST que maneja las peticiones HTTP- GET,get(id) ,POST, PUT, DELETE- PATCH- OPTIONS
@RestController
// @RequestMapping define la ruta base para todas las peticiones de este controlador
// En este caso, todas las peticiones a este controlador comenzarán con /api/articulos
// http://localhost:8080/api/articulos
@RequestMapping("/api/articulos")
public class ArticuloController {

    // Inyección del servicio
    private final ArticuloService articuloService;

    // Constructor con inyección
    // para que Spring pueda inyectar el servicio automáticamente
    // cuando se crea una instancia de este controlador
    // Esto permite seguir el principio de inversión de dependencias
    // el articuloService se inyecta en el controlador
    // y no se crea una instancia directamente dentro del controlador.
    // que significa que el controlador no cree una instancia del servicio?
    // Esto permite que el servicio pueda ser fácilmente reemplazado por otro
    // (por ejemplo, un servicio de prueba) sin modificar el controlador.

    // el constructor del controlador recibe un ArticuloService
    // y lo asigna a la variable articuloService.
    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // GET /api/articulos -> lista todos los artículos
    @GetMapping
    public List<Articulo> listar() {
        // Llama al servicio para obtener la lista de artículos
        return articuloService.listarArticulos();
    }

    // GET /api/articulos/{id} -> busca un artículo por ID
    @GetMapping("/{id}")
    //que es responseEntity?
    // ResponseEntity es una clase que representa una respuesta HTTP completa,
    // incluyendo el cuerpo, los encabezados y el código de estado.
    // Permite personalizar la respuesta que se envía al cliente.
    // En este caso, devuelve un artículo si lo encuentra o un 404 si no.
    // ¿Por qué usar ResponseEntity?
    // Permite devolver diferentes códigos de estado HTTP y personalizar la respuesta.
    // Por ejemplo, si el artículo no se encuentra, se puede devolver un 404 Not Found.
    // Si se encuentra, se devuelve un 200 OK con el artículo.
    //PathVariable se usa para extraer el ID del artículo de la URL
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        //.map(ResponseEntity::ok) convierte el artículo encontrado en una respuesta 200 OK
        //.orElse(ResponseEntity.notFound().build()) devuelve 404 Not Found si no se encuentra el artículo
        // articuloService.obtenerArticuloPorId(id) busca el artículo por ID
        // y devuelve un Optional<Articulo>.
        // Si el artículo existe, devuelve un ResponseEntity con el artículo y un código 200 OK.
        // Si no existe, devuelve un ResponseEntity con un código 404 Not Found.
        // Esto permite manejar de manera elegante los casos en que el recurso no se encuentra,
        // sin lanzar excepciones innecesarias.
        // Esto es útil para APIs REST, donde es común que los recursos no existan.
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok) // Devuelve 200 si lo encuentra
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si no
    }

    // POST /api/articulos -> crea un nuevo artículo
    @PostMapping
    // @RequestBody indica que el cuerpo de la petición contiene los datos del artículo
    // que se van a crear. Spring convierte automáticamente el JSON del cuerpo
    // en un objeto Articulo.
    // El método crear recibe un objeto Articulo y lo guarda usando el servicio.
    public Articulo crear(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    // PUT /api/articulos/{id} -> actualiza un artículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // Si no existe, 404
        }
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo)); // Si existe, actualiza y 200
    }

    // DELETE /api/articulos/{id} -> elimina un artículo
    @DeleteMapping("/{id}")
    // Elimina un artículo por ID.
    // Si el artículo no existe, devuelve 404 Not Found.
    // Si se elimina correctamente, devuelve 204 No Content.
    // El método eliminar recibe el ID del artículo a eliminar.
    // Si el artículo no existe, devuelve un ResponseEntity con un código 404 Not Found.
    // Si el artículo existe, lo elimina y devuelve un ResponseEntity con un código 204 No Content.
    // Esto es útil para APIs REST, donde es común eliminar recursos.
    // porque un 204 No Content?
    // El código 204 indica que la solicitud se ha procesado correctamente,
    // pero no hay contenido que devolver en la respuesta.
    // Es una forma de indicar que la operación se completó con éxito,
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // Si no existe, 404
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
