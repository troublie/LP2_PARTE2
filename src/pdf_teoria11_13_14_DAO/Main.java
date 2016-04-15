/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author juliano.lopes
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver carregado com sucesso");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro carregando o driver " + e);
        }

        String host = "localhost";
        int port = 1527;
        String dbName = "teoria11";
        String derbyURL = "jdbc:derby://" + host + ":" + port + "/" + dbName;

        String username = "app";
        String password = "app";

        Connection conexao;
        conexao = DriverManager.getConnection(derbyURL, username, password);
        System.out.println("Conexão estabelecida!");

        Statement st = conexao.createStatement();

        String query;
        query = "SELECT nro_conta,saldo FROM contas";

        ResultSet resultados = st.executeQuery(query);

        System.out.println("Dados das contas:");
        while (resultados.next()) {
            System.out.println("Número: " + resultados.getLong(1) + " - ");
            System.out.println("Saldo: R$ " + resultados.getBigDecimal("saldo"));
        }
        conexao.close();
    }
}
