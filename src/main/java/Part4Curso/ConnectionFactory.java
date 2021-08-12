package Part4Curso;

/********************************************************************************************************
 *
 * Objetivo: Estabelecer conexão entre o Java e o Banco de Dados
 * Autor   : Fernando Aguiar
 * Data    : 11.08.2021
 *
 ********************************************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    //Construtor declarado como privado. Evitando, assim, criar instâncias de fábrica.
    private ConnectionFactory() { throw new UnsupportedOperationException(); }

    public static Connection getConnection() {
        // Declarar objeto conexão
        Connection connection = null;

        try (InputStream input = ConnectionFactory
                .class.getClassLoader().getResourceAsStream("connection.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAdress = prop.getProperty("db.adress");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAdress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("Falha ao tentar criar conexão");
            }
        } catch (IOException e) {
            System.out.println("Falha ao tentar criar arquivo de propriedades");
            e.printStackTrace();
        }

        return connection;
    }
}