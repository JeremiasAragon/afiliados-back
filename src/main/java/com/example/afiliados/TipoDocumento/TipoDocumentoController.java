package com.example.afiliados.TipoDocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tipo-documento")
@CrossOrigin(origins = "*")
public class TipoDocumentoController {
    private final TipoDocumentoService tipoDocumentoService;

    @Autowired
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping
    public List<TipoDocumento> getTiposDocumento() {
        return this.tipoDocumentoService.getTiposDocumento();
    }

    @GetMapping(path = "{id}")
    public Optional<TipoDocumento> getTipoDocumentoById(
            @PathVariable("id") Long id
    ) {
        return this.tipoDocumentoService.getTipoDocumentoById(id);
    }

    @PostMapping
    public void createNewTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        this.tipoDocumentoService.createNewTipoDocumento(tipoDocumento);
    }

    @PutMapping(path = "{tipoDocumentoId}")
    public void updateTipoDocumento(
            @PathVariable("tipoDocumentoId") Long tipoDocumentoId,
            @RequestParam(required = true) String nombre,
            @RequestParam(required = true) Integer estado
    ) {
        this.tipoDocumentoService.updateTipoDocumento(tipoDocumentoId, nombre, estado);
    }

    @DeleteMapping(path = "{tipoDocumentoId}")
    public void deleteTipoDocumento(@PathVariable("tipoDocumentoId") Long id) {
        tipoDocumentoService.deleteTipoDocumento(id);
    }
}
