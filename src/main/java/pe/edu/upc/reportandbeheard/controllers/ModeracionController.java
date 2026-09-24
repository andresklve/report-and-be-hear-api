package pe.edu.upc.reportandbeheard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.reportandbeheard.entities.Moderacion;
import pe.edu.upc.reportandbeheard.services.IModeracionService;

import java.util.List;

@RestController
@RequestMapping("/apis/moderaciones")
public class ModeracionController {

    @Autowired
    private IModeracionService moderacionService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Moderacion moderacion) {

        if (moderacion.getIdTestimonio() == null ||
                moderacion.getIdUsuarioAdmin() == null ||
                moderacion.getAccion() == null ||
                moderacion.getAccion().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Los datos de la moderación son incompletos o inválidos");
        }

        Moderacion nueva = moderacionService.registrar(moderacion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Moderacion>> listar() {
        return ResponseEntity.ok(moderacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {

        Moderacion moderacion = moderacionService.buscarPorId(id);

        if (moderacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La moderación no existe");
        }

        return ResponseEntity.ok(moderacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @RequestBody Moderacion moderacion) {

        if (moderacion.getIdTestimonio() == null ||
                moderacion.getIdUsuarioAdmin() == null ||
                moderacion.getAccion() == null ||
                moderacion.getAccion().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Los datos de la moderación son incompletos o inválidos");
        }

        Moderacion actualizada =
                moderacionService.actualizar(id, moderacion);

        if (actualizada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La moderación no existe");
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        Moderacion moderacion = moderacionService.buscarPorId(id);

        if (moderacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La moderación no existe");
        }

        moderacionService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}