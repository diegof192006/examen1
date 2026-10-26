package diego.ferreiro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import diego.ferreiro.Entities.Matricula;

public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByCalificacionGreaterThanEqual(Double nota);
}