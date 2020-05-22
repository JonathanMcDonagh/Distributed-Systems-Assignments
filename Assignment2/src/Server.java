/* 
 * Jonathan McDonagh
 * 20074520
 * Distributed Systems
 * Assignment 2: Multi-threaded Client Server App
 * 
 **/

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Server extends JFrame {

		// Text area for displaying contents
	 	private JTextArea jta = new JTextArea();
        private ResultSet rs;
        
    	public static Connection con = null;
    	
        public static void main(String[] args) {
        	 new Server();
        }

        public Server() {
            setLayout(new BorderLayout());
            add(new JScrollPane(jta), BorderLayout.CENTER);
            setTitle("Server");
            setSize(500, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true); // It is necessary to show the frame here!
            
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                
                // Create a database connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign2","root","");
                Statement st = con.createStatement();
                
                jta.append("Server started at " + new Date() + '\n');
                
                while (true) {        
                    rs = st.executeQuery("select * from students");
                    rs.next();
                    
                    Socket s1 = serverSocket.accept();
                    myClient c = new myClient(s1);
                    c.start();
                }
            }
            catch(IOException | SQLException ex) {
                System.err.println(ex);
            }
        } // End Server Construct


        private class myClient extends Thread{
        	//The socket the client is connected through
        	private Socket mysocket;
        	//The ip address of the client
        	private InetAddress address;
        	//The input and output streams to the client
        	private DataInputStream inputFromClient;
        	private DataOutputStream outputToClient;
        	
            private String FNAME, SNAME;
            private int STUD_ID, studentNo = 0;
            
            private Boolean user = false;
            private int student = 0;

            public myClient(Socket socket) throws IOException, SQLException {
                mysocket = socket;
            	
            	// Declare & Initialise input/output streams
                inputFromClient = new DataInputStream(socket.getInputStream());
                outputToClient = new DataOutputStream(socket.getOutputStream());
            }

            public void checkUsers() throws IOException, SQLException {            	
            	studentNo = inputFromClient.readInt();

            	user = true;
                outputToClient.writeInt(studentNo);
                student = studentNo;

                //Gets the first name that matches the STUD_ID the user entered
                Statement st2 = con.createStatement();
                rs = st2.executeQuery("select SID, FNAME, SNAME from students where STUD_ID = '"+ student +"'");
                rs.next();
                            
                FNAME = rs.getString("FNAME");
                SNAME = rs.getString("SNAME");
                rs.close();
                            
                String FULLNAME = FNAME +" "+ SNAME;
                System.out.println("Processing ......");
                outputToClient.writeUTF(FULLNAME);
            }
            
            
            public void run() {
                    try {
                        while (true) {
                            if (user != true) {
                                checkUsers();
                            } else if (user = true){
                                // Receive radius from the client
                                double radius = inputFromClient.readDouble();
                                
                                // Compute area
                                double area = radius * radius * Math.PI;      
                                
                                // Change the double to string so it can be printed
                                String areaString = String.valueOf(area);
                                
                                // Send calculated value to client
                                outputToClient.writeUTF(areaString);
                                
                                jta.append("Radius received from client: " + radius + '\n');
                                jta.append("Area found: " + area + '\n');
                            }
                        }
                    } catch(IOException | SQLException ex) {
                        System.err.println(ex);
                    }
                }

        }
}


