package diego.ferreiro.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import diego.ferreiro.Entities.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByDni(String dni);

    @Query(value = "SELECT CONCAT(e.nombre, ' ', e.apellidos) "
            + "FROM estudiantes e "
            + "INNER JOIN matriculas m ON m.id_estudiante = e.id "
            + "INNER JOIN asignaturas a ON a.id = m.id_asignatura "
            + "WHERE a.codigo = :codigo", nativeQuery = true)
    List<String> findNombresCompletosPorCodigoAsignatura(@Param("codigo") String codigo);
}
