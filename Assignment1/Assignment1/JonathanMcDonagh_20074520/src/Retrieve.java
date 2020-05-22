/* 
 * Jonathan McDonagh
 * 20074520
 * Distributed Systems
 * Assignment 1: JDBC MYSQL
 * 
 **/

// Imports
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;
import java.sql.PreparedStatement;
import javax.swing.border.Border;

@SuppressWarnings("unused")
public class Retrieve {
	
	// Declaring Variables
	public static ResultSet rs;
	public static String  ppsn="", fname="", lname="", email ="", dob="", address="", gender="", salary="";
	public static JButton b1, b2, b3, b4, b5, b6;
	public static Connection con = null;
	  
	// The name of the MySQL account to use
	public String userName = "root";

    // The password for the MySQL account
	public String password = "";

	// The name of the computer running MySQL
	public String serverName = "localhost";

    // The port of the MySQL server (default is 3306)
	public int portNumber = 3306;

    // The name of the database we are testing with (this default is installed with MySQL)
	public final String dbName = "test_create_db";
		
    // The name of the table we are testing with
	public final static String tableName = "data";
		
	// Gets connection
	public Connection getConnection() throws SQLException {
			Properties connectionProps = new Properties();
			connectionProps.put("user", this.userName);
			connectionProps.put("password", this.password);

			con = DriverManager.getConnection("jdbc:mysql://"
					+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
					connectionProps);
			return con;
	}
	
	public static void main(String[] args) {
		// Connects to mySQL
		Retrieve app = new Retrieve();
		app.run();
		
		JFrame f = new JFrame();
	    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	    
	    // Labels
		JLabel label1 = new JLabel("PPSN: ");
		JLabel label2 = new JLabel("First Name: ");
		JLabel label3 = new JLabel("Last Name: ");
		JLabel label4 = new JLabel("Email: ");
		JLabel label5 = new JLabel("DOB (DD/MM/YY): ");
		JLabel label6 = new JLabel("Address: ");
		JLabel label7 = new JLabel("Gender");
		JLabel label8 = new JLabel("Salary (€)");

		// Text boxes
		JTextField ppsnText = new JTextField(20);
		JTextField fnameText = new JTextField(20);
		JTextField lnameText = new JTextField(20);
		JTextField emailText = new JTextField(20);
		JTextField dobText = new JTextField(20);
		JTextField addressText = new JTextField(20);
		JTextField genderText = new JTextField(20);
		JTextField salaryText = new JTextField(20);

		JLabel SuccessLabel = new JLabel("");
		JLabel FailureLabel = new JLabel("");
		
		// Buttons
	    b1 = new JButton("NEXT");
	    b2 = new JButton("PREVIOUS");
	    b3 = new JButton("ADD");   
	    b4 = new JButton("DELETE");   
	    b5 = new JButton("UPDATE");  
	    b6 = new JButton("CLEAR");   
	    
		try {
			// Gets the data from the database
			Statement st=con.createStatement();
			rs=st.executeQuery("select * from "+ tableName);
			if(rs.next()) {
				ppsn = rs.getString("ppsn");
				fname = rs.getString("fname");
				lname = rs.getString("lname");
				email = rs.getString("email");
				dob = rs.getString("dob");
				address = rs.getString("address");
				gender = rs.getString("gender");
				salary = rs.getString("salary");
				ppsnText.setText(ppsn);
				fnameText.setText(fname);
				lnameText.setText(lname);
				emailText.setText(email);
				dobText.setText(dob);
				addressText.setText(address);
				genderText.setText(gender);
				salaryText.setText(salary);
			}
		} catch(Exception e){ }
		
		JPanel p = new JPanel(new GridLayout(12, 2));
		p.add(label1);
		p.add(ppsnText);
		p.add(label2);
		p.add(fnameText);
		p.add(label3);
		p.add(lnameText);
		p.add(label4);
		p.add(emailText);
		p.add(label5);
		p.add(dobText);
		p.add(label6);
		p.add(addressText);
		p.add(label7);
		p.add(genderText);
		p.add(label8);
		p.add(salaryText);
		p.add(SuccessLabel);
		p.add(FailureLabel);
		
	    // Action Listener for when the NEXT button is clicked
	    p.add(b1);
	    b1.addActionListener(new ActionListener() {  
	    	@Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	            	// Gets the data that is next in the database
					if(rs.next()){
					  ppsn = rs.getString("ppsn");
					  fname = rs.getString("fname");
					  lname = rs.getString("lname");
					  email = rs.getString("email");
					  dob = rs.getString("dob");
					  address = rs.getString("address");
					  gender = rs.getString("gender");
					  salary = rs.getString("salary");

					  ppsnText.setText(ppsn);
					  fnameText.setText(fname);
					  lnameText.setText(lname);
					  emailText.setText(email);
					  dobText.setText(dob);
					  addressText.setText(address);
					  genderText.setText(gender);
					  salaryText.setText(salary);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	      });
	    
	     // Action Listener for when the PREVIOUS button is clicked
	     p.add(b2);
	     b2.addActionListener(new ActionListener() {    
	        @Override
	        public void actionPerformed(ActionEvent e) {
	          // TODO Auto-generated method stub
	          try {
	            // Gets the data that is previous in the database allowing the user to go back once they press next
	            if(rs.previous()){
					  ppsn = rs.getString("ppsn");
					  fname = rs.getString("fname");
					  lname = rs.getString("lname");
					  email = rs.getString("email");
					  dob = rs.getString("dob");
					  address = rs.getString("address");
					  gender = rs.getString("gender");
					  salary = rs.getString("salary");

					  ppsnText.setText(ppsn);
					  fnameText.setText(fname);
					  lnameText.setText(lname);
					  emailText.setText(email);
					  dobText.setText(dob);
					  addressText.setText(address);
					  genderText.setText(gender);
					  salaryText.setText(salary);
	            }
	          } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	          }
	        }
	      });
	      
	     // Action Listener for when the ADD button is clicked
	     p.add(b3);
	     b3.addActionListener(new ActionListener() {
	       @Override
	       public void actionPerformed(ActionEvent e) {
	         try {	           
		       Statement s = con.createStatement ();
	           // Correct DOB format that the user must enter
	           if (dobText.getText().matches("^\\d{2}/\\d{2}/\\d{2}$")) {
	           // Adds the data that the user enters in the text boxes to the database
	           s.executeUpdate (
	               "INSERT INTO data (ppsn, fname, lname, email, dob, address, gender, salary) "
	               + "VALUES" +
                   "(" + 
                   "'" + ppsnText.getText() + "'," +
	               "'" + fnameText.getText() + "'," +
                   "'" + lnameText.getText() + "'," +
                   "'" + emailText.getText() + "'," +
                   "'" + dobText.getText() + "'," +
                   "'" + addressText.getText() + "'," +
                   "'" + genderText.getText() + "'," +
                   "'" + salaryText.getText() + "');");
	           	   SuccessLabel.setText("Successfully added employee");	
	           	   ppsnText.setText("");
	           	   fnameText.setText("");
	           	   lnameText.setText("");
	           	   emailText.setText("");
	           	   dobText.setText("");
	           	   addressText.setText("");
	           	   genderText.setText("");
	           	   salaryText.setText("");
				} else {
					//If DOB is in the incorrect format
					JOptionPane.showMessageDialog( null, "All boxes must be filled and Date of birth has to be in the correct format i.e. DD/MM/YY");
					SuccessLabel.setText("Could not add employee");
				}
           	    // Retrieves all the data including the most recently added	
	            rs=s.executeQuery("select * from "+ tableName);
	         	}
	         	catch (SQLException e1) {
	             // TODO Auto-generated catch block
	             e1.printStackTrace();
	           }
	       }
	     });
	      
	      //Action Listener for when the DELETE button is clicked
	      p.add(b4);
	      b4.addActionListener(new ActionListener() {    
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        		// Delete query based on ppsn
		            String deleteQuery = "delete from data where ppsn=?";
				    
		            try (
		            	// Removes the employee from the database based on the ppsn	
		            	PreparedStatement ps = con.prepareStatement(deleteQuery)) {  
		            	ps.setString(1, ppsn);
		            	ps.executeUpdate();
		            	
			           	   SuccessLabel.setText("Successfully deleted employee");	
			           	   ppsnText.setText("");
			           	   fnameText.setText("");
			           	   lnameText.setText("");
			           	   emailText.setText("");
			           	   dobText.setText("");
			           	   addressText.setText("");
			           	   genderText.setText("");
			           	   salaryText.setText("");
		            }	  	
		            catch (SQLException e1) {
		                  e1.printStackTrace();
			           	  SuccessLabel.setText("Could not delete employee");
		            }
	        }
	      });
	      
	      // Action Listener for when the UPDATE button is clicked
	      p.add(b5);
	      b5.addActionListener(new ActionListener() {    
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            try {
	     		Statement s = con.createStatement ();

		        // Updates the employees details based on the ppsn
	        	String updateQuery = "UPDATE data "
	                    + "SET fname = ?, lname = ?, email = ?, dob = ?, address = ?, gender = ?, salary = ?"
	                    + "WHERE ppsn = ?";	       
	        	
		        // Correct DOB format that the user must enter
            	if (dobText.getText().matches("^\\d{2}/\\d{2}/\\d{2}$")) {

	            	PreparedStatement ps = con.prepareStatement(updateQuery);
	 	           
	            	ps.setString(1, fnameText.getText());
	            	ps.setString(2, lnameText.getText());
	            	ps.setString(3, emailText.getText());
	            	ps.setString(4, dobText.getText());
	            	ps.setString(5, addressText.getText());
	            	ps.setString(6, genderText.getText());
	            	ps.setString(7, salaryText.getText());
	            	ps.setString(8, ppsnText.getText());

	            	ps.executeUpdate();
	            	
		           	SuccessLabel.setText("Successfully updated employee");	
		           	fnameText.getText();
		           	lnameText.getText();
		           	emailText.getText();
		           	dobText.getText();
		           	addressText.getText();
		           	genderText.getText();
		           	salaryText.getText();
		           	ppsnText.getText();
				} else {
					//If DOB is in the incorrect format
					JOptionPane.showMessageDialog( null, "All boxes must be filled and Date of birth has to be in the correct format i.e. DD/MM/YY");
					SuccessLabel.setText("Could not add employee");
				}
		        rs=s.executeQuery("select * from "+ tableName);
	         	}
	         	catch (SQLException e1) {
	         		e1.printStackTrace();
	           }
	       }
	     });
	      
	      // Action Listener for when the CLEAR button is clicked
	      p.add(b6);
	      b6.addActionListener(new ActionListener() {    
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	           	   ppsnText.setText("");
	           	   fnameText.setText("");
	           	   lnameText.setText("");
	           	   emailText.setText("");
	           	   dobText.setText("");
	           	   addressText.setText("");
	           	   genderText.setText("");
	           	   salaryText.setText("");
		        }
	      });
	      f.add(p);
	      f.setVisible(true);
	      f.pack();
	}
	
	
	public void run() {
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	}
}
