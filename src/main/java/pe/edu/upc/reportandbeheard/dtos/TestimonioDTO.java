package pe.edu.upc.reportandbeheard.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class TestimonioDTO {
    private Long idTestimonio;

    @NotNull(message = "El id del usuario es obligatorio.")
    @Schema(description = "Identificador del usuario que registra el testimonio", example = "1")
    private Long idUsuario;

    @NotNull(message = "El id de la categoría es obligatorio.")
    @Schema(description = "Identificador de la categoría del testimonio", example = "2")
    private Long idCategoria;

    @NotNull(message = "El id de la zona es obligatorio.")
    @Schema(description = "Identificador de la zona del testimonio", example = "3")
    private Long idZona;

    @NotBlank(message = "La descripción del testimonio es obligatoria.")
    @Size(max = 5000, message = "La descripción no puede exceder 5000 caracteres.")
    @Schema(description = "Texto del testimonio", example = "Gracias a la atención oportuna del equipo, mi caso fue resuelto de manera rápida y clara.")
    private String descripcionTexto;

    @Schema(description = "URL de la foto adjunta al testimonio", example = "https://example.com/foto.jpg")
    private String fotoUrl;

    @Schema(description = "Dirección extraída del texto del testimonio", example = "Av. Brasil 123, Lima")
    private String direccionTextoExtraida;

    @NotNull(message = "La latitud es obligatoria.")
    @DecimalMin(value = "-90.0", message = "La latitud debe estar entre -90 y 90.")
    @Schema(description = "Latitud geográfica del testimonio", example = "-12.046374")
    private BigDecimal latitud;

    @NotNull(message = "La longitud es obligatoria.")
    @DecimalMin(value = "-180.0", message = "La longitud debe estar entre -180 y 180.")
    @Schema(description = "Longitud geográfica del testimonio", example = "-77.042793")
    private BigDecimal longitud;

    @NotBlank(message = "El estado del testimonio es obligatorio.")
    @Schema(description = "Estado del testimonio", example = "PENDIENTE")
    private String estado;

    public Long getIdTestimonio() {
        return idTestimonio;
    }

    public void setIdTestimonio(Long idTestimonio) {
        this.idTestimonio = idTestimonio;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getDireccionTextoExtraida() {
        return direccionTextoExtraida;
    }

    public void setDireccionTextoExtraida(String direccionTextoExtraida) {
        this.direccionTextoExtraida = direccionTextoExtraida;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
