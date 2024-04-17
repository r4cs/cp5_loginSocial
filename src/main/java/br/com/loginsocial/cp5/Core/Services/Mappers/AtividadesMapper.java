package br.com.loginsocial.cp5.Core.Services.Mappers;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import br.com.loginsocial.cp5.Core.Entities.DTO.AtividadesDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AtividadesMapper {
    Atividades INSTANCE = Mappers.getMapper(Atividades.class);
    @BeanMapping
    AtividadesDTO entityToDto(Atividades atividades);
    @BeanMapping
    Atividades dtoToEntity(AtividadesDTO dto);
}
