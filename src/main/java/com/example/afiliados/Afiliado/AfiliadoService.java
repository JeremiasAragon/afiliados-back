package com.example.afiliados.Afiliado;

import com.example.afiliados.TipoDocumento.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoService {

    private final AfiliadoRepository afiliadoRepository;

    @Autowired
    public AfiliadoService(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    public List<Afiliado> getAfiliados() {
        return afiliadoRepository.findAll();
    }

    public void createNewAfiliado(Afiliado afiliado) {
        Optional<Afiliado> afiliadoOptional = afiliadoRepository
                .findAfiliadoByDocumento(afiliado.getDocumento());

        if (afiliadoOptional.isPresent()) {
            throw new IllegalStateException("La persona ya se encuentra afiliada");
        }

        afiliadoRepository.save(afiliado);
    }

    public void deleteAfiliado(Long id) {
        if (!afiliadoRepository.existsById(id)) {
            throw new IllegalStateException("El afiliado no existe en la base de datos");
        }

        afiliadoRepository.deleteById(id);
    }

    @Transactional
    public void updateAfiliado(
        Long id,
        String nombre,
        String apellidos,
        String documento,
        String direccion,
        String telefono,
        String mail,
        TipoDocumento tipoDocumento
    ) {
        Afiliado afiliado = afiliadoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El afiliado no existe en la base de datos"));

        if (nombre != null && nombre.length() > 0) {
            afiliado.setNombre(nombre);
        }

        if (apellidos != null && apellidos.length() > 0) {
            afiliado.setApellidos(apellidos);
        }

        if (documento != null && documento.length() > 0) {
            afiliado.setDocumento(documento);
        }

        if (direccion != null && direccion.length() > 0) {
            afiliado.setDireccion(direccion);
        }

        if (telefono != null && telefono.length() > 0) {
            afiliado.setTelefono(telefono);
        }

        if (mail != null && mail.length() > 0) {
            afiliado.setMail(mail);
        }

        if (tipoDocumento != null) {
            afiliado.setTipoDocumento(tipoDocumento);
        }
    }

    public Optional<Afiliado> getAfiliadoById(Long id) {
        return this.afiliadoRepository.findById(id);
    }
}
