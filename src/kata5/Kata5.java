package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Kata5 {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        addRegisters();
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
    
    public static void addRegisters() throws SQLException, FileNotFoundException{        
        try{
            Connection con = connection();
            Statement stat = con.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader(new File("email.txt")));
            System.out.println(stat.executeQuery("select count(*) from EMAIL").getInt(1));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
