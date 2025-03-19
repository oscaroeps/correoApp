package com.mig.personal.correoApp;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CorreoServiceImpl implements CorreoService {

    // Lista estática para simular la persistencia de datos
    private static List<Correo> listaCorreos = new ArrayList<>();
    private static int contador = 1; // Para simular generación de ID

    @Override
    public List<Correo> obtenerTodos() {
        return listaCorreos;
    }

    @Override
    public Correo obtenerPorId(int id) {
        for (Correo c : listaCorreos) {
            if (c.getnId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void guardar(Correo correo) {
        // Asigna un ID único
        correo.setnId(contador++);

        // Según el valor de nIdTipoCorreo, asigna el nombre correspondiente
        if (correo.getnIdTipoCorreo() != null) {
            switch (correo.getnIdTipoCorreo()) {
                case 1:
                    correo.setsTipoCorreo("Personal");
                    break;
                case 2:
                    correo.setsTipoCorreo("Laboral");
                    break;
                case 3:
                    correo.setsTipoCorreo("Otro");
                    break;
                default:
                    correo.setsTipoCorreo("Desconocido");
                    break;
            }
        } else {
            correo.setsTipoCorreo("No especificado");
        }
        
        listaCorreos.add(correo);
    }

    @Override
    public void actualizar(Correo correo) {
        for (int i = 0; i < listaCorreos.size(); i++) {
            if (listaCorreos.get(i).getnId() == correo.getnId()) {
                // Se puede actualizar también sTipoCorreo según el nIdTipoCorreo
                if (correo.getnIdTipoCorreo() != null) {
                    switch (correo.getnIdTipoCorreo()) {
                        case 1:
                            correo.setsTipoCorreo("Personal");
                            break;
                        case 2:
                            correo.setsTipoCorreo("Laboral");
                            break;
                        case 3:
                            correo.setsTipoCorreo("Otro");
                            break;
                        default:
                            correo.setsTipoCorreo("Desconocido");
                            break;
                    }
                } else {
                    correo.setsTipoCorreo("No especificado");
                }
                listaCorreos.set(i, correo);
                return;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        Iterator<Correo> it = listaCorreos.iterator();
        while (it.hasNext()) {
            Correo c = it.next();
            if (c.getnId() == id) {
                it.remove();
                break;
            }
        }
    }
}
