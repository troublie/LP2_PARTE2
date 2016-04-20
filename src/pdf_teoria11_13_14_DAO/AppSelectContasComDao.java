/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juliano.lopes
 */
public class AppSelectContasComDao {

    public static void main(String[] args) {
        ConexaoInterface conexao = new ConexaoJavaDb("app", "app",
                "127.0.0.1", 1527, "banco");
        Connection teste = conexao.getConnection();
        ContaDaoInterface dao;
        dao = new ContaDaoRelacional(conexao);
        List<Conta> todasContas;
        todasContas = dao.listarTudo();
        for (Conta c : todasContas) {
            System.out.print("Nro: " + c.getNumero());
            System.out.print(" - ");
            System.out.println("Saldo: R$ " + c.getSaldo());
        }
    }
}
