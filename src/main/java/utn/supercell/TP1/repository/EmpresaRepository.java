package utn.supercell.TP1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.supercell.TP1.models.EmpresaJpa;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaJpa, Long>{

}
