package pe.edu.upc.reportandbeheard.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upc.reportandbeheard.dtos.UsuarioDTO;
import pe.edu.upc.reportandbeheard.entities.Rol;
import pe.edu.upc.reportandbeheard.entities.Usuario;
import pe.edu.upc.reportandbeheard.exceptions.ResourceNotFoundException;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IRolService;
import pe.edu.upc.reportandbeheard.servicesinterfaces.IUsuarioService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis/usuarios")
public class UsuarioController {
    private final IUsuarioService uS;
    private final IRolService rS;
    private final ModelMapper modelMapper;

    public UsuarioController(IUsuarioService uS, IRolService rS, ModelMapper modelMapper) {
        this.uS = uS;
        this.rS = rS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> lista = uS.list()
                .stream()
                .map(u -> {
                    UsuarioDTO dto = modelMapper.map(u, UsuarioDTO.class);
                    dto.setIdRol(u.getRol().getIdRol());
                    return dto;
                })
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrar(@Valid @RequestBody UsuarioDTO dto) {
        Rol rol = rS.listId(dto.getIdRol())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No existe un rol con el id: " + dto.getIdRol())
                );

        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario.setRol(rol);
        usuario.setFechaRegistro(LocalDateTime.now());

        uS.insert(usuario);

        UsuarioDTO responseDTO = modelMapper.map(usuario, UsuarioDTO.class);
        responseDTO.setIdRol(usuario.getRol().getIdRol());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getIdUsuario())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Usuario usuario = uS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No existe un usuario con el id: " + id)
                );

        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        dto.setIdRol(usuario.getRol().getIdRol());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> actualizar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario existente = uS.listId(dto.getIdUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No existe un usuario con el id: " + dto.getIdUsuario())
                );

        Rol rol = rS.listId(dto.getIdRol())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No existe un rol con el id: " + dto.getIdRol())
                );

        existente.setRol(rol);
        existente.setNombres(dto.getNombres());
        existente.setApellidos(dto.getApellidos());
        existente.setCorreo(dto.getCorreo());
        existente.setPasswordHash(dto.getPasswordHash());
        existente.setActivo(dto.getActivo());

        uS.update(existente);

        UsuarioDTO responseDTO = modelMapper.map(existente, UsuarioDTO.class);
        responseDTO.setIdRol(existente.getRol().getIdRol());
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Usuario usuario = uS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No existe un usuario con el id: " + id)
                );

        uS.delete(usuario.getIdUsuario());
        return ResponseEntity.noContent().build();
    }
}