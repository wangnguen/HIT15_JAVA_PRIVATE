package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JframeExamle {
  public static void main(String[] args) {
    // Frame:
    JFrame frame = new JFrame("JFrame Example");

    // // Button:
    // JButton btn = new JButton("Username");
    // JButton btn2 = new JButton("Password");
    // btn.setBounds(50, 20, 80, 30);
    // btn2.setBounds(50, 80, 80, 30);
    // frame.add(btn);
    // frame.add(btn2);
    // // Them su kien cho button
    // btn.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // System.out.println("Ong da an username");
    // btn.setText("Click"); // doi ten nut
    // }
    // });
    // btn2.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // System.out.println("Ong da an password");
    // }
    // });

    // // Label:
    // JLabel lbl = new JLabel("Username");
    // JLabel lbl2 = new JLabel("Password");
    // lbl.setBounds(50, 50, 100, 30);
    // lbl.setText("Username: ");
    // lbl2.setBounds(50, 100, 100, 30);
    // frame.add(lbl);
    // frame.add(lbl2);
    // // TextField:
    // JTextField username = new JTextField("username");
    // JTextField password = new JTextField("");
    // username.setBounds(150, 50, 120, 30);
    // password.setBounds(150, 100, 120, 30);
    // frame.add(username);
    // frame.add(password);

    // JButton login = new JButton("Login");
    // login.setBounds(150, 150, 100, 30);
    // frame.add(login);

    // login.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // System.out.println(username.getText());
    // System.out.println(password.getText());
    // }
    // });

    // JTextArea:
    JTextArea jta = new JTextArea();
    jta.setBounds(50, 50, 300, 100);
    jta.setLineWrap(true); // tu dong xuong dong
    jta.setWrapStyleWord(true); // cac tu se luon di cung nhau
    frame.add(jta);
    JButton btnx = new JButton("Click me");
    btnx.setBounds(50, 180, 100, 30);
    frame.add(btnx);

    btnx.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(jta.getText());
      }
    });

    // JPasswordField (getPassword -> char[])
    JPasswordField password = new JPasswordField();
    password.setBounds(50, 10, 100, 30);
    frame.add(password);

    JButton btnxx = new JButton("click");
    btnxx.setBounds(180, 10, 100, 30);
    frame.add(btnxx);
    btnxx.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(String.valueOf(password.getPassword()));
        // tra ve string
      }
    });

    // JOptionPane
    JOptionPane.showMessageDialog(frame, "Successful !");

    frame.setSize(400, 300); // cai dat kich thuoc
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // dong GUI
    frame.setLocationRelativeTo(null); // hien thi o giua
    frame.setLayout(null); // khong muon theo layout mac dinh(layout mac dinh la tran ra )
    frame.setVisible(true); // hien thi frame len
  }
}