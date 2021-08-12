package Part3;

/********************************************************************************************************
 *
 * Objetivo: Executar operações de Consulta, Inclusão, Alteração e Deleção de registros na tabela Aluno
 * Autor   : Fernando Aguiar
 * Data    : 11.08.2021
 *
 ********************************************************************************************************/

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {

        //Listar no console todos os registros da tabela Aluno
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.List();
        alunos.stream().forEach(System.out::println);

        //Listar no console 1 registro da tabela Aluno
        //Aluno alunoParaConsulta = alunoDAO.getById(4);
        //System.out.println(alunoParaConsulta);

        //Inserir 1 registro na tabela Aluno
        //Aluno alunoParaInsercao = new Aluno(
        //        "Mateus",
        //        43,
        //        "SP");
        //AlunoDAO.create(alunoParaInsercao);

        //Deletar 1 registro da tabela Aluno
        //alunoDAO.List().stream().forEach(System.out::println);
        //alunoDAO.delete(4);
        //alunoDAO.List().stream().forEach(System.out::println);

        //Alterar 1 registro da tabela Aluno
        //alunoDAO.List().stream().forEach(System.out::println);
        //Aluno alunoParaAtualizar = alunoDAO.getById(3);
        //alunoParaAtualizar.setNome("Joaquim");
        //alunoParaAtualizar.setIdade(18);
        //alunoParaAtualizar.setEstado("RS");
        //alunoDAO.update(alunoParaAtualizar);
        //alunoDAO.List().stream().forEach(System.out::println);

    }
}
