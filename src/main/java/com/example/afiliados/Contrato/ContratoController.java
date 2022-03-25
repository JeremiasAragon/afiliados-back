package com.example.afiliados.Contrato;

import com.example.afiliados.Afiliado.Afiliado;
import com.example.afiliados.Afiliado.AfiliadoRepository;
import com.example.afiliados.TipoDocumento.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/contrato")
@CrossOrigin(origins = "*")
public class ContratoController {
    private final ContratoService contratoService;

    @Autowired
    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    public List<Contrato> getContratos() {
        return this.contratoService.getContratos();
    }

    @PostMapping
    public void createNewContrato(@RequestBody Contrato contrato) {
        this.contratoService.createNewContrato(contrato);
    }

    @PutMapping(path = "{contratoId}")
    public void updateContrato(
            @PathVariable("contratoId") Long contratoId,
            @RequestParam(required = true) Integer cantidadUsuarios,
            @RequestParam(required = true) LocalDate fechaInicio,
            @RequestParam(required = true) LocalDate fechaRegistro,
            @RequestParam(required = true) LocalDate fechaRetiro,
            @RequestParam(required = true) String eps,
            @RequestParam(required = true) Afiliado afiliado
    ) {
        this.contratoService.updateContrato(contratoId, cantidadUsuarios, fechaInicio, fechaRegistro, fechaRetiro, eps, afiliado);
    }

    @DeleteMapping(path = "{contratoId}")
    public void deleteContrato(@PathVariable("contratoId") Long id) {
        contratoService.deleteContrato(id);
    }
}
