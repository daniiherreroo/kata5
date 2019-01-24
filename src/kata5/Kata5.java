package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Kata5 {

    public static void main(String[] args) throws SQLException {
        selectAll();
    }
    
    private static Connection connection(){
        String url = "jdbc:sqlite:Kata5.db";
        Connection con = null;
        
        try{
            con = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public static void selectAll() throws SQLException{
        String sql = "SELECT * FROM PEOPLE";
        
        try(
            Connection con = connection();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql)){
            
            while (rs.next()){
                System.out.println(rs.getInt("Id") + "\t" +
                                   rs.getString("Name") + "\t" + 
                                   rs.getString("Apellidos") + "\t" +
                                   rs.getString("Departamento") + "\t");
            }
        }
    }
}
