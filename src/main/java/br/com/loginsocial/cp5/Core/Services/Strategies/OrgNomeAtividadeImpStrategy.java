package br.com.loginsocial.cp5.Core.Services.Strategies;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class OrgNomeAtividadeImpStrategy implements OrganizacaoStrategy {

    @Override
    public Page<Atividades> organizar(Page<Atividades> atividades) {
        List<Atividades> atividadesList = atividades.getContent();
        atividadesList.sort(Comparator.comparing(Atividades::getAtividade));
        return new PageImpl<>(atividadesList, atividades.getPageable(), atividades.getTotalElements());
    }
}
