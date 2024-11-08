package GUI.baitap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NameConverter {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Name Converter");
    frame.setSize(400, 300);

    JLabel fullName = new JLabel("Full Name");
    fullName.setBounds(30, 30, 100, 30);
    JLabel result = new JLabel("Result");
    result.setBounds(30, 90, 100, 30);

    JTextField fullNameField = new JTextField();
    fullNameField.setBounds(150, 30, 180, 30);
    JTextField resultField = new JTextField();
    resultField.setBounds(150, 90, 180, 30);

    JButton button = new JButton("Convert");
    button.setBounds(180, 150, 100, 30);

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String text = fullNameField.getText();
        String[] fullNames = text.split("\\s+");
        String newFullName = "";
        for (String name : fullNames) {
          newFullName += Character.toUpperCase(name.charAt(0));
          for (int i = 1; i < name.length(); i++) {
            newFullName += Character.toLowerCase(name.charAt(i));
          }
          newFullName += " ";
        }
        newFullName.trim();
        resultField.setText(newFullName);
      }
    });

    frame.add(fullName);
    frame.add(result);
    frame.add(fullNameField);
    frame.add(resultField);
    frame.add(button);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
