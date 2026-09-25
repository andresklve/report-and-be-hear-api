package pe.edu.upc.reportandbeheard.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.reportandbeheard.dtos.CategoriaReporteDTO;
import pe.edu.upc.reportandbeheard.dtos.MapaCalorDTO;
import pe.edu.upc.reportandbeheard.dtos.RankingZonaDTO;
import pe.edu.upc.reportandbeheard.dtos.TendenciaTemporalDTO;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IReporteService;

import java.util.List;

@RestController
@RequestMapping("/apis/reportes")
public class ReporteController {
    private final IReporteService rS;

    public ReporteController(IReporteService rS) {
        this.rS = rS;
    }

    // US07: sin testimonios devuelve lista vacia con 200.
    @GetMapping("/mapa-calor")
    public ResponseEntity<List<MapaCalorDTO>> mapaCalor() {
        return ResponseEntity.ok(rS.mapaCalorPorZona());
    }

    // US08: sin testimonios devuelve cada categoria con conteo 0 (200).
    @GetMapping("/por-categoria")
    public ResponseEntity<List<CategoriaReporteDTO>> porCategoria() {
        return ResponseEntity.ok(rS.reportePorCategoria());
    }

    // US09: agrupacion "dia" (por defecto) o "mes".
    @GetMapping("/tendencia")
    public ResponseEntity<List<TendenciaTemporalDTO>> tendenciaTemporal(
            @RequestParam(defaultValue = "dia") String agrupacion) {
        return ResponseEntity.ok(rS.tendenciaTemporal(agrupacion));
    }

    // US10: zonas ordenadas por cantidad de testimonios.
    @GetMapping("/ranking-zonas")
    public ResponseEntity<List<RankingZonaDTO>> rankingZonas() {
        return ResponseEntity.ok(rS.rankingZonas());
    }
}
