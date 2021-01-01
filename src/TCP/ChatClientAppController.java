package TCP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import DB.Connector;

public class ChatClientAppController extends JFrame{
   
	public ChatClientAppController() {
	       
	    }
    /**
     * 메인 함수
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
//    	Connector con = new Connector();
//    	String str = con.getDatas("SELECT * FROM couple_bus.user;");
//    	
//    	System.out.println(str);
    	new ChatClient();
    }

}



