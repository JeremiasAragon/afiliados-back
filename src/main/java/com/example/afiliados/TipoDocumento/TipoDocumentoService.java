package com.example.afiliados.TipoDocumento;

import com.example.afiliados.Contrato.Contrato;
import com.example.afiliados.Contrato.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public List<TipoDocumento> getTiposDocumento() {
        return tipoDocumentoRepository.findAll();
    }

    public void createNewTipoDocumento(TipoDocumento tipoDocumento) {
        tipoDocumentoRepository.save(tipoDocumento);
    }

    public void deleteTipoDocumento(Long id) {
        if (!tipoDocumentoRepository.existsById(id)) {
            throw new IllegalStateException("El tipo de documento no existe en la base de datos");
        }

        tipoDocumentoRepository.deleteById(id);
    }

    @Transactional
    public void updateTipoDocumento(
            Long tipoDocumentoId,
            String nombre,
            Integer estado
    ) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tipoDocumentoId)
                .orElseThrow(() -> new IllegalStateException("El tipo de documento no existe en la base de datos"));

        if (nombre != null && nombre.length() > 0) {
            tipoDocumento.setNombre(nombre);
        }

        if (estado != null) {
            tipoDocumento.setEstado(estado);
        }
    }

    public Optional<TipoDocumento> getTipoDocumentoById(Long id) {
        return this.tipoDocumentoRepository.findById(id);
    }
}
