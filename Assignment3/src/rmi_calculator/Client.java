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
import java.awt.*;
import java.awt.event.*;

import java.rmi.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class Client extends JFrame implements Interface {

  // Declaring private variables
  private JLabel labelTitle;
  private JScrollPane scroll;
  private JPanel clientPane;
  private JTextField resultField;
  private JTextArea outputConsole;  
  

  // Client Calling componentSetup and buttonSetup
  public Client() {
  	setResizable(false); componentSetup(); buttonSetup(); }
  

  // Setting up layout
  private void componentSetup() {

    // JPanel
    clientPane = new JPanel();
    setContentPane(clientPane);
    clientPane.setLayout(null);

    // Title Label
    labelTitle = new JLabel("Calculator - RMI");
    labelTitle.setFont(new Font("Verdana", Font.PLAIN, 16));
    labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    labelTitle.setBounds(30, 9, 340, 20);
    // Adding label to panel
    clientPane.add(labelTitle);

    // JTextField
    resultField = new JTextField();
    resultField.setFont(new Font("Verdana", Font.PLAIN, 14));
    resultField.setHorizontalAlignment(SwingConstants.LEFT);
    resultField.setBounds(30, 40, 340, 81);
    resultField.setEditable(false);
    // Adding text field to panel
    clientPane.add(resultField);

    // instantiate the console text area
    outputConsole = new JTextArea();
    outputConsole.setEditable(false);
    outputConsole.setFont(new Font("Verdana", Font.PLAIN, 15));

    // set a border to the console area
    outputConsole.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));

    // set the columns size
    outputConsole.setColumns(15);

    // JScrollPane
    scroll = new JScrollPane(outputConsole);
    scroll.setBounds(30, 580, 339, 98);
    clientPane.add(scroll);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  }

  // Adding Method
  public int add(int num1, int num2) {

    int result = 0;

    try {
      String ServerURL = "CalculatorServer";
      Interface CI = (Interface) Naming.lookup(ServerURL);
      result = CI.add(num1, num2);      
    } catch (Exception ex) {
      System.out.println("Exception:" + ex);
    }
    
    return result;
  }

  // sub Method
  public int sub(int num1, int num2) {

	  int result = 0;

	  try {
	    String ServerURL = "CalculatorServer";
	    Interface CI = (Interface) Naming.lookup(ServerURL);
	    result = CI.sub(num1, num2);      
	  } catch (Exception ex) {
	    System.out.println("Exception:" + ex);
	  }  
	    return result;
  }

  // Multiplication Method
  public int mult(int num1, int num2) {

	  int result = 0;

	  try {
	    String ServerURL = "CalculatorServer";
	    Interface CI = (Interface) Naming.lookup(ServerURL);
	    result = CI.mult(num1, num2);      
	  } catch (Exception ex) {
	    System.out.println("Exception:" + ex);
	  }  
	    return result;
  }

  // Division method
  public int div(int num1, int num2) {

	  int result = 0;

	  try {
	    String ServerURL = "CalculatorServer";
	    Interface CI = (Interface) Naming.lookup(ServerURL);
	    result = CI.div(num1, num2);      
	  } catch (Exception ex) {
	    System.out.println("Exception:" + ex);
	  }  
	    return result;
  }

  
  // Setting up buttons
  private void buttonSetup() {

    // Button for number 0 on calculator
    JButton btn0 = new JButton("0");
    btn0.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 0
    btn0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return0 = resultField.getText();
        return0 = return0 + "0";
        resultField.setText(return0);
      }
    });
    btn0.setBounds(115, 400, 80, 80);
    clientPane.add(btn0);

    // Button for number 1 on calculator
    JButton btn1 = new JButton("1");
    btn1.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 1
    btn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return1 = resultField.getText();
        return1 = return1 + "1";
        resultField.setText(return1);
      }
    });
    btn1.setBounds(115, 310, 80, 80);
    clientPane.add(btn1);

    // Button for number 2 on calculator
    JButton btn2 = new JButton("2");
    btn2.setFont(new Font("Verdana", Font.PLAIN, 18));
    btn2.addActionListener(new ActionListener() {
      // Action Listener for the button 2
      public void actionPerformed(ActionEvent e) {
        String return2 = resultField.getText();
        return2 = return2 + "2";
        resultField.setText(return2);
      }
    });
    btn2.setBounds(200, 310, 80, 80);
    clientPane.add(btn2);

    // Button for number 3 on calculator
    JButton btn3 = new JButton("3");
    btn3.setFont(new Font("Verdana", Font.PLAIN, 18));
    btn3.addActionListener(new ActionListener() {
      // Action Listener for the button 3
      public void actionPerformed(ActionEvent e) {
        String return3 = resultField.getText();
        return3 = return3 + "3";
        resultField.setText(return3);
      }
    });
    btn3.setBounds(290, 310, 80, 80);
    clientPane.add(btn3);

    // Button for number 4 on calculator
    JButton btn4 = new JButton("4");
    btn4.setFont(new Font("Verdana", Font.PLAIN, 18));
    btn4.addActionListener(new ActionListener() {
      // Action Listener for the button 4
      public void actionPerformed(ActionEvent e) {
        String return4 = resultField.getText();
        return4 = return4 + "4";
        resultField.setText(return4);
      }
    });
    btn4.setBounds(116, 220, 80, 80);
    clientPane.add(btn4);

    // Button for number 5 on calculator
    JButton btn5 = new JButton("5");
    btn5.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 5
    btn5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return5 = resultField.getText();
        return5 = return5 + "5";
        resultField.setText(return5);
      }
    });
    btn5.setBounds(203, 220, 80, 80);
    clientPane.add(btn5);

    // Button for number 6 on calculator
    JButton btn6 = new JButton("6");
    btn6.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 6
    btn6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return6 = resultField.getText();
        return6 = return6 + "6";
        resultField.setText(return6);
      }
    });
    btn6.setBounds(290, 220, 80, 80);
    clientPane.add(btn6);

    // Button for number 7 on calculator
    JButton btn7 = new JButton("7");
    btn7.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 7
    btn7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return7 = resultField.getText();
        return7 = return7 + "7";
        resultField.setText(return7);
      }
    });
    btn7.setBounds(116, 130, 80, 80);
    clientPane.add(btn7);

    // Button for number 8 on calculator
    JButton btn8 = new JButton("8");
    btn8.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 8
    btn8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return8 = resultField.getText();
        return8 = return8 + "8";
        resultField.setText(return8);
      }
    });
    btn8.setBounds(203, 130, 80, 80);
    clientPane.add(btn8);

    // Button for number 9 on calculator
    JButton btn9 = new JButton("9");
    btn9.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the button 9
    btn9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String return9 = resultField.getText();
        return9 = return9 + "9";
        resultField.setText(return9);
      }
    });
    btn9.setBounds(290, 130, 80, 80);
    clientPane.add(btn9);

    // Button for add on calculator
    JButton btnAdd = new JButton("+");
    btnAdd.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the add button
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String addResult = resultField.getText();
        addResult = addResult + "+";
        resultField.setText(addResult);
      }
    });
    btnAdd.setBounds(29, 400, 80, 80);
    clientPane.add(btnAdd);

    // Button for minus on calculator
    JButton btnMinus = new JButton("-");
    btnMinus.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the minus button
    btnMinus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String minusResult = resultField.getText();
        minusResult = minusResult + "-";
        resultField.setText(minusResult);
      }
    });
    btnMinus.setBounds(29, 310, 80, 80);
    clientPane.add(btnMinus);

    // Button for multiply calculator
    JButton btnMultiply = new JButton("*");
    btnMultiply.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the multiply button
    btnMultiply.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String multiplyResult = resultField.getText();
        multiplyResult = multiplyResult + "*";
        resultField.setText(multiplyResult);
      }
    });
    btnMultiply.setBounds(29, 220, 80, 80);
    clientPane.add(btnMultiply);

    // Button for divide on calculator
    JButton btnDivide = new JButton("/");
    btnDivide.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the divide button
    btnDivide.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String divideResult = resultField.getText();
        divideResult = divideResult + "/";
        resultField.setText(divideResult);
      }
    });
    btnDivide.setBounds(29, 130, 80, 80);
    clientPane.add(btnDivide);

    // Button for clear on calculator
    JButton btnClear = new JButton("Clear");
    btnClear.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the clear button
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String clearResult = resultField.getText();
        clearResult = "";
        resultField.setText(clearResult);
      }
    });
    btnClear.setBounds(30, 491, 166, 80);
    clientPane.add(btnClear);

    // Button for exit on calculator
    JButton btnExit = new JButton("Exit");
    btnExit.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the exit button
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
    btnExit.setBounds(203, 491, 166, 78);
    clientPane.add(btnExit);

    // Button for submit on calculator
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBackground(Color.WHITE);
    btnSubmit.setFont(new Font("Verdana", Font.PLAIN, 18));
    // Action Listener for the submit button
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String ans = resultField.getText();
        // Loop the ans string
        for (int i = 0; i < ans.length(); i++) {
          char operator = ans.charAt(i);
          // If the operator is add do this
          if (operator == '+') {
        	// Gets first number entered by user  
            int num1 = Integer.parseInt(ans.substring(0, i));
        	// Gets second number entered by user  
            int num2 = Integer.parseInt(ans.substring(i + 1, ans.length()));
            int result = add(num1, num2);
            // Output to the console
            outputConsole.append("Data received from server\n");
            outputConsole.append("Got " + num1 + " + " + num2 + " from server " + "\n");
            outputConsole.append("Result = " + result + "\n");
            // Sets the resultField to just the value
            resultField.setText("" + result);
          }
          // If the operator is minus do this
          if (operator == '-') {
          	// Gets first number entered by user  
            int num1 = Integer.parseInt(ans.substring(0, i));
        	// Gets second number entered by user  
            int num2 = Integer.parseInt(ans.substring(i + 1, ans.length()));
            int result = sub(num1, num2);
            // Output to the console
            outputConsole.append("Data received from server\n");
            outputConsole.append("Got " + num1 + " - " + num2 + " from server " + "\n");
            outputConsole.append("Result = " + result + "\n");
            // Sets the resultField to just the value
            resultField.setText("" + result);
          }
          // If the operator is multiply do this
          if (operator == '*') {
          	// Gets first number entered by user  
            int num1 = Integer.parseInt(ans.substring(0, i));
        	// Gets second number entered by user  
            int num2 = Integer.parseInt(ans.substring(i + 1, ans.length()));
            int result = mult(num1, num2);
            // Output to the console
            outputConsole.append("Data received from server\n");
            outputConsole.append("Got " + num1 + " * " + num2 + " from server " + "\n");
            outputConsole.append("Result = " + result + "\n");
            // Sets the resultField to just the value
            resultField.setText("" + result);
          }
          // If the operator is divide do this
          if (operator == '/') {
          	// Gets first number entered by user  
            int num1 = Integer.parseInt(ans.substring(0, i));
        	// Gets second number entered by user  
            int num2 = Integer.parseInt(ans.substring(i + 1, ans.length()));
            int result = 0;
            // Check to see if either number is 0
            if (num1 == 0 || num2 == 0) {
              outputConsole.append("Dividing by 0 does not work\nTry a different calculation");
              resultField.setText("");
            } else {
            	result = div(num1, num2);
              // Output to the console
              outputConsole.append("Data received from server\n");
              outputConsole.append("Got " + num1 + " * " + num2 + " from server " + "\n");
              outputConsole.append("Result = " + result + "\n");
              // Sets the resultField to just the value
              resultField.setText("" + result);
            }
          }

        }
      }
    });
    btnSubmit.setBounds(204, 400, 165, 80);
    clientPane.add(btnSubmit);
  }
  
  public static void main(String args[]) {
  	try {
        // Client
        Client clientInstance = new Client();
        clientInstance.setTitle("Calculator - RMI (Client)");
        clientInstance.setVisible(true);
        clientInstance.setResizable(false);
        clientInstance.setSize(450, 800);
  	}
  	catch (Exception e) {
        e.printStackTrace();

  	}
  }
 }
