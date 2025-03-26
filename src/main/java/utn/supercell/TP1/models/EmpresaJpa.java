package utn.supercell.TP1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDEmpresa;

    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String horarioDeAtencion;
    @Column(nullable = false)
    private String quienesSomos;
    @Column(nullable = false)
    private String domicilio;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private float latitud;
    @Column(nullable = false)
    private float longitud;
}
