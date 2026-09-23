package pe.edu.upc.reportandbeheard.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "zonas")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Long idZona;

    @Column(name = "nombre_zona", length = 100, nullable = false)
    private String nombreZona;

    @Column(name = "provincia", length = 100, nullable = false)
    private String provinciaZona;

    @Column(name = "departamento", length = 100, nullable = false)
    private String departamentoZona;

    @Column(name = "nivel_atencion", length = 20)
    private String nivelAtencion;

    @Column(name = "latitud", precision = 9, scale = 6)
    private BigDecimal latitudZona;

    @Column(name = "longitud", precision = 9, scale = 6)
    private BigDecimal longitudZona;

    public Zona() {
    }

    public Zona(Long idZona, String nombreZona, String provinciaZona, String departamentoZona,
               String nivelAtencion, BigDecimal latitudZona, BigDecimal longitudZona) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.provinciaZona = provinciaZona;
        this.departamentoZona = departamentoZona;
        this.nivelAtencion = nivelAtencion;
        this.latitudZona = latitudZona;
        this.longitudZona = longitudZona;
    }

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

    public String getNivelAtencion() {
        return nivelAtencion;
    }

    public void setNivelAtencion(String nivelAtencion) {
        this.nivelAtencion = nivelAtencion;
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
