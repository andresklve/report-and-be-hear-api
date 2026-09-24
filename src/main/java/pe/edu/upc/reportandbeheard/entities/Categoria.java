package pe.edu.upc.reportandbeheard.entities;

import jakarta.persistence.*;

// TODO(equipo): entidad temporal solo con lo necesario para el reporte US08.
// Ajustar segun lo que defina el companero encargado de esta entidad.
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nombreCategoria", length = 100, nullable = false)
    private String nombreCategoria;

    public Categoria() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
