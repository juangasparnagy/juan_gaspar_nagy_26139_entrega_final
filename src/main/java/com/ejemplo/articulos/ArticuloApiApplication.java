
// Paquete principal del proyecto
package com.ejemplo.articulos;

// Importa la clase SpringApplication que se usa para lanzar la app
import org.springframework.boot.SpringApplication;
// Importa la anotación @SpringBootApplication que indica una app Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejemplo.articulos.util.Timer;


// Anotación que marca esta clase como punto de entrada de una aplicación Spring Boot
@SpringBootApplication
public class ArticuloApiApplication {
    // Método principal que lanza la aplicación
    public static void main(String[] args) {
        int segundos = 60;
        boolean apagadoAutomatico = false;
        if(apagadoAutomatico){
        System.out.println("Se tendría que apagar en: "+segundos+" segundos");
        Timer apagadoEn = new Timer(segundos, "Se apagó en esta cantidad se sgundos; ");
        apagadoEn.setTimer();
        }
        //System.out.println("después de if");
        SpringApplication.run(ArticuloApiApplication.class, args);        
    }
}
