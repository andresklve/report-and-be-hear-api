package pe.edu.upc.reportandbeheard.servicesinterfaces;

import pe.edu.upc.reportandbeheard.dtos.InversionDepartamentoDTO;
import pe.edu.upc.reportandbeheard.dtos.CostoCategoriaDTO;

import java.util.List;

public interface IModeracionService {
    List<InversionDepartamentoDTO> obtenerInversionPorDepartamento();
    List<CostoCategoriaDTO> obtenerCostoPorCategoria();
}
