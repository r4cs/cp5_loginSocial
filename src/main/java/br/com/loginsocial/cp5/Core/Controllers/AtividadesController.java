package br.com.loginsocial.cp5.Core.Controllers;

import br.com.loginsocial.cp5.Core.Entities.Atividades;
import br.com.loginsocial.cp5.Core.Entities.DTO.AtividadesDTO;
import br.com.loginsocial.cp5.Core.Services.AtividadeService;
import br.com.loginsocial.cp5.Core.Services.Mappers.AtividadesMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atividades")
public class AtividadesController {

    private final AtividadeService service;
    private final AtividadesMapper mapper;
//    private static AtividadesMapper mapper;

    @Autowired
    public AtividadesController(AtividadeService service,
                                AtividadesMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<String> criarAtividade(@RequestBody @Valid AtividadesDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<String> atualizarAtividade(@PathVariable Long id, @RequestBody @Valid AtividadesDTO dto) {
        return ResponseEntity.ok(service.update(id, mapper.dtoToEntity(dto)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtividadesDTO> getAtividadeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<Atividades>> listarAtividades(@RequestParam Integer page, @RequestParam Integer size) {
        Pageable defaultPageable = PageRequest.of(
                page,
                size,
                Sort.by("id")
        );

        Page<Atividades> atividades = service.findAll(defaultPageable);
        return ResponseEntity.ok(atividades);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deletarAtividade(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
