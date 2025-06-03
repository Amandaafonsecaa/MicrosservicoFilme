package unifor.br.cinemafilme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unifor.br.cinemafilme.dto.filmeRequestDTO;
import unifor.br.cinemafilme.model.filmeModel;
import unifor.br.cinemafilme.service.filmeService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/filmes")
public class filmeController {

    @Autowired
    private filmeService service;

    private filmeModel fromDTO(filmeRequestDTO dto) {
        filmeModel filme = new filmeModel();
        filme.setTitulo(dto.getTitulo());
        filme.setDiretor(dto.getDiretor());
        filme.setDuracao(dto.getDuracao());
        filme.setGenero(dto.getGenero());
        filme.setStatus(dto.getStatus());
        return filme;
    }
    

    @GetMapping("/disponivel")
    public ResponseEntity<?> listarDisponíveis() {
        try{
            List<filmeModel> filmes = service.listarDisponiveis();
            if(filmes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(filmes, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar os filmes.");
        }
    }
    

    @PostMapping
    public ResponseEntity<?> salvarFilme(@Valid @RequestBody filmeRequestDTO filme) {
        try {
            filmeModel filmeNovo = fromDTO(filme);
            System.out.println("Filme recebido: " + filmeNovo);
            if (filmeNovo.getTitulo() == null || filmeNovo.getTitulo().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Título é obrigatório.");
            }
            filmeNovo = service.salvarFilme(filmeNovo);
            return new ResponseEntity<>(filmeNovo, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o filme."+e.getMessage());
        }
    }

    @GetMapping("/listar/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
        try{
            List<filmeModel> filme = service.buscarPorTitulo(nome);
            if(filme.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(filme, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o filme.");
        }
    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        try{
            Optional<filmeModel> filmeOptional = service.buscarPorId(id);
            if (filmeOptional.isPresent()) {
                return new ResponseEntity<>(filmeOptional.get(), HttpStatus.OK); // Retorna o filmeModel em si
            } else {
                return new ResponseEntity<>("Filme com ID " + id + " não encontrado.", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            // Logar a exceção aqui pode ser útil: e.printStackTrace();
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o filme por ID.");
           }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        try{
            Optional<filmeModel> filme = service.buscarPorId(id);
            if(filme.isPresent()){
                service.deletar(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o filme.");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarFilme(@PathVariable String id, @Valid @RequestBody filmeRequestDTO filme){
        try{
            Optional<filmeModel> existe = service.buscarPorId(id);
            if(existe.isPresent()){
                filmeModel atualizado = fromDTO(filme);
                filmeModel filmeEditado = service.editarFilme(id, atualizado);
                return new ResponseEntity<>(filmeEditado, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar o filme."); 
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        try{
            List<filmeModel> filmes = service.listar();
            if(filmes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(filmes, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar os filmes.");
        }
    }
}