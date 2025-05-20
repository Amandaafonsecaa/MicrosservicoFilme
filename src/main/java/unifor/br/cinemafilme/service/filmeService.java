package unifor.br.cinemafilme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unifor.br.cinemafilme.model.filmeModel;
import unifor.br.cinemafilme.repository.filmeRepository;

@Service
public class filmeService {
    @Autowired
    private filmeRepository repository;

    public filmeModel salvarFilme(filmeModel filme){
        return repository.save(filme);
    }
    public List<filmeModel> buscarPorTitulo(String titulo){
        return repository.findByTituloContaining(titulo);
    }
    public Optional<filmeModel> buscarPorId(String id){
        return repository.findById(id);
    }
    public List<filmeModel> listar(){
        return repository.findAll();
    }
    public void deletar(String id){
        repository.deleteById(id);
    }
    public boolean existe(String id){
        return repository.existsById(id);
    }
    public filmeModel editarFilme(String id, filmeModel filme){
        Optional<filmeModel> existe = repository.findById(id);
        if(existe.isPresent()){
            filmeModel filmeEditar = existe.get(); //pegando o sim
            filmeEditar.setTitulo(filme.getTitulo());
            filmeEditar.setGenero(filme.getGenero());
            filmeEditar.setDuracao(filme.getDuracao());
            filmeEditar.setClassificacao(filme.getClassificacao());
            filmeEditar.setDiretor(filme.getDiretor());

            return repository.save(filmeEditar);
        }
        return null;
    }
}
