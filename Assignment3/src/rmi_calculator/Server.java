/** 
 * Jonathan McDonagh
 * 20074520
 * Distributed Systems
 * Assignment 3: Remote Method Invocation
 * 
 **/

// Package
package rmi_calculator;

// Imports
import java.rmi.*;
import java.awt.*;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import java.rmi.registry.*;


public class Server extends UnicastRemoteObject implements Interface {

	public JFrame serverFrame;

	public TextArea serverTextArea;

	public Server() throws RemoteException {
		// JFrame for the GUI
		serverFrame = new JFrame("RMI Server GUI");
		serverFrame.setSize(450, 450);
		serverFrame.setVisible(true);
		
		// TextArea for the GUI
		serverTextArea = new TextArea();
	
		// Font and bounds for TextArea
		serverTextArea.setFont(new Font("Verdana", Font.PLAIN, 18));
		serverTextArea.setBounds(50, 200, 200, 100);
		
		// Add the text area to the window
		serverFrame.add(serverTextArea);

		// Message when server starts
		serverTextArea.append("Server Starting...\n");
		serverTextArea.append("Waiting for client to proceed\n\n");

	}

	// Addition method
	public int add(int num1, int num2) {
		int result = (num1 + num2);
		
		try {
			// Gets the IP address from the users machine
			serverTextArea.append("Client - connected at IP: \n" + InetAddress.getLocalHost().getHostAddress() + "\n");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Server Output
		serverTextArea.append("Request from Client: \n");
		serverTextArea.append("Opnd1: " + num1 + "\n");
		serverTextArea.append("Opnd2: " + num2 + "\n");
		serverTextArea.append("Oprtr: +" + "\n");
		serverTextArea.append("Data to Client:  " + result + "\n\n");
		return result;
	}
	

	// subtraction method
	public int sub(int num1, int num2) {
		int result = (num1 - num2);
		
		try {
			// Gets the IP address from the users machine
			serverTextArea.append("Client - connected at IP: \n" + InetAddress.getLocalHost().getHostAddress() + "\n");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Server Output
		serverTextArea.append("Request from Client: \n");
		serverTextArea.append("Opnd1: " + num1 + "\n");
		serverTextArea.append("Opnd2: " + num2 + "\n");
		serverTextArea.append("Oprtr: -" + "\n");
		serverTextArea.append("Data to Client:  " + result + "\n\n");
		return result;
	}
	

	// Multiplication method
	public int mult(int num1, int num2) {
		int result = (num1 * num2);
		
		try {
			// Gets the IP address from the users machine
			serverTextArea.append("Client - connected at IP: \n" + InetAddress.getLocalHost().getHostAddress() + "\n");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Server Output
		serverTextArea.append("Request from Client: \n");
		serverTextArea.append("Opnd1: " + num1 + "\n");
		serverTextArea.append("Opnd2: " + num2 + "\n");
		serverTextArea.append("Oprtr: *" + "\n");
		serverTextArea.append("Data to Client:  " + result + "\n\n");
		return result;
	}
	

	// Division method
	public int div(int num1, int num2) {
		int result = (num1 / num2);
		
		try {
			// Gets the IP address from the users machine
			serverTextArea.append("Client - connected at IP: \n" + InetAddress.getLocalHost().getHostAddress() + "\n");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Server Output
		serverTextArea.append("Request from Client: \n");
		serverTextArea.append("Opnd1: " + num1 + "\n");
		serverTextArea.append("Opnd2: " + num2 + "\n");
		serverTextArea.append("Oprtr: /" + "\n");
		serverTextArea.append("Data to Client:  " + result + "\n\n");
		return result;
	}

	
	public static void main(String args[]) throws RemoteException {
			Server CalculatorServer = new Server();
			// Include the following line if rmiregistry was not started on the command line
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CalculatorServer", CalculatorServer);
			System.out.println("RMI Calculator Server Ready");
	}

}