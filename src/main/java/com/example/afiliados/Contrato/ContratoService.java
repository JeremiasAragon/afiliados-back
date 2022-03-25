package com.example.afiliados.Contrato;

import com.example.afiliados.Afiliado.Afiliado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    @Autowired
    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<Contrato> getContratos() {
        return contratoRepository.findAll();
    }

    public void createNewContrato(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    public void deleteContrato(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new IllegalStateException("El contrato no existe en la base de datos");
        }

        contratoRepository.deleteById(id);
    }

    @Transactional
    public void updateContrato(
        Long id,
        Integer cantidadUsuarios,
        LocalDate fechaInicio,
        LocalDate fechaRegistro,
        LocalDate fechaRetiro,
        String eps,
        Afiliado afiliado
    ) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El contrato no existe en la base de datos"));

        if (cantidadUsuarios != null) {
            contrato.setCantidadUsuarios(cantidadUsuarios);
        }

        if (fechaInicio != null) {
            contrato.setFechaInicio(fechaInicio);
        }

        if (fechaRegistro != null) {
            contrato.setFechaRegistro(fechaRegistro);
        }

        if (fechaRetiro != null) {
            contrato.setFechaRetiro(fechaRetiro);
        }

        if (eps != null && eps.length() > 0) {
            contrato.setEps(eps);
        }

        if (afiliado != null) {
            contrato.setAfiliado(afiliado);
        }
    }
}
