package pe.edu.upc.reportandbeheard.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.reportandbeheard.dtos.InversionDepartamentoDTO;
import pe.edu.upc.reportandbeheard.dtos.CostoCategoriaDTO;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IModeracionService;

import java.util.List;

@RestController
@RequestMapping("/apis/reportes")
@Tag(name = "Reportes", description = "Reportes de inversión del sistema")
public class ReporteController {
    private final IModeracionService moderacionService;

    public ReporteController(IModeracionService moderacionService) {
        this.moderacionService = moderacionService;
    }

    @Operation(
            summary = "Visualizar inversión por departamento",
            description = "Suma los costos de moderación agrupados por departamento."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reporte obtenido correctamente")
    })
    @GetMapping("/inversion-por-departamento")
    public ResponseEntity<List<InversionDepartamentoDTO>> obtenerInversionPorDepartamento() {
        return ResponseEntity.ok(moderacionService.obtenerInversionPorDepartamento());
    }

    @Operation(
            summary = "Visualizar costo por categoría",
            description = "Suma los costos de moderación agrupados por categoría."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reporte obtenido correctamente")
    })
    @GetMapping("/costo-por-categoria")
    public ResponseEntity<List<CostoCategoriaDTO>> obtenerCostoPorCategoria() {
        return ResponseEntity.ok(moderacionService.obtenerCostoPorCategoria());
    }
}
