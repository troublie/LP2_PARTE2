/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juliano.lopes
 */
public class ConexaoJavaDb implements ConexaoInterface {

    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String nomeBancoDados;
    private Connection conexao;

    public ConexaoJavaDb(String usuario, String senha, String hostname,
            int porta, String nomeBancoDados) {
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.nomeBancoDados = nomeBancoDados;
    }

    @Override
    public Connection getConnection() {
        if (conexao == null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + nomeBancoDados;
                conexao = DriverManager.getConnection(url, senha, usuario);
            } catch (Exception ex) {
            }

        }
        return conexao;
    }

    @Override
    public void close() {
        try {
            conexao.close();
        } catch (SQLException ex) {
        }
        conexao = null;
    }
}
