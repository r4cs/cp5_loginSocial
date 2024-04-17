package br.com.loginsocial.cp5.Core.Entities;


import br.com.loginsocial.cp5.Core.Entities.DTO.AtividadesDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="TB_atividades_cp5")
public class Atividades {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String atividade;

    private String descricao;

    private LocalDateTime criado_em;

    private String localizacao;

    private Integer max_participantes;

    public Atividades() {};

    public Atividades(AtividadesDTO dto) {
        this.id=dto.id();
        this.atividade=dto.atividade();
        this.descricao=dto.descricao();
        this.criado_em=LocalDateTime.now();
        this.localizacao=dto.localizacao();
        this.max_participantes= dto.max_participantes();
    }

}
