package diego.ferreiro.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "expedientes_academicos")
public class ExpedienteAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroExpediente;

    @Column(nullable = false)
    private LocalDate fechaApertura;

    @Column(nullable = false)
    private Double notaMediaAcceso;

    public ExpedienteAcademico() {
    }

    public ExpedienteAcademico(String numeroExpediente, LocalDate fechaApertura, Double notaMediaAcceso) {
        this.numeroExpediente = numeroExpediente;
        this.fechaApertura = fechaApertura;
        this.notaMediaAcceso = notaMediaAcceso;
    }

}
