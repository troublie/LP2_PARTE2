/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.util.List;

/**
 *
 * @author juliano.lopes
 */
public interface ContaDaoInterface {

    public List<Conta> listarTudo();

    public void salvarNova(Conta conta);

    public Conta buscar(long nroConta);
}
