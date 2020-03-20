import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Label;

public class Calc extends JFrame {
 private JPanel contentPane;
 private JTextField txtTest;
 private Label label1;
 private final ButtonGroup buttonGroup = new ButtonGroup();
 double num1;
 double num;
 double ans;
 int calculation;
 boolean decimal = false;

 /**
  * Launch the application.
  */

 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Calc frame = new Calc();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 public void checkchars() {

  for (int i = 0; i < txtTest.getText().length(); i++) {
   char character = txtTest.getText().charAt(i);
   if (character == '.') {
    decimal = true;

   }

  }
  if (decimal == false)
   txtTest.setText(txtTest.getText() + ".");
 }

 public void arithmetic_operation() {
  switch (calculation) {
   case 1:
    ans = num + Double.parseDouble(txtTest.getText());
    txtTest.setText(Double.toString(ans));
    break;
   case 2:
    ans = num - Double.parseDouble(txtTest.getText());
    txtTest.setText(Double.toString(ans));
    break;
   case 3:
    ans = num * Double.parseDouble(txtTest.getText());
    txtTest.setText(Double.toString(ans));
    break;
   case 4:
    ans = num / Double.parseDouble(txtTest.getText());
    txtTest.setText(Double.toString(ans));
    break;
  }
 }

 /**
  * Create the frame.
  */
 public Calc() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 450, 338);
  contentPane = new JPanel();
  contentPane.setLocation(new Point(500, 250));
  contentPane.setName("frame1");
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);

  txtTest = new JTextField();
  txtTest.setHorizontalAlignment(SwingConstants.RIGHT);
  txtTest.setFont(new Font("Tahoma", Font.BOLD, 22));
  txtTest.setBounds(25, 21, 380, 39);
  contentPane.add(txtTest);
  txtTest.setColumns(10);

  Label label1 = new Label();
  label1.setFont(new Font("Tahoma", Font.PLAIN, 12));
  label1.setAlignment(Label.RIGHT);
  label1.setForeground(Color.RED);
  label1.setBounds(286, 0, 108, 15);
  contentPane.add(label1);

  JRadioButton rdbtnOn = new JRadioButton("ON");
  rdbtnOn.setSelected(true);
  buttonGroup.add(rdbtnOn);
  rdbtnOn.setFont(new Font("Tahoma", Font.BOLD, 11));
  rdbtnOn.setBounds(35, 67, 53, 23);
  contentPane.add(rdbtnOn);

  JRadioButton rdbtnOff = new JRadioButton("OFF");
  buttonGroup.add(rdbtnOff);
  rdbtnOff.setFont(new Font("Tahoma", Font.BOLD, 11));
  rdbtnOff.setBounds(35, 90, 53, 23);
  contentPane.add(rdbtnOff);

  JButton btnArrow = new JButton("<--");
  btnArrow.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    int length = txtTest.getText().length();
    int number = txtTest.getText().length() - 1;
    String store;
    if (length > 0) {
     StringBuilder back = new StringBuilder(txtTest.getText());
     back.deleteCharAt(number);
     store = back.toString();
     txtTest.setText(store);

    }

   }
  });
  btnArrow.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  btnArrow.setFont(new Font("Tahoma", Font.BOLD, 14));
  btnArrow.setBounds(139, 71, 68, 33);
  contentPane.add(btnArrow);

  JButton btnC = new JButton("C");
  btnC.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText("");
    label1.setText("");
    num = 0;
   }
  });
  btnC.setFont(new Font("Tahoma", Font.BOLD, 20));
  btnC.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  btnC.setBounds(239, 71, 68, 33);
  contentPane.add(btnC);

  JButton btnPlus = new JButton("+");
  btnPlus.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    num = Double.parseDouble(txtTest.getText());
    calculation = 1;
    txtTest.setText("");
    label1.setText(num + "+");

   }
  });
  btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
  btnPlus.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  btnPlus.setBounds(337, 71, 68, 33);
  contentPane.add(btnPlus);

  JButton button_1 = new JButton("7");
  button_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "7");
   }
  });
  button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_1.setBounds(35, 115, 68, 33);
  contentPane.add(button_1);

  JButton button_2 = new JButton("8");
  button_2.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "8");
   }
  });
  button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_2.setBounds(139, 115, 68, 33);
  contentPane.add(button_2);

  JButton button_3 = new JButton("9");
  button_3.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "9");
   }
  });
  button_3.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_3.setBounds(239, 115, 68, 33);
  contentPane.add(button_3);

  JButton button_4 = new JButton("-");
  button_4.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    num = Double.parseDouble(txtTest.getText());
    calculation = 2;
    txtTest.setText("");
    label1.setText(num + "-");

   }
  });
  button_4.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_4.setBounds(337, 115, 68, 33);
  contentPane.add(button_4);

  JButton button_5 = new JButton("4");
  button_5.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "4");
   }
  });
  button_5.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_5.setBounds(35, 159, 68, 33);
  contentPane.add(button_5);

  JButton button_6 = new JButton("5");
  button_6.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "5");
   }
  });
  button_6.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_6.setBounds(139, 159, 68, 33);
  contentPane.add(button_6);

  JButton button_7 = new JButton("6");
  button_7.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "6");
   }
  });
  button_7.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_7.setBounds(239, 159, 68, 33);
  contentPane.add(button_7);

  JButton button_8 = new JButton("*");
  button_8.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    num = Double.parseDouble(txtTest.getText());
    calculation = 3;
    txtTest.setText("");
    label1.setText(num + "*");

   }
  });
  button_8.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_8.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_8.setBounds(337, 159, 68, 33);
  contentPane.add(button_8);

  JButton button_9 = new JButton("1");
  button_9.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "1");
   }
  });
  button_9.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_9.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_9.setBounds(35, 203, 68, 33);
  contentPane.add(button_9);

  JButton button_10 = new JButton("2");
  button_10.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "2");
   }
  });
  button_10.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_10.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_10.setBounds(139, 203, 68, 33);
  contentPane.add(button_10);

  JButton button_11 = new JButton("3");
  button_11.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "3");
   }
  });
  button_11.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_11.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_11.setBounds(239, 203, 68, 33);
  contentPane.add(button_11);

  JButton button_12 = new JButton("/");
  button_12.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    num = Double.parseDouble(txtTest.getText());
    calculation = 4;
    txtTest.setText("");
    label1.setText(num + "/");

   }
  });
  button_12.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_12.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_12.setBounds(337, 203, 68, 33);
  contentPane.add(button_12);

  JButton button_13 = new JButton("0");
  button_13.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText(txtTest.getText() + "0");
   }
  });
  button_13.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_13.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_13.setBounds(35, 247, 68, 33);
  contentPane.add(button_13);

  JButton button_14 = new JButton(".");
  button_14.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {

    checkchars();

   }
  });
  button_14.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_14.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_14.setBounds(139, 247, 68, 33);
  contentPane.add(button_14);

  JButton button_15 = new JButton("=");
  button_15.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if (Double.parseDouble(txtTest.getText()) != 0) {
     arithmetic_operation();
     label1.setText("");
    }
   }
  });
  button_15.setFont(new Font("Tahoma", Font.BOLD, 20));
  button_15.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
  button_15.setBounds(239, 247, 166, 33);
  contentPane.add(button_15);

  rdbtnOff.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    txtTest.setText("");
    rdbtnOff.setEnabled(false);

    txtTest.setEnabled(false);
    btnArrow.setEnabled(false);
    btnC.setEnabled(false);
    btnPlus.setEnabled(false);
    button_1.setEnabled(false);
    button_2.setEnabled(false);
    button_3.setEnabled(false);
    button_4.setEnabled(false);
    button_5.setEnabled(false);
    button_6.setEnabled(false);
    button_7.setEnabled(false);
    button_8.setEnabled(false);
    button_9.setEnabled(false);
    button_10.setEnabled(false);
    button_11.setEnabled(false);
    button_12.setEnabled(false);
    button_13.setEnabled(false);
    button_14.setEnabled(false);
    button_15.setEnabled(false);
   }
  });
  rdbtnOn.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {

    rdbtnOff.setEnabled(true);
    txtTest.setEnabled(true);
    btnArrow.setEnabled(true);
    btnC.setEnabled(true);
    btnPlus.setEnabled(true);
    button_1.setEnabled(true);
    button_2.setEnabled(true);
    button_3.setEnabled(true);
    button_4.setEnabled(true);
    button_5.setEnabled(true);
    button_6.setEnabled(true);
    button_7.setEnabled(true);
    button_8.setEnabled(true);
    button_9.setEnabled(true);
    button_10.setEnabled(true);
    button_11.setEnabled(true);
    button_12.setEnabled(true);
    button_13.setEnabled(true);
    button_14.setEnabled(true);
    button_15.setEnabled(true);
   }
  });

 }
}