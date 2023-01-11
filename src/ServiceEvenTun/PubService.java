/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEvenTun;

import GestionPublicite.Publicite;
import UtilData.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PubService implements service<Publicite> {

    private final Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PubService() {
        cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Publicite p) {

        try {

            String requete = "insert into Publicite (type,description,image) values(?,?,?)";
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getType());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getImage());
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

    @Override
    public void delete(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Publicite readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Publicite> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
