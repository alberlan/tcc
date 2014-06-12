
package br.com.sgce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "nota")
public class Nota implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private float nota1;
    private float nota2;
    private float nota3;
    private float nota4;
    private float mediafinal;
    private Date datalancamento;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(length = 5)
    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    
    @Column(length = 5)
    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    
    @Column(length = 5)
    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    
    @Column(length = 5)
    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    
    @Column(length = 5)
    public float getMediafinal() {
        return mediafinal;
    }

    public void setMediafinal(float mediafinal) {
        this.mediafinal = mediafinal;
    }

    
    @Temporal(TemporalType.DATE)   
    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

       
    
}
