package pe.edu.upc.reportandbeheard.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upc.reportandbeheard.dtos.TestimonioDTO;
import pe.edu.upc.reportandbeheard.entities.Categoria;
import pe.edu.upc.reportandbeheard.entities.Testimonio;
import pe.edu.upc.reportandbeheard.entities.Usuario;
import pe.edu.upc.reportandbeheard.entities.Zona;
import pe.edu.upc.reportandbeheard.exceptions.ResourceNotFoundException;
import pe.edu.upc.reportandbeheard.servicesinterfaces.ICategoriaService;
import pe.edu.upc.reportandbeheard.servicesinterfaces.ITestimonioService;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IUsuarioService;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IZonaService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis/testimonios")
public class TestimonioController {
    private final ITestimonioService tS;
    private final IUsuarioService uS;
    private final ICategoriaService cS;
    private final IZonaService zS;
    private final ModelMapper modelMapper;

    public TestimonioController(ITestimonioService tS, IUsuarioService uS,
                                ICategoriaService cS, IZonaService zS,
                                ModelMapper modelMapper) {
        this.tS = tS;
        this.uS = uS;
        this.cS = cS;
        this.zS = zS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<TestimonioDTO>> listar() {
        List<TestimonioDTO> lista = tS.list()
                .stream()
                .map(t -> {
                    TestimonioDTO dto = modelMapper.map(t, TestimonioDTO.class);
                    dto.setIdUsuario(t.getUsuario().getIdUsuario());
                    dto.setIdCategoria(t.getCategoria().getIdCategoria());
                    dto.setIdZona(t.getZona().getIdZona());
                    return dto;
                })
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<TestimonioDTO> registrar(@Valid @RequestBody TestimonioDTO dto) {
        Usuario usuario = uS.listId(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("No existe un usuario con el id: " + dto.getIdUsuario()));

        Categoria categoria = cS.listId(dto.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una categoría con el id: " + dto.getIdCategoria()));

        Zona zona = zS.listId(dto.getIdZona())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una zona con el id: " + dto.getIdZona()));

        Testimonio testimonio = modelMapper.map(dto, Testimonio.class);
        testimonio.setUsuario(usuario);
        testimonio.setCategoria(categoria);
        testimonio.setZona(zona);
        testimonio.setFechaCreacion(LocalDateTime.now());
        testimonio.setFechaActualizacion(LocalDateTime.now());

        tS.insert(testimonio);

        TestimonioDTO responseDTO = modelMapper.map(testimonio, TestimonioDTO.class);
        responseDTO.setIdUsuario(testimonio.getUsuario().getIdUsuario());
        responseDTO.setIdCategoria(testimonio.getCategoria().getIdCategoria());
        responseDTO.setIdZona(testimonio.getZona().getIdZona());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(testimonio.getIdTestimonio())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestimonioDTO> buscarPorId(@PathVariable Long id) {
        Testimonio testimonio = tS.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un testimonio con el id: " + id));

        TestimonioDTO dto = modelMapper.map(testimonio, TestimonioDTO.class);
        dto.setIdUsuario(testimonio.getUsuario().getIdUsuario());
        dto.setIdCategoria(testimonio.getCategoria().getIdCategoria());
        dto.setIdZona(testimonio.getZona().getIdZona());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<TestimonioDTO> actualizar(@Valid @RequestBody TestimonioDTO dto) {
        Testimonio existente = tS.listId(dto.getIdTestimonio())
                .orElseThrow(() -> new ResourceNotFoundException("No existe un testimonio con el id: " + dto.getIdTestimonio()));

        Usuario usuario = uS.listId(dto.getIdUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("No existe un usuario con el id: " + dto.getIdUsuario()));

        Categoria categoria = cS.listId(dto.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una categoría con el id: " + dto.getIdCategoria()));

        Zona zona = zS.listId(dto.getIdZona())
                .orElseThrow(() -> new ResourceNotFoundException("No existe una zona con el id: " + dto.getIdZona()));

        existente.setUsuario(usuario);
        existente.setCategoria(categoria);
        existente.setZona(zona);
        existente.setDescripcionTexto(dto.getDescripcionTexto());
        existente.setFotoUrl(dto.getFotoUrl());
        existente.setDireccionTextoExtraida(dto.getDireccionTextoExtraida());
        existente.setLatitud(dto.getLatitud());
        existente.setLongitud(dto.getLongitud());
        existente.setEstado(dto.getEstado());
        existente.setFechaActualizacion(LocalDateTime.now());

        tS.update(existente);

        TestimonioDTO responseDTO = modelMapper.map(existente, TestimonioDTO.class);
        responseDTO.setIdUsuario(existente.getUsuario().getIdUsuario());
        responseDTO.setIdCategoria(existente.getCategoria().getIdCategoria());
        responseDTO.setIdZona(existente.getZona().getIdZona());
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Testimonio testimonio = tS.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un testimonio con el id: " + id));

        tS.delete(testimonio.getIdTestimonio());
        return ResponseEntity.noContent().build();
    }
}
