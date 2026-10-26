package diego.ferreiro.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_expediente", nullable = false, unique = true)
    private ExpedienteAcademico expediente;

    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas = new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(String dni, String nombre, String apellidos, ExpedienteAcademico expediente) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.expediente = expediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public ExpedienteAcademico getExpediente() {
        return expediente;
    }

    public void setExpediente(ExpedienteAcademico expediente) {
        this.expediente = expediente;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}