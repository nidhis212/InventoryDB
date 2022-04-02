/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventoryjava;
import java.sql.*;
/**
 *
 * @author nidhi
 */
public class DBTrigger {
    public static void main(String args[]){
     
        
}
    public static void logname (String Uphone, String oldname, String newname)
                                                        throws SQLException{
        String url="jdbc:mysql://localhost:3306/Inventorydb?useSSL=true";
        String user="root";
        String pass="nid123";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(url,user,pass);
            //System.out.println("Driver load successful");
            PreparedStatement add = Con.prepareStatement("insert into USERTBL values(?,?,?)");
            add.setString(1, Uphone);
            add.setString(2, oldname);
            add.setString(3,newname);
            add.executeUpdate(); 
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
