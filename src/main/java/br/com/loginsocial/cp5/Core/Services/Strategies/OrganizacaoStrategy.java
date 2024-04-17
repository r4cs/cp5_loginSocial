package br.com.loginsocial.cp5.Core.Services.Strategies;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public interface OrganizacaoStrategy {
    Page<Atividades> organizar(Page<Atividades> atividades);
}
