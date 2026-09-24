package pe.edu.upc.reportandbeheard.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "moderaciones")
public class Moderacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moderacion")
    private Integer idModeracion;

    @Column(name = "id_testimonio", nullable = false)
    private Integer idTestimonio;

    @Column(name = "id_usuario_admin", nullable = false)
    private Integer idUsuarioAdmin;

    @Column(name = "accion", length = 20, nullable = false)
    private String accion;

    @Column(name = "motivo", length = 255)
    private String motivo;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "fecha_accion")
    private LocalDateTime fechaAccion;

    public Moderacion() {
    }

    public Integer getIdModeracion() {
        return idModeracion;
    }

    public void setIdModeracion(Integer idModeracion) {
        this.idModeracion = idModeracion;
    }

    public Integer getIdTestimonio() {
        return idTestimonio;
    }

    public void setIdTestimonio(Integer idTestimonio) {
        this.idTestimonio = idTestimonio;
    }

    public Integer getIdUsuarioAdmin() {
        return idUsuarioAdmin;
    }

    public void setIdUsuarioAdmin(Integer idUsuarioAdmin) {
        this.idUsuarioAdmin = idUsuarioAdmin;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
    }
}