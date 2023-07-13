package br.com.banco.models;
import lombok.Data;
import javax.persistence.*;

// TABELA CONTA
@Data
@Entity
@Table(name = "conta")
public class UserConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsavel;
}