/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ATHISH
 */import javax.swing.*;
import java.sql.*;
public class jdbc {
 private Connection con =null;
     private Statement st=null;
     private ResultSet rs=null;
     private int n=0;
     private int x=0;
     private String query=null;

    public void conn(String v, String c){
        try{
        Class.forName("java.sql.DriverManager");
         con=DriverManager.getConnection("jdbc:mysql://localhost/musicx","root","athish");
         st=con.createStatement();
        rs=st.executeQuery(v);
        if(rs.next()){
            query=rs.getString(c);
        }
        else if(rs.next()==false){
            query="a";
        }

        rs.close();
        st.close();
        con.close();
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
        public String getQuery(){
            return query;
        }





     public void mod(String v){
         try{
         Class.forName("java.sql.DriverManager");
         con=DriverManager.getConnection("jdbc:mysql://localhost/musicx","root","athish");
         st=con.createStatement();
         n=st.executeUpdate(v);
         if(n>0)
             x=1;
         st.close();
         con.close();
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
     }
     public int getmod(){
         return x;
     }

}
