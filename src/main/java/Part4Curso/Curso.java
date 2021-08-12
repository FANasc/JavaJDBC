package Part4Curso;

/*********************************************************************
 *
 * Objetivo: Criar a Classe Curso - espelho do Banco de Dados Curso.
 * Autor   : Fernando Aguiar
 * Data    : 12.08.2021
 *
 *********************************************************************/

public class Curso {

    private int id;
    private String nome;
    private int duracaoHoras;

    // Método construtor com assinatura completa.
    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    // Método construtor com assinatura sem o atributo id.
    public Curso(String nome, int duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    // Método construtor sem atributo na assinatura.
    public Curso() {}

    // Métodos get e set.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracao em horas='").append(duracaoHoras).append("'}");
        return sb.toString();
    }
}
