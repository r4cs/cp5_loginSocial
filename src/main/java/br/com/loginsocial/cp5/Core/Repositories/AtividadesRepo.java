package br.com.loginsocial.cp5.Core.Repositories;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadesRepo extends JpaRepository<Atividades, Long> {

    @Override
    Page<Atividades> findAll(Pageable pageable);

}
