package utn.supercell.TP1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import utn.supercell.TP1.DTO.Request.EmpresaDTO;
import utn.supercell.TP1.models.EmpresaJpa;
import utn.supercell.TP1.repository.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaJpa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    // El Add es igual al del buen sabor
    @Transactional
    public String addEmpresa(EmpresaDTO empresaDTO){
        EmpresaJpa empresaJpa = EmpresaJpa.builder()
            .denominacion(empresaDTO.denominacion())
            .telefono(empresaDTO.telefono())
            .horarioDeAtencion(empresaDTO.horarioDeAtencion())
            .quienesSomos(empresaDTO.quienesSomos())
            .domicilio(empresaDTO.domicilio())
            .email(empresaDTO.email())
            .latitud(empresaDTO.latitud())
            .longitud(empresaDTO.longitud())
            .build();
        empresaRepository.save(empresaJpa);
        return "Empresa Añadida";
    }

    // No vamos a usar el update, vamos a usar patch ahora
    @Transactional
    public EmpresaJpa patchEmpresa(Long ID, EmpresaDTO empresaDTO){
        return empresaRepository.findById(ID).map(existingEmpresa ->{
            // Un if por cada campo
            if (empresaDTO.denominacion() != null){
                existingEmpresa.setDenominacion(empresaDTO.denominacion());
            }
            if (empresaDTO.telefono() != null) {
                existingEmpresa.setTelefono(empresaDTO.telefono());
            }
            if (empresaDTO.horarioDeAtencion() != null) {
                existingEmpresa.setHorarioDeAtencion(empresaDTO.horarioDeAtencion());
            }
            if (empresaDTO.quienesSomos() != null) {
                existingEmpresa.setQuienesSomos(empresaDTO.quienesSomos());
            }
            if (empresaDTO.denominacion() != null) {
                existingEmpresa.setDenominacion(empresaDTO.denominacion());
            }
            if (empresaDTO.email() != null) {
                existingEmpresa.setEmail(empresaDTO.email());
            }
            if (empresaDTO.latitud() != 0.0f) {
                existingEmpresa.setLatitud(empresaDTO.latitud());
            }
            if (empresaDTO.longitud() != 0.0f) {
                existingEmpresa.setLongitud(empresaDTO.longitud());
            }
            // Al final se guarda la entidad en el repositorio
            // Ejemplo de la request
            // { "email": "nuevoemail@gmail.com" }
            // Con el patch podes mandar un solo campo sin tener que mandar el objeto entero
            return empresaRepository.save(existingEmpresa);
        }).orElseThrow(() -> new EntityNotFoundException("No se encontro una empresa con el ID: " + ID));
    }

    

}
