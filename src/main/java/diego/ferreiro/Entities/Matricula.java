package diego.ferreiro.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import diego.ferreiro.Enums.Convocatoria;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaMatriculacion;

    // Double (objeto) para que pueda ser null: matrícula aún sin nota
    private Double calificacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Convocatoria convocatoria;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    public Matricula() {
    }

    public Matricula(LocalDate fechaMatriculacion, Double calificacion, Convocatoria convocatoria,
            Estudiante estudiante, Asignatura asignatura) {
        this.fechaMatriculacion = fechaMatriculacion;
        this.calificacion = calificacion;
        this.convocatoria = convocatoria;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }

}