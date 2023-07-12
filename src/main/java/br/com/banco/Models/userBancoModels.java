package br.com.banco.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

// TABELA CONTA
@Data
@AllArgsConstructor
@Entity
@Table(name = "conta")
public class userBancoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "nome_responsavel", nullable = false)
    private String nomeResponsavel;
}