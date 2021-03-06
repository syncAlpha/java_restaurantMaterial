package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a_lpha
 */
public class TipeMeja {

    public int id;
    public String namaTipe;

    public TipeMeja() {
    }

    public TipeMeja get(Connection connection, int id) {
        String sql = "SELECT * FROM tipe_meja WHERE id='" + id + "'";

        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(sql)) {

            TipeMeja tipeMeja = new TipeMeja();
            while (resultSet.next()) {
                tipeMeja.id = resultSet.getInt("id");
                tipeMeja.namaTipe = resultSet.getString("nama_tipe");
            }
            resultSet.close();
            statement.close();

            return tipeMeja;
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
