package com.example.ejercicio1;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Miservicio {

    private final List<String> datos = new ArrayList<>();

    public Miservicio(){
        //datos iniciales
        datos.add("Elemento 1");
        datos.add("Elemento 2");
    }

    public List<String> obtenerDatos() {
        return datos;
    }

    public void agregarDato(String nuevoDato) {
        datos.add(nuevoDato);
    }
}
