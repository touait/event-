/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiPublicite;

import UtilData.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import GestionPublicite.Publicite;
import java.awt.Image;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class AddPubliciteController implements Initializable {

     @FXML
    private TextField descriFld;

    @FXML
    private TextField imgFld;

    @FXML
    private TextField typeFld;
    
    String query = null;
    Connection cnx = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Publicite publicite = null;
    private boolean update;
    int publiciteID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    
    @FXML
    void choose(ActionEvent event) {
       JFileChooser chooser=new JFileChooser();
chooser.showOpenDialog(null);
File f = chooser.getSelectedFile();
String fileName=f.getAbsolutePath();
imgFld.setText(fileName);
Image getAbsolutePath=null;
ImageIcon icon=new ImageIcon(fileName);

}

    
    
    
    
    
    
    @FXML
    private void save(MouseEvent event) {

      cnx = DataSource.getInstance().getConnection();
        String name = typeFld.getText();
        String adress = descriFld.getText();
        String email = imgFld.getText();

        if (name.isEmpty() || adress.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            clean();

        }
 JOptionPane.showMessageDialog(null, "ADD scusseful");
    }

    @FXML
    private void clean() {
        typeFld.setText(null);
        descriFld.setText(null);
        imgFld.setText(null);
        
    }

    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `publicite`( `type`,`description`, `image`) VALUES (?,?,?)";

        }else{
            query = "UPDATE `publicite` SET "
                    + "`type`=?,"
                    + "`description`=?,"
                    + "`image`= ? WHERE id = '"+publiciteID+"'";
        }

    }

    private void insert() {

        try {

            preparedStatement = cnx.prepareStatement(query);
            preparedStatement.setString(1, typeFld.getText());
            preparedStatement.setString(2, descriFld.getText());
            preparedStatement.setString(3, imgFld.getText());
            preparedStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddPubliciteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setTextField(int id, String type,String description, String image) {

        publiciteID = id;
        typeFld.setText(type);
        descriFld.setText(description);
        imgFld.setText(image);

    }

    void setUpdate(boolean b) {
        this.update = b;

    }

}
