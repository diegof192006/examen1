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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Double getNotaMediaAcceso() {
        return notaMediaAcceso;
    }

    public void setNotaMediaAcceso(Double notaMediaAcceso) {
        this.notaMediaAcceso = notaMediaAcceso;
    }

}
