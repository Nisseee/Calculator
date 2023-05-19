//importing parent classes needed for the program. 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Stack;
//Creating a Class "Calculator" and implementing the ActionListener interface in the class.
public class Calculator implements ActionListener {

    //declaring variables
    double number, answer;
    int calculation;
    String input = "";
    String temp = "";
    //creating objects for font, label, frame and text field
    JFrame f = new JFrame();
    JTextArea allHistory = new JTextArea();
    JTextField textField = new JTextField();
    JTextPane mField = new JTextPane();
    JTextField hField = new JTextField();
    JScrollPane scroll = new JScrollPane (allHistory);
    JLabel historyL = new JLabel("HISTORY");
    Font myFont0 = new Font("DM Sans", Font.TRUETYPE_FONT, 35);
    Font myFont = new Font("DM Sans", Font.TRUETYPE_FONT, 19);
    Font myFont2 = new Font("DM Sans", Font.BOLD, 13);
    //creating objects for number buttons and function buttons.
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("÷");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonSquare = new JButton("x²");
    JButton bracketR = new JButton(")");
    JButton buttonSqrt = new JButton("√");
    JButton bracketL = new JButton("(");
    JButton buttonUnique =new JButton("Unique");
    JButton buttonEnter = new JButton("Enter");
    JButton bHistory = new JButton("Show");
    JButton cHisButton = new JButton("Clear All History");
    //Making a function "Calculator()" that calls out other functions containing the layout, components and functions of the calculator.
    Calculator() {
        layout();
        components();
        actionEvent();
    }
    //Making function "layout()" which includes the style of the frame where the component is located, being the base of the computer.
    public void layout() {
        f.setTitle("Calculator");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(new Color(27, 27, 27));
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonDiv.setVisible(true);
        buttonEqual.setVisible(true);
        buttonMinus.setVisible(true);
        bracketL.setVisible(true);
        buttonMul.setVisible(true);
        buttonPlus.setVisible(true);
        bracketR.setVisible(true);
        buttonSqrt.setVisible(true);
        buttonSquare.setVisible(true);
        mField.setVisible(false);
        buttonUnique.setText("Unique");
        buttonEnter.setVisible(false);
        textField.setEditable(false);
        textField.setFont(myFont0);
        hField.setVisible(true);
        hField.setText("");
        buttonDelete.setBounds(20,140, 80, 40);
        buttonClear.setBounds(120,140, 80, 40);
        textField.setText("");
    }
    
    public void layout2() {         //layout2 for the unique button to solve Mean, Median, Mode
        f.setTitle("Calculator for Mean, Median, Mode");
        f.getContentPane().setLayout(null);
        f.getContentPane().setBackground(new Color(128, 128, 128));
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonDiv.setVisible(false);
        buttonEqual.setVisible(false);
        buttonMinus.setVisible(false);
        bracketL.setVisible(false);
        buttonMul.setVisible(false);
        buttonPlus.setVisible(false);
        bracketR.setVisible(false);
        buttonSqrt.setVisible(false);
        buttonSquare.setVisible(false);
        mField.setVisible(true);
        buttonUnique.setText("Done");
        buttonEnter.setVisible(true);
        textField.setText("");
        textField.setEditable(true);
        textField.setFont(myFont);
        hField.setVisible(false);
        hField.setText("");
        buttonDelete.setBounds(320,280, 80, 40);
        buttonClear.setBounds(320,350, 80, 40);
        mField.setText("\nMean:  " + "\n\n" + "Median:  " + "\n\n" + "Mode:  ");
    }
    //Adding and Styling Components (Button, Text Field, ect.)
   
    public void components() {
        f.setSize(440, 600);
        
    
        
        //Applying Style and Adding Text Field
        textField.setBounds(20, 27, 380, 95);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.black);
        textField.setFont(myFont0);
        textField.setEditable(false);
        f.add(textField);
        //textfield for M,M,M
        mField.setBounds(20, 120, 380, 130);
        mField.setBackground(new Color(240, 240, 240));
        mField.setForeground(Color.black);
        mField.setFont(myFont2);
        mField.setEditable(false);
        mField.setVisible(false);
        f.add(mField);
        //textfield for string to be evalvuate 
        hField.setBounds(20,5, 380,30);
        hField.setHorizontalAlignment(JTextField.RIGHT);
        hField.setBackground(new Color(224, 224, 224));
        hField.setForeground(Color.black);
        hField.setFont(myFont2);
        hField.setEditable(false);
        hField.setVisible(true);
        f.add(hField);
        //textfield for HISTORY
        allHistory.setBounds(440, 20, 340, 479);
        allHistory.setBackground(Color.WHITE);
        allHistory.setForeground(Color.black);
        allHistory.setLineWrap(true);
        allHistory.setEditable(false);
        allHistory.setVisible(true);
        allHistory.setFont(new Font("DM Sans", Font.PLAIN, 11));
        allHistory.setAutoscrolls(true);
        f.add(allHistory, BorderLayout.CENTER);

        cHisButton.setBounds(440 , 500, 340, 40);
        cHisButton.setFont(myFont2);
        cHisButton.setBackground(new Color(255, 149, 0));
        cHisButton.setForeground(Color.white);
        f.add(cHisButton);

        historyL.setBounds(440, 5, 340, 15);
        historyL.setForeground(Color.white);
        historyL.setFont(new Font("DM Sans", Font.BOLD, 15));
        f.add(historyL);
        //1ST ROW
        //Applying Style and Adding Delete Button 
        buttonDelete.setBounds(20, 140, 80,40);
        buttonDelete.setFont(myFont2);
        buttonDelete.setBackground(new Color(255, 149, 0));
        buttonDelete.setForeground(Color.white);
        buttonDelete.setFocusable(false);
        f.add(buttonDelete);
        //Applying Style and Adding Clear Button
        buttonClear.setBounds(120, 140, 80,40);
        buttonClear.setFont(myFont);
        buttonClear.setBackground(new Color(255, 149, 0));
        buttonClear.setForeground(Color.white);
        buttonClear.setFocusable(false);
        f.add(buttonClear);
        //Applying Style and Adding bracketLeft Button
        bracketL.setBounds(20, 210, 80,40);
        bracketL.setFont(myFont);
        bracketL.setBackground(new Color(212, 212, 210));
        bracketL.setForeground(Color.black);
        bracketL.setFocusable(false);
        f.add(bracketL);
        //Applying Style and Adding Divide Button 
        buttonDiv.setBounds(320, 140, 80,40);
        buttonDiv.setForeground(Color.black);
        buttonDiv.setFont(myFont);
        buttonDiv.setBackground(new Color(212, 212, 210));
        buttonDiv.setFocusable(false);
        f.add(buttonDiv);
        //2ND ROW
        //Applying Style and Adding Square Root Button 
        buttonSqrt.setBounds(220, 140, 80,40);
        buttonSqrt.setForeground(Color.black);
        buttonSqrt.setBackground(new Color(212, 212, 210));
        buttonSqrt.setFont(myFont);
        buttonSqrt.setFocusable(false);
        f.add(buttonSqrt);
        //Applying Style and Adding Square Button 
        buttonSquare.setBounds(220, 210, 80,40);
        buttonSquare.setBackground(new Color(212, 212, 210));
        buttonSquare.setForeground(Color.black);
        buttonSquare.setFont(myFont);
        buttonSquare.setFocusable(false);
        f.add(buttonSquare);
        //Applying Style and Adding bracketRight Button 
        bracketR.setBounds(120, 210, 80,40);
        bracketR.setBackground(new Color(212, 212, 210));
        bracketR.setForeground(Color.black);
        bracketR.setFont(myFont);
        bracketR.setFocusable(false);
        f.add(bracketR);
        //Applying Style and Adding Multiplication Button 
        buttonMul.setBounds(320, 210, 80,40); 
        buttonMul.setForeground(Color.black);
        buttonMul.setFont(myFont);
        buttonMul.setBackground(new Color(212, 212, 210));
        buttonMul.setFocusable(false);
        f.add(buttonMul);

        //3RD ROW
        //Applying Style and Adding Button Nine
        btn9.setBounds(220, 280, 80,40);
        btn9.setBackground(new Color(40, 40, 40));
        btn9.setForeground(Color.white);
        btn9.setFont(myFont);
        btn9.setFocusable(false);
        f.add(btn9);
        //Applying Style and Adding Button Eight
        btn8.setBounds(120, 280, 80,40);
        btn8.setBackground(new Color(40, 40, 40));
        btn8.setForeground(Color.white);
        btn8.setFont(myFont);
        btn8.setFocusable(false);
        f.add(btn8);
        //Applying Style and Adding Button Seven
        btn7.setBounds(20, 280, 80,40);
        btn7.setBackground(new Color(40, 40, 40));
        btn7.setForeground(Color.white);
        btn7.setFont(myFont);
        btn7.setFocusable(false);
        f.add(btn7);
        //Applying Style and Adding Subtraction Button 
        buttonMinus.setBounds(320, 280, 80,40);
        buttonMinus.setForeground(Color.black);
        buttonMinus.setFont(myFont);
        buttonMinus.setBackground(new Color(212, 212, 210));
        buttonMinus.setFocusable(false);
        f.add(buttonMinus);

        //4TH ROW
        //Applying Style and Adding Button Six
        btn6.setBounds(220, 350, 80,40);
        btn6.setBackground(new Color(40, 40, 40));
        btn6.setForeground(Color.white);
        btn6.setFont(myFont);
        btn6.setFocusable(false);
        f.add(btn6);
        //Applying Style and Adding Button Five
        btn5.setBounds(120, 350, 80,40);
        btn5.setBackground(new Color(40, 40, 40));
        btn5.setForeground(Color.white);
        btn5.setFont(myFont);
        btn5.setFocusable(false);
        f.add(btn5);
        //Applying Style and Adding Button Four
        btn4.setBounds(20, 350, 80,40);
        btn4.setBackground(new Color(40, 40, 40));
        btn4.setForeground(Color.white);
        btn4.setFont(myFont);
        btn4.setFocusable(false);
        f.add(btn4);
        //Applying Style and Adding Addition Button 
        buttonPlus.setBounds(320, 350, 80,40);
        buttonPlus.setForeground(Color.black);
        buttonPlus.setFont(myFont);
        buttonPlus.setBackground(new Color(212, 212, 210));
        buttonPlus.setFocusable(false);
        f.add(buttonPlus);
        //5TH ROW
        //Applying Style and Adding Button Three
        btn3.setBounds(220, 420, 80,40);
        btn3.setBackground(new Color(40, 40, 40));
        btn3.setForeground(Color.white);
        btn3.setFont(myFont);
        btn3.setFocusable(false);
        f.add(btn3);
        //Applying Style and Adding Button Two
        btn2.setBounds(120, 420, 80,40);
        btn2.setBackground(new Color(40, 40, 40));
        btn2.setForeground(Color.white);
        btn2.setFont(myFont);
        btn2.setFocusable(false);
        f.add(btn2);
        //Applying Style and Adding Button One
        btn1.setBounds(20, 420, 80,40);
        btn1.setBackground(new Color(40, 40, 40));
        btn1.setForeground(Color.white);
        btn1.setFont(myFont);
        btn1.setFocusable(false);
        f.add(btn1);
        //Applying Style and Adding Equal Button 
        buttonEqual.setBounds(320, 420, 80,110);
        buttonEqual.setForeground(Color.white);
        buttonEqual.setFont(myFont);
        buttonEqual.setBackground(new Color(255, 149, 0));
        buttonEqual.setFocusable(false);
        f.add(buttonEqual);
        //6TH ROW
        //Applying Style and Adding Button Zero
        btn0.setBounds(120, 490, 80,40);
        btn0.setBackground(new Color(40, 40, 40));
        btn0.setForeground(Color.white);
        btn0.setFont(myFont);
        btn0.setFocusable(false);
        f.add(btn0);
        //Applying Style and Adding Unique Button 
        buttonUnique.setBounds(20, 490, 80,40); 
        buttonUnique.setFont(myFont2);
        buttonUnique.setBackground(new Color(255,255,255));
        buttonUnique.setForeground(Color.black);
        buttonUnique.setFocusable(false);
        f.add(buttonUnique);
        //Applying Style and Adding Enter Button 
        buttonEnter.setBounds(320, 420, 80,110); 
        buttonEnter.setFont(myFont2);
        buttonEnter.setBackground(new Color(255, 149, 0));
        buttonEnter.setForeground(Color.white);
        buttonEnter.setFocusable(false);
        buttonEnter.setVisible(false);
        f.add(buttonEnter);
        //Applying Style and Adding Show Button 
        bHistory.setBounds(220, 490, 80,40); 
        bHistory.setFont(myFont2);
        bHistory.setBackground(new Color(255, 149, 0));
        bHistory.setForeground(Color.white);
        bHistory.setFocusable(false);
        bHistory.setVisible(true);
        f.add(bHistory);
    }
    //Declaring listener interface for receiving action events that indicates that a specific button is pressed.
    public void actionEvent() {
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        bracketR.addActionListener(this);
        bracketL.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonUnique.addActionListener(this);
        buttonEnter.addActionListener(this);
        bHistory.addActionListener(this);
        cHisButton.addActionListener(this);
    }
    //Creating a void class "actionPerformed" in which an action event occurs when a button is pressed.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn0) { // Button 0
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }

            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
                hField.setText(textField.getText());
            }
        } else if (e.getSource() == btn1) { // Button 1
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "1"); 
            hField.setText( hField.getText() + "1");
        } else if (e.getSource() == btn2) { // Button 2
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "2");
            hField.setText( hField.getText() + "2");
        } else if (e.getSource() == btn3) { // Button 3
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "3");
            hField.setText( hField.getText() + "3");
        } else if (e.getSource() == btn4) { // Button 4
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "4");
            hField.setText( hField.getText() + "4");
        } else if (e.getSource() == btn5) { // Button 5
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "5");
            hField.setText( hField.getText() + "5");
        } else if (e.getSource() == btn6) { // Button 6
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "6");
            hField.setText( hField.getText() + "6");
        } else if (e.getSource() == btn7) { // Button 7
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "7");
            hField.setText( hField.getText() + "7");
        } else if (e.getSource() == btn8) { // Button 8
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "8");
            hField.setText( hField.getText() + "8");
        } else if (e.getSource() == btn9) { // Button 9
            if (calculation == 1){
                textField.setText("");
                hField.setText("");
                calculation = 0;
            }else if (calculation == 2){
                textField.setText("");
                calculation = 0;
            }
            textField.setText(textField.getText() + "9");
            hField.setText( hField.getText() + "9");
        }  else if (e.getSource() == buttonClear) { // Clear All Button 
            textField.setText("");
            mField.setText("\nMean:  " + "\n\n" + "Median:  " + "\n\n" + "Mode:  ");
            hField.setText("");
        } else if (e.getSource() == buttonDelete) { // Delete Button 
            String length = textField.getText();
            String length2 = hField.getText();
            
            
            if (textField.getText().isEmpty()) {
                mField.setText("");
                textField.setText("");
            } else {
                length = length.substring(0, length.length()-1);
                textField.setText(length);
                length2 = length2.substring(0, length2.length()-1);
                hField.setText(length2);
            }
            
        } else if (e.getSource() == buttonPlus) { // Add Button 
            
            if (!textField.getText().endsWith("(") && !hField.getText().endsWith("+") && !textField.getText().isEmpty()){
                calculation = 2;
                if (textField.getText().endsWith(")") ) {
                    textField.setText("");
                    hField.setText(hField.getText() + "+");
                }
                else if (textField.getText().contains("(") ){
                    textField.setText(textField.getText() + "+");
                    hField.setText(hField.getText() + "+");
                }
                else {
                    textField.setText("");
                    hField.setText(hField.getText() + "+");
                }
            } else{
                return;
            }
        } else if (e.getSource() == buttonMinus) { // Subtract Button 
            if (!textField.getText().endsWith("(") && !hField.getText().endsWith("-")&& !textField.getText().isEmpty()){
                calculation = 2;
                if (textField.getText().endsWith(")") ) {
                    textField.setText("");
                    hField.setText(hField.getText() + "-");
                }
                else if (textField.getText().contains("(") ){
                    textField.setText(textField.getText() + "-");
                    hField.setText(hField.getText() + "-");
                }
                else {
                    textField.setText("");
                    hField.setText(hField.getText() + "-");
                }
            } else{
                return;
            }
        } else if (e.getSource() == buttonMul) { // Multiply Button 
            if (!textField.getText().endsWith("(") && !hField.getText().endsWith("*") && !textField.getText().isEmpty()){
                calculation = 2;
                if (textField.getText().endsWith(")") ) {
                    textField.setText("");
                    hField.setText(hField.getText() + "*");
                }
                else if (textField.getText().contains("(") ){
                    textField.setText(textField.getText() + "*");
                    hField.setText(hField.getText() + "*");
                }
                else {
                    textField.setText("");
                    hField.setText(hField.getText() + "*");
                }
            } else{
                return;
            }
        } else if (e.getSource() == buttonDiv) { // Divide Button 
            if (!textField.getText().endsWith("(") && !hField.getText().endsWith("/") && !textField.getText().isEmpty()){
                calculation = 2;
                if (textField.getText().endsWith(")") ) {
                    textField.setText("");
                    hField.setText(hField.getText() + "/");
                }
                else if (textField.getText().contains("(") ){
                    textField.setText(textField.getText() + "/");
                    hField.setText(hField.getText() + "/");
                }
                else {
                    textField.setText("");
                    hField.setText(hField.getText() + "/");
                }
            } else{
                return;
            }
        } else if (e.getSource() == bracketL) { // bracketL Button 
            textField.setText(textField.getText() + "(");
            hField.setText( hField.getText() + "(");
        } else if (e.getSource() == buttonSqrt) { // Square Root Button 
            try{
                calculation = 2;
                number = Double.parseDouble(textField.getText());
                hField.setText(hField.getText().replace(textField.getText(), ""));
                Double sqrt = Math.sqrt(number);
                String string = Double.toString(sqrt);
                if (string.endsWith(".0")) {
                    textField.setText(string.replace(".0", ""));
                    hField.setText(hField.getText() + string.replace(".0", ""));
                } else {
                    textField.setText(string);
                    hField.setText(hField.getText() + string);
                }
            }catch(Exception a) {
                textField.setText("");
            }
        } else if (e.getSource() == buttonSquare) { //Square Button 
            try {
                calculation = 2;
                number = Double.parseDouble(textField.getText());
                hField.setText(hField.getText().replace(textField.getText(), ""));
                double square = Math.pow(number, 2);
                String string = Double.toString(square);
                if (string.endsWith(".0")) {
                    textField.setText(string.replace(".0", ""));
                    hField.setText(hField.getText() + string.replace(".0", ""));
                } else {
                    textField.setText(string);
                    hField.setText(hField.getText() + string);
                }    
            } catch (Exception b) {
                textField.setText("");
            }
            
        } else if (e.getSource() == bracketR) { // bracketR Button 
            if (!textField.getText().endsWith("+") || !textField.getText().endsWith("-") || !textField.getText().endsWith("*") || !textField.getText().endsWith("/") ){
                if (textField.getText().isEmpty()){
                    return;
                }else{
                        textField.setText(textField.getText() + ")");
                        hField.setText( hField.getText() + ")");
                }
            } else {
                return;
            }
            
        } else if (e.getSource() == buttonUnique) { // Unique Button 
           if (buttonUnique.getText()=="Unique"){
            layout2();
           }else if(buttonUnique.getText()=="Done") {
            layout();
           }
        } else if (e.getSource() == buttonEqual) { // Equal Button 
                                                                    //using the idea of stack to compute the string in the history field 
                                                                     // evalute method is use to convert to string array
            if (!textField.getText().isEmpty() && calculation == 0){
                answer = evaluate(hField.getText());
                allHistory.setText(allHistory.getText() + ">> " + hField.getText() + "\n");
                calculation = 1;
                if (Double.toString(answer).endsWith(".0")) {
                    textField.setText(Double.toString(answer).replace(".0", ""));
                    hField.setText(Double.toString(answer).replace(".0", ""));
                    allHistory.setText(allHistory.getText() + "=> " +  (Double.toString(answer).replace(".0", "")) + "\n");
                } else {
                    textField.setText(Double.toString(answer));
                    hField.setText(Double.toString(answer));
                    allHistory.setText(allHistory.getText() + "=> " +  (Double.toString(answer)) + "\n");
                }
            } 
            
            
        }else if (e.getSource() == buttonEnter){            //to output MMM
            try {
                input = textField.getText();
                ArrayList<Double> numbers = ConvertToNumbers(input);

                if(!input.endsWith(" ")){
                    textField.setText(textField.getText() + " ");
                } else{
                    return;
                }
                String meanAns = Double.toString(mean(numbers));
                String medianAns = Double.toString(median(numbers));
                String modeAns = mode(numbers);
                mField.setText("\nMean:  " + meanAns +  "\n\n" + "Median:  " + medianAns + "\n\n" + "Mode:  " + modeAns);
                
            } catch (Exception d) {
                textField.setText("");
            }
            

        }else if (e.getSource() == bHistory){
            if (bHistory.getText()=="Show"){
                f.setSize(820, 600);
                bHistory.setText("Hide");
               }else if(bHistory.getText()=="Hide") {
                f.setSize(440, 600);
                bHistory.setText("Show");
               }
        }else if (e.getSource() == cHisButton){
            allHistory.setText("");
        }
    }
    
    public static ArrayList<Double> ConvertToNumbers(String input){
        ArrayList<Double> numbers = new ArrayList<>();
		String num = "";

		for (int i = 0; i < input.length(); i++) {

			char check = input.charAt(i);
			if (Character.isDigit(check) || check == '.' || check == '-') {
				num = num + check;
				if (i == input.length() - 1) {
					numbers.add(Double.parseDouble(num));
				}
			} else if (!num.isEmpty()) {
				numbers.add(Double.parseDouble(num));
				num = "";
			}

		}

		Comparator<Double> c = new Comparator<Double>() {
			
			public int compare(Double o1, Double o2) {
				if ((double) o1 > (double) o2)
					return 1;
				else
					return -1;
			}
		};

		numbers.sort(c);
		return numbers;

    }
    public static double mean(ArrayList<Double> numbers) {          //method for getting Mean
		double mean = 0.0 ;

		for (int i = 0; i < numbers.size(); i++) {
			mean = mean + numbers.get(i);
		}

		mean = mean / numbers.size();
		return mean;
	}

    public static double median(ArrayList<Double> numbers) {        //method for getting Median
		double median = 0;

		if (numbers.size() % 2 == 0) {
			double first = numbers.get(numbers.size() / 2);
			double second = numbers.get((numbers.size() / 2) - 1);
			median = (first + second) / 2;
		} else {
			median = numbers.get(numbers.size() / 2);
		}
		return median;
	}
    
    public static String mode(ArrayList<Double> numbers) {          //method for getting Mode

		String mode = "";
		if (numbers.size() == 1) {
			mode = String.valueOf(numbers.get(0));
		} else {
			ArrayList<Double> allNumOnce = new ArrayList<>();
			allNumOnce.add(numbers.get(0));
			for (int i = 1; i < numbers.size(); i++) {
				double check = numbers.get(i);
				if (check != numbers.get(i - 1)) {
					allNumOnce.add(numbers.get(i));
				}
			}

			ArrayList<Integer> counts = new ArrayList<>();
			int count = 1;
			for (int j = 1; j < numbers.size(); j++) {
				double check = numbers.get(j);
				if (check == numbers.get(j - 1)) {
					count++;
				} else {
					counts.add(count);
					count = 1;
				}
				if (j == numbers.size() - 1) {
					counts.add(count);
				}
			}

			int biggest = 0;
			for (int k = 0; k < counts.size(); k++) {
				int check = counts.get(k);
				if (check >= biggest) {
					biggest = check;
				}
			}

			int index = counts.indexOf(biggest);
			int count2 = 1;
			boolean one = true;
			double check = counts.get(0);
			for (int k = 1; k < counts.size(); k++) {
				if ((check == counts.get(k)) && check == 1) {
					one = one && true;
				} else {
					one = one && false;
				}
			}

			while (index != -1) {
				double modeTmp = allNumOnce.get(index);
				counts.remove(index);
				allNumOnce.remove(index);
				index = counts.indexOf(biggest);
				if (count2 == 1) {
					mode = String.valueOf(modeTmp);
				} else {
					mode = mode + ", " + String.valueOf(modeTmp);
				}
				count2++;
			}

			if (counts.isEmpty() && one) {
				mode = "All of them";
			}
		}

		return mode;
	}
    
    public static double evaluate(String expression) {             // method for computation
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;

			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);

				values.push(Integer.parseInt(sbuf.toString()));

				i--;
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.pop();
			}

			else if (tokens[i] == '+' ||
					tokens[i] == '-' ||
					tokens[i] == '*' ||
					tokens[i] == '/') {

				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	public static int applyOp(char op, int b, int a) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)
					throw new UnsupportedOperationException(
							"Cannot divide by zero");
				return a / b;
		}
		return 0;
	}

    //creating a main method containing the function "calculator".
    public static void main(String[] args)
    {
        new Calculator();
    }
}

