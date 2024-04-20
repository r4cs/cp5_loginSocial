package br.com.loginsocial.cp5.Core.Entities.DTO;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.sql.Update;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Atividades}
 */

public record AtividadesDTO(
        Long id,

        @NotBlank
        @Length(min=5,max=50)
        String atividade,

        @Length(min=0,max=255)
        String descricao,

        @DateTimeFormat
        LocalDateTime criado_em,

        String localizacao,

        Integer max_participantes ) implements Serializable {

    public AtividadesDTO(Atividades atividades) {
        this(
                atividades.getId(),
                atividades.getAtividade(),
                atividades.getDescricao(),
                atividades.getCriado_em(),
                atividades.getLocalizacao(),
                atividades.getMax_participantes()

        );
    }
}
