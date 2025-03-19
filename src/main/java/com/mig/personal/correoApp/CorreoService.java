package com.mig.personal.correoApp;

import java.util.List;

public interface CorreoService {
    List<Correo> obtenerTodos();
    Correo obtenerPorId(int id);
    void guardar(Correo correo);
    void actualizar(Correo correo);
    void eliminar(int id);
}
