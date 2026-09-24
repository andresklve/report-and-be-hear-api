package pe.edu.upc.reportandbeheard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.reportandbeheard.dtos.CategoriaReporteDTO;
import pe.edu.upc.reportandbeheard.dtos.MapaCalorDTO;
import pe.edu.upc.reportandbeheard.entities.Testimonio;

import java.util.List;

@Repository
public interface ITestimonioRepository extends JpaRepository<Testimonio, Long> {
    // US07: testimonios agrupados por zona (JOIN), densidad = cantidad de testimonios.
    @Query("SELECT new pe.edu.upc.reportandbeheard.dtos.MapaCalorDTO(" +
            "z.idZona, z.nombreZona, z.latitudZona, z.longitudZona, COUNT(t)) " +
            "FROM Testimonio t JOIN t.zona z " +
            "GROUP BY z.idZona, z.nombreZona, z.latitudZona, z.longitudZona " +
            "ORDER BY COUNT(t) DESC")
    List<MapaCalorDTO> mapaCalorPorZona();

    // US08: conteo por categoria (JOIN testimonios-categorias). LEFT JOIN para devolver 0 en categorias sin testimonios.
    @Query("SELECT new pe.edu.upc.reportandbeheard.dtos.CategoriaReporteDTO(" +
            "c.idCategoria, c.nombreCategoria, COUNT(t)) " +
            "FROM Categoria c LEFT JOIN Testimonio t ON t.categoria = c " +
            "GROUP BY c.idCategoria, c.nombreCategoria " +
            "ORDER BY COUNT(t) DESC")
    List<CategoriaReporteDTO> reportePorCategoria();
}
