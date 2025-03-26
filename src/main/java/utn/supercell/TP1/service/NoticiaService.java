package utn.supercell.TP1.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import utn.supercell.TP1.DTO.Request.NoticiaDTO;
import utn.supercell.TP1.models.EmpresaJpa;
import utn.supercell.TP1.models.NoticiaJpa;
import utn.supercell.TP1.repository.EmpresaRepository;
import utn.supercell.TP1.repository.NoticiaRepository;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<NoticiaJpa> getAllNoticias(){
        return noticiaRepository.findAll();
    }

    @Transactional
    public String addNoticia(NoticiaDTO noticiaDTO){
        Optional<EmpresaJpa> entityOptional = empresaRepository.findById(noticiaDTO.empresa());
        EmpresaJpa empresa = entityOptional.get();
        NoticiaJpa noticiaJpa = NoticiaJpa.builder()
            .tituloNoticia(noticiaDTO.tituloNoticia())
            .resumenNoticia(noticiaDTO.resumenNoticia())
            .imagenNoticia(noticiaDTO.imagenNoticia())
            .contenidoHTML(noticiaDTO.contenidoHTML())
            .publicada(noticiaDTO.publicada())
            .fechaPublicacion(LocalDateTime.now())
            .empresa(empresa)
            .build();
        noticiaRepository.save(noticiaJpa);
        return "Noticia Añadida";
    }

    // No vamos a usar el update, vamos a usar patch ahora
    @Transactional
    public NoticiaJpa patchNoticia(Long ID, NoticiaDTO noticiaDTO){
        return noticiaRepository.findById(ID).map(existingNoticia ->{
            // Un if por cada campo
            if (noticiaDTO.tituloNoticia() != null){
                existingNoticia.setTituloNoticia(noticiaDTO.tituloNoticia());
            }
            if (noticiaDTO.resumenNoticia() != null) {
                existingNoticia.setResumenNoticia(noticiaDTO.resumenNoticia());
            }
            if (noticiaDTO.imagenNoticia() != null) {
                existingNoticia.setImagenNoticia(noticiaDTO.imagenNoticia());
            }
            if (noticiaDTO.contenidoHTML() != null) {
                existingNoticia.setContenidoHTML(noticiaDTO.contenidoHTML());
            }
            if (noticiaDTO.publicada() != ' ') {
                existingNoticia.setPublicada(noticiaDTO.publicada());
            }
            if (noticiaDTO.empresa() != null) {
                Optional<EmpresaJpa> entityOptional = empresaRepository.findById(noticiaDTO.empresa());
                EmpresaJpa empresa = entityOptional.get();
                existingNoticia.setEmpresa(empresa);
            }
            // Al final se guarda la entidad en el repositorio
            // Ejemplo de la request
            // { "tituloNoticia": "Nuevo Titulo" }
            // Con el patch podes mandar un solo campo sin tener que mandar el objeto entero
            return noticiaRepository.save(existingNoticia);
        }).orElseThrow(() -> new EntityNotFoundException("No se encontro una noticia con el ID: " + ID));
    }
}
