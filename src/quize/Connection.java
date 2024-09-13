package quize;




import java.sql.*;  

public class Connection{
    Connection c;
    Statement s;
    public Connection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =(Connection) DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","aswathi");    
            s =((java.sql.Connection) c).createStatement(); 



        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
