package com.example.afiliados.Afiliado;

import com.example.afiliados.TipoDocumento.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/afiliado")
@CrossOrigin(origins = "*")
public class AfiliadoController {
    private final AfiliadoService afiliadoService;

    @Autowired
    public AfiliadoController(AfiliadoService afiliadoService) {
        this.afiliadoService = afiliadoService;
    }

    @GetMapping
    public List<Afiliado> getAfiliados() {
        return this.afiliadoService.getAfiliados();
    }

    @GetMapping(path = "{id}")
    public Optional<Afiliado> getAfiliadoById(
            @PathVariable("id") Long id
    ) {
        return this.afiliadoService.getAfiliadoById(id);
    }

    @PostMapping
    public void createNewAfiliado(@RequestBody Afiliado afiliado) {
        this.afiliadoService.createNewAfiliado(afiliado);
    }

    @PutMapping(path = "{afiliadoId}")
    public void updateAfiliado(
            @PathVariable("afiliadoId") Long afiliadoId,
            @RequestParam(required = true) String nombre,
            @RequestParam(required = true) String apellidos,
            @RequestParam(required = true) String documento,
            @RequestParam(required = true) String direccion,
            @RequestParam(required = true) String telefono,
            @RequestParam(required = true) String mail,
            @RequestParam(required = true) TipoDocumento tipoDocumento
    ) {
        this.afiliadoService.updateAfiliado(afiliadoId, nombre, apellidos, documento, direccion, telefono, mail, tipoDocumento);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAfiliado(@PathVariable("id") Long id) {
        afiliadoService.deleteAfiliado(id);
    }
}
