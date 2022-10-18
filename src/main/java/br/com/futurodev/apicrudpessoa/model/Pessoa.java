package br.com.futurodev.apicrudpessoa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
//    private LocalDate dataNascimento;

    @JsonFormat(pattern="HH:mm:ss")
    private Date horasNascimento;
//    private LocalTime horasNascimento;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String estado;

    @Column(length = 50)
    private String cidade;

    @Column(length = 50)
    private String logradouro;

    @Column(length = 8)
    private String cep;


}
