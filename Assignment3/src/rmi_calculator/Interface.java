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
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Interface extends Remote{
	
	// Addition method
	public int add(int num1, int num2) throws RemoteException;
	
	// subtraction method
	public int sub(int num1, int num2) throws RemoteException;
	
	// Multiplication method
	public int mult(int num1, int num2) throws RemoteException;
	
	// Division method
	public int div(int num1, int num2) throws RemoteException;
	
}