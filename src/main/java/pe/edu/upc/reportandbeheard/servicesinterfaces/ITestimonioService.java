package pe.edu.upc.reportandbeheard.servicesinterfaces;

import pe.edu.upc.reportandbeheard.entities.Testimonio;

import java.util.List;
import java.util.Optional;

public interface ITestimonioService {
    void insert(Testimonio testimonio);
    List<Testimonio> list();
    void actualizar(Testimonio testimonio);
    void eliminar(Long idTestimonio);
    Optional<Testimonio> obtenerPorId(Long id);
}
