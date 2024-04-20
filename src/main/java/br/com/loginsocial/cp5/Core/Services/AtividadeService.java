package br.com.loginsocial.cp5.Core.Services;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import br.com.loginsocial.cp5.Core.Entities.DTO.AtividadesDTO;
import br.com.loginsocial.cp5.Core.Repositories.AtividadesRepo;
import br.com.loginsocial.cp5.Core.Services.Mappers.AtividadesMapperImp;
import br.com.loginsocial.cp5.Core.Services.Strategies.OrgCapMaxPessoasImpStrategy;
import br.com.loginsocial.cp5.Core.Services.Strategies.OrgCriadoEmImpStrategy;
import br.com.loginsocial.cp5.Core.Services.Strategies.OrgNomeAtividadeImpStrategy;
import br.com.loginsocial.cp5.Core.Services.Strategies.OrgPorLocalizacaoImpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtividadeService {

    private final AtividadesRepo repo;
    private final AtividadesMapperImp mapper;
    private final OrgCapMaxPessoasImpStrategy orgCapMaxStrategy;
    private final OrgCriadoEmImpStrategy orgCriadoEmStrategy;
    private final OrgNomeAtividadeImpStrategy orgNmAtvStrategy;
    private final OrgPorLocalizacaoImpStrategy orgLocStrategy;

    @Autowired
    public AtividadeService(AtividadesRepo repo,
                            AtividadesMapperImp mapper,
                            OrgCapMaxPessoasImpStrategy orgCapMaxStrategy,
                            OrgCriadoEmImpStrategy orgCriadoEmStrategy,
                            OrgNomeAtividadeImpStrategy orgNmAtvStrategy,
                            OrgPorLocalizacaoImpStrategy orgLocStrategy) {
        this.repo = repo;
        this.mapper=mapper;
        this.orgCapMaxStrategy=orgCapMaxStrategy;
        this.orgCriadoEmStrategy=orgCriadoEmStrategy;
        this.orgNmAtvStrategy=orgNmAtvStrategy;
        this.orgLocStrategy=orgLocStrategy;
    }

    @Transactional
    public String create(AtividadesDTO dto) {
        repo.save(mapper.dtoToEntity(dto));
        return "Atividade Criada com Sucesso";
    }

    @Transactional
    public String update(Long id, Atividades atividadeAtualizada) {
        Optional<Atividades> atividadeAntiga = repo.findById(id);

        if (atividadeAntiga.isPresent()) {
            Atividades atividades = atividadeAntiga.get();

            Optional.ofNullable(atividadeAtualizada.getAtividade())
                    .ifPresent(atividades::setAtividade);

            Optional.ofNullable(atividadeAtualizada.getDescricao())
                    .ifPresent(atividades::setDescricao);

            Optional.ofNullable(atividadeAtualizada.getCriado_em())
                    .ifPresent(atividades::setCriado_em);

            Optional.ofNullable(atividadeAtualizada.getLocalizacao())
                    .ifPresent(atividades::setLocalizacao);

            Optional.ofNullable(atividadeAtualizada.getMax_participantes())
                    .ifPresent(atividades::setMax_participantes);

            repo.save(atividades);

            return "Atividade atualizada com sucesso.";
        }
        return "Atividade não encontrada. Verifique os dados inseridos.";
    }

    @Transactional
    public String delete(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return "Atividade excluída com sucesso";
        }
        return "Atividade não encontrada. Verifique os dados inseridos.";
    }

    public AtividadesDTO findById(Long id) {
        Atividades atividades = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        return mapper.entityToDto(atividades);
    }

    public Page<Atividades> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }


    public Page<Atividades> organizarPorCapacidade(Pageable pageable) {
        Page<Atividades> atividades = repo.findAll(pageable);
        return orgCapMaxStrategy.organizar(atividades);
    }

    public Page<Atividades> organizarPorDataHora(Pageable pageable) {
        Page<Atividades> atividades = repo.findAll(pageable);
        return orgCriadoEmStrategy.organizar(atividades);
    }

    public Page<Atividades> organizarPorNomeAtividade(Pageable pageable) {
        Page<Atividades> atividades = repo.findAll(pageable);
        return orgNmAtvStrategy.organizar(atividades);
    }

    public Page<Atividades> organizarPorLocalizacao(Pageable pageable) {
        Page<Atividades> atividades = repo.findAll(pageable);
        return orgLocStrategy.organizar(atividades);
    }
}
