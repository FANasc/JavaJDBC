package Part4Curso;

/********************************************************************************************************
 *
 * Objetivo: Executar operações de Consulta, Inclusão, Alteração e Deleção de registros na tabela Curso
 * Autor   : Fernando Aguiar
 * Data    : 12.08.2021
 *
 ********************************************************************************************************/

public class QueriesExecutionCurso {
    public static void main(String[] args) {

        //Listar no console todos os registros da tabela Curso
        CursoDAO cursoDAO = new CursoDAO();
        //List<Curso> cursos = cursoDAO.List();
        //cursos.stream().forEach(System.out::println);

        //Listar no console 1 registro da tabela Curso
        //Curso cursoParaConsulta = cursoDAO.getById(1);
        //System.out.println(cursoParaConsulta);

        //Inserir 1 registro na tabela Curso
        //Curso cursoParaInsercao = new Curso(
        //        "Java Intermediario",
        //        60);
        //cursoDAO.create(cursoParaInsercao);

        //Deletar 1 registro da tabela Curso
        cursoDAO.List().stream().forEach(System.out::println);
        cursoDAO.delete(2);
        cursoDAO.List().stream().forEach(System.out::println);

        //Alterar 1 registro da tabela Curso
        //cursoDAO.List().stream().forEach(System.out::println);
        //Curso cursoParaAtualizar = cursoDAO.getById(2);
        //cursoParaAtualizar.setNome("Java Intermediário");
        //cursoParaAtualizar.setDuracaoHoras(80);
        //cursoDAO.update(cursoParaAtualizar);
        //cursoDAO.List().stream().forEach(System.out::println);

    }
}
