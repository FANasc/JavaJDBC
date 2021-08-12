package Part3;

/*********************************************************************
 *
 * Objetivo: Criar a Classe Aluno - espelho do Banco de Dados Aluno.
 * Autor   : Fernando Aguiar
 * Data    : 11.08.2021
 *
 *********************************************************************/

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private String estado;

    // Método construtor com assinatura completa.
    public Aluno(int id, String nome, int idade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    // Método construtor com assinatura sem o atributo id.
    public Aluno(String nome, int idade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    // Método construtor sem atributo na assinatura.
    public Aluno() {}

    // Métodos get e set.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aluno{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append(", estado='").append(estado).append("'}");
        return sb.toString();
    }
}
