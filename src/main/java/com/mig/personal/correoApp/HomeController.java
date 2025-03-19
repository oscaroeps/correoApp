package com.mig.personal.correoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*; // Importa @RequestMapping, @GetMapping, @PostMapping, etc.

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    // Inyectamos el servicio para gestionar los correos
    @Autowired
    private CorreoService correoService;

    // 1. Mostrar la página principal (listado de correos)
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listaCorreos", correoService.obtenerTodos());
        return "index"; // Renderiza /WEB-INF/views/index.jsp
    }

    // 2. Mostrar el formulario para un nuevo registro
    @GetMapping("/nuevo")
    public String nuevoRegistro(Model model) {
        model.addAttribute("accion", "Nuevo");
        model.addAttribute("correo", new Correo());
        // Agregar la lista de tipos de correo:
        model.addAttribute("listaTipos", obtenerListaTipos());
        return "form";
    }

 // Método auxiliar para simular los tipos de correo
    private List<TipoCorreo> obtenerListaTipos() {
        List<TipoCorreo> lista = new ArrayList<>();
        lista.add(new TipoCorreo(1, "Personal"));
        lista.add(new TipoCorreo(2, "Laboral"));
        lista.add(new TipoCorreo(3, "Otro"));
        return lista;
    }

    // 3. Procesar el guardado del nuevo registro
    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute("correo") Correo correo) {
        correoService.guardar(correo);
        // Redirecciona a la página principal para ver el listado actualizado
        return "redirect:/";
    }

    // 4. Mostrar el formulario para editar un registro existente
    @GetMapping("/editar")
    public String editarRegistro(@RequestParam("id") int id, Model model) {
        Correo correo = correoService.obtenerPorId(id);
        if (correo == null) {
            // Se puede redirigir a error o a la lista, según la lógica de negocio
            return "redirect:/";
        }
        model.addAttribute("accion", "Editar");
        model.addAttribute("correo", correo);
        // También se puede enviar la lista de tipos de correo
        // model.addAttribute("listaTipos", listaDeTipos);
        return "form";
    }

    // 5. Procesar la actualización del registro
    @PostMapping("/actualizar")
    public String actualizarRegistro(@ModelAttribute("correo") Correo correo) {
        correoService.actualizar(correo);
        return "redirect:/";
    }

    // 6. Eliminar un registro
    @GetMapping("/eliminar")
    public String eliminarRegistro(@RequestParam("id") int id) {
        correoService.eliminar(id);
        return "redirect:/";
    }

    // 7. (Opcional) Endpoint para descargar el reporte
    @GetMapping("/reporte")
    public String descargarReporte(Model model) {
        // Aquí se implementará la generación del reporte con iReport.
        // Por ahora se puede redirigir a la página principal o mostrar un mensaje.
        // Ejemplo: return "reporte"; (vista a crear más adelante)
        return "redirect:/";
    }
}
