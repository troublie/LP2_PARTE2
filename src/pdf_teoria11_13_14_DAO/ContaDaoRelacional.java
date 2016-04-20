/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juliano.lopes
 */
public class ContaDaoRelacional implements ContaDaoInterface {

    private ConexaoInterface conexao;

    public ContaDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Conta> listarTudo() {
        List<Conta> contas;
        contas = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT nro_conta, saldo FROM contas";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                long n = resultados.getLong("nro_conta");
                BigDecimal b = resultados.getBigDecimal("saldo");
                Conta c = new Conta(n, b);
                contas.add(c);
            }
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return contas;
    }

    @Override
    public void salvarNova(Conta conta) {

    }

    @Override
    public Conta buscar(long nroConta) {
        return null;

    }
}
