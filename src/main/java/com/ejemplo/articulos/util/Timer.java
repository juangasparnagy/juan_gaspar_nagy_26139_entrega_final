package com.ejemplo.articulos.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;

public class Timer {
            // 1. Create a scheduler thread pool
        private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        private int segundos;
        private String mensaje;
        private LocalTime horaActual = LocalTime.now();
        //private SpringApplication aplicacion;

        //Le agrego constructor vacío porque se usa dentro de springboot, por las dudas
        public Timer(){};
        public Timer(int segundos, String mensaje){
            this.segundos  = segundos;
            this.mensaje = mensaje;
            //this.aplicacion = aplicacion;
        };

        public void setTimer(){

        // 2. Schedule a task (equivalent to setTimeout)
        scheduler.schedule(() -> {
            System.out.println(mensaje + segundos);
            System.out.println("Hora de cierre de la aplicación: " + horaActual);
            System.exit(1);
            //Me falta encontrar la manera que acceda a la aplicación para cerrarla
            //SpringBootApplication.close();
        }, segundos, TimeUnit.SECONDS);
        
        // Remember to shut down the scheduler when your app closes so the JVM can exit
        scheduler.shutdown();
        }

    }

