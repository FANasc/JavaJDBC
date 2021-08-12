package Part2;

/********************************************************************************************************
 *
 * Objetivo: Estabelecer conexão entre o Java e o Banco de Dados
 * Autor   : Fernando Aguiar
 * Data    : 12.08.2021
 *
 ********************************************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    public static void main(String[] args) {

        String urlconnection = "jdbc:mysql://localhost:3306/digital_innovation_one";

        // Declando a conexão no próprio try não há necessidade de finalizar conexão. Esta é feita automaticamente.
        try (Connection conn = DriverManager.getConnection(urlconnection, "root", "mhdd0304MS")) {
            System.out.println("Sucesso!");
        } catch (Exception e) {
            System.out.println("Falha!");
            e.printStackTrace();
        }
    }
}