package pe.edu.upc.reportandbeheard.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.reportandbeheard.dtos.CategoriaReporteDTO;
import pe.edu.upc.reportandbeheard.dtos.MapaCalorDTO;
import pe.edu.upc.reportandbeheard.repositories.ITestimonioRepository;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IReporteService;

import java.util.List;

@Service
public class ReporteServiceImplement implements IReporteService {
    private final ITestimonioRepository tR;

    public ReporteServiceImplement(ITestimonioRepository tR) {
        this.tR = tR;
    }

    @Override
    public List<MapaCalorDTO> mapaCalorPorZona() {
        return tR.mapaCalorPorZona();
    }

    @Override
    public List<CategoriaReporteDTO> reportePorCategoria() {
        return tR.reportePorCategoria();
    }
}
