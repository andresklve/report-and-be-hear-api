package pe.edu.upc.reportandbeheard.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TestimonioDTO {
    private Long idTestimonio;

    @NotNull(message = "El usuario es obligatorio.")
    private Long idUsuario;

    @NotNull(message = "La categoría es obligatoria.")
    private Long idCategoria;

    @NotNull(message = "La zona es obligatoria.")
    private Long idZona;

    @NotBlank(message = "La descripción es obligatoria.")
    private String descripcionTexto;

    private String fotoUrl;
    private String direccionTextoExtraida;
    private Double latitud;
    private Double longitud;

    @NotBlank(message = "El estado es obligatorio.")
    private String estado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Long getIdTestimonio() { return idTestimonio; }
    public void setIdTestimonio(Long idTestimonio) { this.idTestimonio = idTestimonio; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }
    public Long getIdZona() { return idZona; }
    public void setIdZona(Long idZona) { this.idZona = idZona; }
    public String getDescripcionTexto() { return descripcionTexto; }
    public void setDescripcionTexto(String descripcionTexto) { this.descripcionTexto = descripcionTexto; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getDireccionTextoExtraida() { return direccionTextoExtraida; }
    public void setDireccionTextoExtraida(String d) { this.direccionTextoExtraida = d; }
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
}