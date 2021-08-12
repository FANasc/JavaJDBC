package Part4Curso;

/******************************************************************************
 *
 * Objetivo: Criar métodos que permitam consultar, inserir, alterar e deletar
 *           registros do Banco de Dados Curso.
 * Autor   : Fernando Aguiar
 * Data    : 12.08.2021
 *
 *****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // Consulta a tabela Curso
    public List<Curso> List(){
        List<Curso> cursos = new ArrayList<>();

    try (Connection conn = ConnectionFactory.getConnection()) {
        String sql = "SELECT * FROM curso";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int duracaoHoras = rs.getInt("duracao_horas");

            cursos.add(new Curso(
                    id,
                    nome,
                    duracaoHoras
            ));
        }
    } catch (SQLException e) {
        System.out.println("Listagem de cursos FALHOU!");
        e.printStackTrace();
    }

    return cursos;
    }

    // Consulta a tabela Curso com filtro
    public Curso getById(int id) {
        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
        }

        return curso;
    }

    // Cria um registro na tabela Curso.
    public static void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES (?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida! Foi adicionada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // Deleta um registro da tabela Curso.
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Deleção bem sucedida! Foi deletada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Deleção FALHOU!");
            e.printStackTrace();
        }
    }

    // Altera um registro da tabela Curso.
    public static void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida! Foi atualizada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }
}