package pe.edu.upc.reportandbeheard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ZonaDTO {
    private Long idZona;

    @NotBlank(message = "El nombre de la zona es obligatorio.")
    private String nombreZona;

    @NotBlank(message = "La provincia es obligatoria.")
    private String provinciaZona;

    @NotBlank(message = "El departamento es obligatorio.")
    private String departamentoZona;

    @NotNull(message = "La latitud es obligatoria.")
    private BigDecimal latitudZona;

    @NotNull(message = "La longitud es obligatoria.")
    private BigDecimal longitudZona;

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getProvinciaZona() {
        return provinciaZona;
    }

    public void setProvinciaZona(String provinciaZona) {
        this.provinciaZona = provinciaZona;
    }

    public String getDepartamentoZona() {
        return departamentoZona;
    }

    public void setDepartamentoZona(String departamentoZona) {
        this.departamentoZona = departamentoZona;
    }

    public BigDecimal getLatitudZona() {
        return latitudZona;
    }

    public void setLatitudZona(BigDecimal latitudZona) {
        this.latitudZona = latitudZona;
    }

    public BigDecimal getLongitudZona() {
        return longitudZona;
    }

    public void setLongitudZona(BigDecimal longitudZona) {
        this.longitudZona = longitudZona;
    }
}
