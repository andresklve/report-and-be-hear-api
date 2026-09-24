package pe.edu.upc.reportandbeheard.services;

import pe.edu.upc.reportandbeheard.entities.Moderacion;

import java.util.List;

public interface IModeracionService {

    Moderacion registrar(Moderacion moderacion);

    List<Moderacion> listar();

    Moderacion buscarPorId(Integer id);

    Moderacion actualizar(Integer id, Moderacion moderacion);

    void eliminar(Integer id);
}