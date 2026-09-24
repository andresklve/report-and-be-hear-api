package pe.edu.upc.reportandbeheard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.reportandbeheard.entities.Moderacion;
import pe.edu.upc.reportandbeheard.repositories.IModeracionRepository;

import java.util.List;

@Service
public class ModeracionServiceImplement implements IModeracionService {

    @Autowired
    private IModeracionRepository moderacionRepository;

    @Override
    public Moderacion registrar(Moderacion moderacion) {
        return moderacionRepository.save(moderacion);
    }

    @Override
    public List<Moderacion> listar() {
        return moderacionRepository.findAll();
    }

    @Override
    public Moderacion buscarPorId(Integer id) {
        return moderacionRepository.findById(id).orElse(null);
    }

    @Override
    public Moderacion actualizar(Integer id, Moderacion moderacion) {
        Moderacion existente = moderacionRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setIdTestimonio(moderacion.getIdTestimonio());
        existente.setIdUsuarioAdmin(moderacion.getIdUsuarioAdmin());
        existente.setAccion(moderacion.getAccion());
        existente.setMotivo(moderacion.getMotivo());
        existente.setCosto(moderacion.getCosto());
        existente.setFechaAccion(moderacion.getFechaAccion());

        return moderacionRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        moderacionRepository.deleteById(id);
    }
}
