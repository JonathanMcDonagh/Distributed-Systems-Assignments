/* 
 * Jonathan McDonagh
 * 20074520
 * Distributed Systems
 * Assignment 2: Multi-threaded Client Server App
 * 
 **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Client extends JFrame {
	
	// Text fields for receiving 
	private JTextField jtf = new JTextField();
	private JTextArea jta = new JTextArea(); 
	private JTextField studentNumber = new JTextField(8);
	  
	// Buttons
	private JButton loginBtn = new JButton("Login");
	private JButton exit =new JButton("Exit");
	private JButton send =new JButton("Send");
	
	// Panels  
	private JPanel p = new JPanel();
	private JPanel p2 = new JPanel();
	    
	// Labels  
	private JLabel labelStudentNumber = new JLabel("Please enter your student number below: ");
	private JLabel areaOfCircle = new JLabel("Enter radius:");
	private final JLabel lblNewLabel2 = new JLabel("Multithreaded Client/Server - User Authentication");

	// IO streams
	private DataOutputStream toServer;
	private DataInputStream fromServer;

	public static void main(String[] args) {
		new Client();
	}
    

    public Client(){
    	//User login screen using Student ID
    	setTitle("Client");
        setSize(525, 192);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // It is necessary to show the frame here!
        
        p.setLayout (null);
        labelStudentNumber.setHorizontalAlignment(SwingConstants.CENTER);
        labelStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
        labelStudentNumber.setBounds(0,36,511,20);
        studentNumber.setHorizontalAlignment(SwingConstants.CENTER);
        studentNumber.setBounds(161,67,194,20);
        loginBtn.setBounds(161,98,194,20);
        p.add(studentNumber);
        p.add(labelStudentNumber);
        p.add(loginBtn);
        getContentPane().add(p);
        
        JLabel lblNewLabel = new JLabel("Multithreaded Client/Server \u2013 User Authentication");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(0, 11, 511, 14);
        p.add(lblNewLabel);
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
              System.exit(0);
            }
         });
        
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
          }
          catch (IOException ex) {
            jta.append(ex.toString() + '\n');
          }
        login();
    }

    public void login(){
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            	// Get student number from the text field 
                int studentNo = Integer.parseInt(studentNumber.getText());
                
                try {
                    toServer.writeInt(studentNo);

                    int STUD_ID = fromServer.readInt();
                          
                    // Checks to see if StudentNo matches STUD_ID
                    if(studentNo == STUD_ID) {
                        
                    	// removes the login panel
                        getContentPane().remove(p);
                        
                        // new panel for calculating the radius
                        setTitle("Area of Circle");
                        p2.setLayout (null);
                        setLocation(1000,280);
                        setSize(567,392);
                        JScrollPane sp = new JScrollPane(jta);
                        areaOfCircle.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        
                        lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
                        lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
                        lblNewLabel2.setBounds(0, 21, 553, 14);
                        areaOfCircle.setBounds(170,57,200,20);
                        jtf.setBounds(170,88,200,20);
                        exit.setBounds(170,309,200,20);
                        send.setBounds(170,119,200,20);
                        sp.setBounds(80,150,400,150);
                        p2.add(lblNewLabel2);
                        p2.add(jtf);
                        p2.add(areaOfCircle);
                        p2.add(exit);
                        p2.add(send);
                        p2.add(sp);

                        getContentPane().add(p2);

                        String FULLNAME = fromServer.readUTF();
                        jta.append("Processing..... \n");
                        jta.append("Welcome " + FULLNAME + "... You are now connected to the Server"+'\n');
                        jta.append("Please enter the Radius of the Circle."+'\n');
                        send.addActionListener(new Client.Listener());
                    } 
                    else {
                        JOptionPane.showMessageDialog(null,"Sorry the Student Number entered is not registered");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  
        });
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the radius from the text field
                double radius = Double.parseDouble(jtf.getText().trim());
                
                // Send the radius to the server
                toServer.writeDouble(radius);
                toServer.flush();
                    
                // Get area from the server
                String area = fromServer.readUTF().trim();

                // Display to the text area
                jta.append("Radius: " + radius + "\n");
                jta.append("Area: " + area + '\n');
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
