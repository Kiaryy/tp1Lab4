package utn.supercell.TP1.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticiaJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDNoticia;
    
    @Column(nullable = false)
    private String tituloNoticia;
    @Column(nullable = false)
    private String resumenNoticia;
    @Column(nullable = false)
    private String imagenNoticia;
    @Column(nullable = false)
    private String contenidoHTML;
    @Column(nullable = false)
    private char publicada;
    @Column(nullable = false)
    private LocalDateTime fechaPublicacion;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false) // Foreign key de empresa
    private EmpresaJpa empresa;
}
