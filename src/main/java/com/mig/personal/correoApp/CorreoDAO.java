package com.mig.personal.correoApp;

import java.util.List;

public interface CorreoDAO {
    List<Correo> obtenerTodos();
    Correo obtenerPorId(int id);
    void guardar(Correo correo);
    void actualizar(Correo correo);
    void eliminar(Correo correo);
}
