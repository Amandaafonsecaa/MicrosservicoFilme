package unifor.br.cinemafilme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import unifor.br.cinemafilme.model.filmeModel;

@Repository
public interface filmeRepository extends MongoRepository<filmeModel, String>{
    //retorno nome e parametro
    List<filmeModel> findByTitulo(String titulo);
    List<filmeModel> findByGenero(String genero);
    List<filmeModel> findByClassificacao(String classificacao);
    List<filmeModel> findByTituloContaining(String titulo);
    List<filmeModel> findByStatusIgnoreCase(String string);

} 
