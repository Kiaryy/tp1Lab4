package utn.supercell.TP1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utn.supercell.TP1.DTO.Request.NoticiaDTO;
import utn.supercell.TP1.models.NoticiaJpa;
import utn.supercell.TP1.service.NoticiaService;

@RestController
@RequestMapping("/noticia/")
@CrossOrigin(origins = "*")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("getAll")
    public List<NoticiaJpa> findAll(){
        return noticiaService.getAllNoticias();
    }

    @PostMapping("add")
    public ResponseEntity<String> addEmpresa(@RequestBody NoticiaDTO noticiaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(noticiaService.addNoticia(noticiaDTO));
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<NoticiaJpa> patchNoticia(@PathVariable Long id, @RequestBody NoticiaDTO noticiaDTO){
        NoticiaJpa nuevaNoticia = noticiaService.patchNoticia(id, noticiaDTO);
        return ResponseEntity.ok(nuevaNoticia);
    }
}
