package diego.ferreiro.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int creditos;

    @Column(nullable = false, unique = true)
    private String codigo;

    @OneToMany(mappedBy = "asignatura")
    private List<Matricula> matriculas = new ArrayList<>();

    public Asignatura() {
    }

    public Asignatura(String nombre, int creditos, String codigo) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.codigo = codigo;
    }

}
