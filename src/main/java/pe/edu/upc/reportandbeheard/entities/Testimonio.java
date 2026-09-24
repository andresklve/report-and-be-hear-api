package pe.edu.upc.reportandbeheard.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// TODO(equipo): entidad temporal solo con lo necesario para el reporte US07 (mapa de calor).
// Faltan las FK a Usuario y Categoria, y los campos confianzaIa / modeloIa del modelo real.
@Entity
@Table(name = "testimonios")
public class Testimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestimonio;

    @Column(name = "textoTestimonio", length = 1000, nullable = false)
    private String textoTestimonio;

    @Column(name = "fechaTestimonio", nullable = false)
    private LocalDateTime fechaTestimonio = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idZona", nullable = false)
    private Zona zona;

    // nullable de forma temporal; en el modelo real es obligatoria.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Testimonio() {
    }

    public Long getIdTestimonio() {
        return idTestimonio;
    }

    public void setIdTestimonio(Long idTestimonio) {
        this.idTestimonio = idTestimonio;
    }

    public String getTextoTestimonio() {
        return textoTestimonio;
    }

    public void setTextoTestimonio(String textoTestimonio) {
        this.textoTestimonio = textoTestimonio;
    }

    public LocalDateTime getFechaTestimonio() {
        return fechaTestimonio;
    }

    public void setFechaTestimonio(LocalDateTime fechaTestimonio) {
        this.fechaTestimonio = fechaTestimonio;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
