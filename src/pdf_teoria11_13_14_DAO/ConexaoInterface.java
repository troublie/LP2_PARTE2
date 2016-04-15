/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf_teoria11_13_14_DAO;

import java.sql.Connection;

/**
 *
 * @author juliano.lopes
 */
public interface ConexaoInterface {

    Connection getConnection();

    void close();
}
