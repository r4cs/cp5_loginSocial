package br.com.loginsocial.cp5.Core.Services.Mappers;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import br.com.loginsocial.cp5.Core.Entities.DTO.AtividadesDTO;
import org.springframework.stereotype.Component;

@Component
public class AtividadesMapperImp implements  AtividadesMapper{

    @Override
    public AtividadesDTO entityToDto(Atividades atividadesSource) {
        if (atividadesSource == null) {
            return null;
        }
        return new AtividadesDTO(
                atividadesSource.getId(),
                atividadesSource.getAtividade(),
                atividadesSource.getDescricao(),
                atividadesSource.getCriado_em(),
                atividadesSource.getLocalizacao(),
                atividadesSource.getMax_participantes()
        );
    }

    @Override
    public Atividades dtoToEntity(AtividadesDTO dto) {
        return new Atividades(dto);
    }
}
