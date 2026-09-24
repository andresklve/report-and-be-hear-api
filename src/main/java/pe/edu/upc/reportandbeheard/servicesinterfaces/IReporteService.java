package pe.edu.upc.reportandbeheard.servicesinterfaces;

import pe.edu.upc.reportandbeheard.dtos.CategoriaReporteDTO;
import pe.edu.upc.reportandbeheard.dtos.MapaCalorDTO;

import java.util.List;

public interface IReporteService {
    List<MapaCalorDTO> mapaCalorPorZona();

    List<CategoriaReporteDTO> reportePorCategoria();
}
