package Part3;

/******************************************************************************
 *
 * Objetivo: Criar métodos que permitam consultar, inserir, alterar e deletar
 *           registros do Banco de Dados Aluno.
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

public class AlunoDAO {

    // Consulta a tabela Aluno
    public List<Aluno> List(){
        List<Aluno> alunos = new ArrayList<>();

    try (Connection conn = ConnectionFactory.getConnection()) {
        String sql = "SELECT * FROM  aluno";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            String estado = rs.getString("estado");

            alunos.add(new Aluno(
                    id,
                    nome,
                    idade,
                    estado
            ));
        }
        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        return alunos;
    }

    // Consulta a tabela Aluno com filtro
    public Aluno getById(int id) {
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        return aluno;
    }

    // Cria um registro na tabela Aluno.
    public static void create(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3,aluno.getEstado());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida! Foi adicionada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // Deleta um registro da tabela Aluno.
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Deleção bem sucedida! Foi deletada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Deleção FALHOU!");
            e.printStackTrace();
        }
    }

    // Altera um registro da tabela Aluno.
    public static void update(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3,aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida! Foi atualizada " + rowsAffected + " linha!");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

}