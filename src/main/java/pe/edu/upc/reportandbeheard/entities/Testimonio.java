package pe.edu.upc.reportandbeheard.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "testimonios")
public class Testimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestimonio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idZona", nullable = false)
    private Zona zona;

    @Column(name = "descripcionTexto", columnDefinition = "TEXT", nullable = false)
    private String descripcionTexto;

    @Column(name = "fotoUrl", length = 500)
    private String fotoUrl;

    @Column(name = "direccionTextoExtraida", length = 255)
    private String direccionTextoExtraida;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    public Testimonio() {}

    public Long getIdTestimonio() { return idTestimonio; }
    public void setIdTestimonio(Long idTestimonio) { this.idTestimonio = idTestimonio; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Zona getZona() { return zona; }
    public void setZona(Zona zona) { this.zona = zona; }
    public String getDescripcionTexto() { return descripcionTexto; }
    public void setDescripcionTexto(String descripcionTexto) { this.descripcionTexto = descripcionTexto; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getDireccionTextoExtraida() { return direccionTextoExtraida; }
    public void setDireccionTextoExtraida(String direccionTextoExtraida) { this.direccionTextoExtraida = direccionTextoExtraida; }
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