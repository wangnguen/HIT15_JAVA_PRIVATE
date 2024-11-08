package GUI.baitap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Calculator");
    frame.setSize(500, 350);

    JLabel firstNumber = new JLabel("First Number");
    JLabel secondNumber = new JLabel("Second Number");
    JLabel result = new JLabel("Result");
    firstNumber.setBounds(50, 30, 100, 30);
    secondNumber.setBounds(50, 80, 100, 30);
    result.setBounds(50, 130, 100, 30);

    JTextField inputFirstNumber = new JTextField();
    JTextField inputSecondNumber = new JTextField();
    JTextField inputResult = new JTextField();
    inputFirstNumber.setBounds(200, 30, 200, 30);
    inputSecondNumber.setBounds(200, 80, 200, 30);
    inputResult.setBounds(200, 130, 200, 30);

    JButton clear = new JButton("CLEAR");
    JButton add = new JButton("ADD");
    JButton sub = new JButton("SUB");
    JButton mul = new JButton("MUL");
    JButton div = new JButton("DIV");
    clear.setBounds(50, 180, 100, 30);
    add.setBounds(50, 240, 80, 30);
    sub.setBounds(150, 240, 80, 30);
    mul.setBounds(250, 240, 80, 30);
    div.setBounds(350, 240, 80, 30);

    frame.add(firstNumber);
    frame.add(secondNumber);
    frame.add(result);
    frame.add(inputFirstNumber);
    frame.add(inputSecondNumber);
    frame.add(inputResult);
    frame.add(clear);
    frame.add(add);
    frame.add(sub);
    frame.add(mul);
    frame.add(div);

    // xu li su kien
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        inputFirstNumber.setText("");
        inputSecondNumber.setText("");
        inputResult.setText("");
      }
    });

    add.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double numberFirst = Double.parseDouble(inputFirstNumber.getText());
        double numberSecond = Double.parseDouble(inputSecondNumber.getText());
        String result = Double.toString(numberFirst + numberSecond);
        inputResult.setText(result);
      }
    });

    sub.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double numberFirst = Double.parseDouble(inputFirstNumber.getText());
        double numberSecond = Double.parseDouble(inputSecondNumber.getText());
        String result = Double.toString(numberFirst - numberSecond);
        inputResult.setText(result);
      }
    });

    mul.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double numberFirst = Double.parseDouble(inputFirstNumber.getText());
        double numberSecond = Double.parseDouble(inputSecondNumber.getText());
        String result = Double.toString(numberFirst * numberSecond);
        inputResult.setText(result);
      }
    });

    div.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double numberFirst = Double.parseDouble(inputFirstNumber.getText());
        double numberSecond = Double.parseDouble(inputSecondNumber.getText());
        String result = Double.toString(numberFirst / numberSecond);
        inputResult.setText(result);
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
