package com.proyecto.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.articulos.util.Timer;


@SpringBootApplication
public class ArticulosApplication {

	public static void main(String[] args) {
        //Agrego un Timer porque siempre me olvido de apagar el programa cuando me voy de casa.
        int segundos = 3600;
        boolean apagadoAutomatico = true;
        if(apagadoAutomatico){
        System.out.println("Se tendría que apagar en: "+segundos+" segundos");
        Timer apagadoEn = new Timer(segundos, "Se apagó en esta cantidad se sgundos; ");
        apagadoEn.setTimer();
        }
        //System.out.println("después de if");
		SpringApplication.run(ArticulosApplication.class, args);
	}

}
