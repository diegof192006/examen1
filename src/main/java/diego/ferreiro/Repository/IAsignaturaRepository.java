package diego.ferreiro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diego.ferreiro.Entities.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long> {
    long countByCreditos(int creditos);
}