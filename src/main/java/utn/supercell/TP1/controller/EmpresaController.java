package utn.supercell.TP1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utn.supercell.TP1.DTO.Request.EmpresaDTO;
import utn.supercell.TP1.models.EmpresaJpa;
import utn.supercell.TP1.service.EmpresaService;

@RestController
@RequestMapping("/empresa/")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("getAll")
    public List<EmpresaJpa> findAll(){
        return empresaService.getAllEmpresas();
    }

    @PostMapping("add")
    public ResponseEntity<String> addEmpresa(@RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.addEmpresa(empresaDTO));
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<EmpresaJpa> patchEmpresa(@PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        EmpresaJpa nuevaEmpresa = empresaService.patchEmpresa(id, empresaDTO);
        return ResponseEntity.ok(nuevaEmpresa);
    }
}
