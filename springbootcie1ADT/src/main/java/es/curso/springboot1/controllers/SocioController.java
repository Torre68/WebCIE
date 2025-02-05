package es.curso.springboot1.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.springboot1.negocio.Socio;


@Controller
public class SocioController {

    List<Socio> socios = new ArrayList<>();

    public SocioController (){

        socios.add(new Socio ("pepe","perez",15));
        socios.add(new Socio ("pepe1","perez1", 15));
        socios.add(new Socio ("pepe2","perez2", 15));



        
    }

    @PostMapping ("/insertarsocio")
    public String insertarSocio (@ModelAttribute Socio socio) {
        socios.add(socio);
        
        return "redirect:listasocios";

    }

    @GetMapping("/formulariosocio")
    public String formulariosocio (){

        return "formulariosocio";
    }

    @GetMapping("/listasocios")
    public String listasocios (Model modelo){
        modelo.addAttribute("listasocios",socios);
        return "listasocios";
    }

    @GetMapping(value="/listasocios",params="orden")
    public String listasocios (Model modelo,@RequestParam String orden){
       List<Socio> listaOrdenada= new ArrayList<>();
        if (orden.equals("nombre")){

            listaOrdenada=socios.stream().sorted(Comparator.comparing(Socio::getNombre)).toList();

        }else if (orden.equals("apellidos")){

            listaOrdenada=socios.stream().sorted(Comparator.comparing(Socio::getApellidos)).toList();
            
        }else {
            listaOrdenada=socios.stream().sorted(Comparator.comparing(Socio::getEdad)).toList();
        }
        modelo.addAttribute("listasocios",listaOrdenada);

        return "listasocios";
    }


    @GetMapping("/socios")
    public String socios() {
        return "plantillasocio";
    }

    @GetMapping("/versocio")
    public String verSocio(@RequestParam String nombre, Model modelo) {

        System.out.println(nombre);
        modelo.addAttribute("nombre",nombre);
        return "plantillaversocio";
    }
    
     
}
