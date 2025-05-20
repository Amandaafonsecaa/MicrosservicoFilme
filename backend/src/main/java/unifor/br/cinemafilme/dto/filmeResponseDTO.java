package unifor.br.cinemafilme.dto;

public class filmeResponseDTO {
    private String titulo;
    private String diretor;
    private float duracao;
    private String genero;
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public float getDuracao() {
        return duracao;
    }
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public filmeResponseDTO( String titulo, String diretor, int duracao, String genero) {
       
        this.titulo = titulo;
        this.diretor = diretor;
        this.duracao = duracao;
        this.genero = genero;
    }
}
