import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends complex implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[18];
    JButton addButton, subButton, mulButton, divButton;
    JButton delButton, clrButton, realButton, powrButton, decButton, imgButton;
    JButton formArtButton, formGeoButton, formExpButton, moinButton;
    JButton moduleButton, argDegButton, argRadButton,dispButton;
    JPanel panel;
    Font myFont = new Font("Roboto", Font.BOLD, 17);
    float r = 0;
    float im = 0;
    int k1,k2 = 0;
    complex result;
    char operator = 'a';
    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(340, 600);
        textField = new JTextField();
        textField.setBounds(7, 15, 310, 60);
        textField.setFont(myFont);
        textField.setEditable(false);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        realButton = new JButton("real");
        powrButton = new JButton("^2");
        formArtButton = new JButton("Art");
        formGeoButton = new JButton("Geo");
        formExpButton = new JButton("Exp");
        moduleButton = new JButton("Mod");
        argDegButton = new JButton("ArgD");
        argRadButton = new JButton("ArgR");
        imgButton = new JButton("img");
        decButton = new JButton(".");
        moinButton = new JButton("--");
        dispButton = new JButton("Result");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = delButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = realButton;
        functionButtons[7] = powrButton;
        functionButtons[8] = formArtButton;
        functionButtons[9] = formGeoButton;
        functionButtons[10] = formExpButton;
        functionButtons[11] = moduleButton;
        functionButtons[12] = argDegButton;
        functionButtons[13] = argRadButton;
        functionButtons[14] = imgButton;
        functionButtons[15] = decButton;
        functionButtons[16] = moinButton;
        functionButtons[17] = dispButton;
        for (int i = 0; i < 18; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        panel = new JPanel();
        panel.setBounds(2, 228, 320, 330);
        panel.setBackground(new Color(218, 220, 227, 255));
        panel.setLayout(new GridLayout(0, 4, 10, 10));
        panel.add(argRadButton);
        panel.add(argDegButton);
        panel.add(moduleButton);
        panel.add(formExpButton);
        panel.add(clrButton);
        panel.add(powrButton);
        panel.add(moinButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(realButton);
        panel.add(imgButton);
        textField.setBounds(2,0,320,90);
        dispButton.setBounds(2,96,320,60);
        formArtButton.setBounds(2, 162, 155, 60);
        formGeoButton.setBounds(168, 162, 155, 60);
        frame.add(panel);
        frame.add(formArtButton);
        frame.add(formGeoButton);
        frame.add(dispButton);
        frame.setVisible(true);
        frame.add(textField);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        for (i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == realButton) {
            if (k1==0){
                super.real = Float.parseFloat(textField.getText());
                textField.setText("");
                k1++;
            }else {
                r = Float.parseFloat(textField.getText());
                textField.setText("");
                k1=0;
            }
        }
        if (e.getSource() == imgButton) {
            if (k2==0){
                super.img = Float.parseFloat(textField.getText());
                textField.setText("");
                k2++;
            }else {
                im = Float.parseFloat(textField.getText());
                textField.setText("");
                k2=0;
            }
        }
        if (e.getSource() == moinButton) {
            textField.setText("-");
        }
        if (e.getSource() == argDegButton) {
            textField.setText(String.valueOf(super.argDeg()));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
                super.img = 0;
                super.real = 0;
                im = 0;
                r = 0;
                k1=0;
                k2=0;
                operator='a';
            }
            if (e.getSource() == argRadButton) {
                textField.setText(String.valueOf(super.argRad()));
            }
            if (e.getSource() == moduleButton) {
                textField.setText(String.valueOf(super.modulo()));
            }
            if (e.getSource() == decButton) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == addButton) {
                operator = '+';
            }
            if (e.getSource() == subButton) {
                operator = '-';
            }
            if (e.getSource() == divButton) {
                operator = '/';
            }
            if (e.getSource() == mulButton) {
                operator = '*';
            }
            if (e.getSource()== powrButton){
                operator = '^';
            }
            if (e.getSource() == formExpButton) {
                textField.setText(String.format("La form Exp.. : %.0f * e (i %.0f Deg)", super.modulo(), super.argDeg()));
            }
            if (e.getSource() == formArtButton) {
                textField.setText(String.format("La form Art.. : %.2f + %.2f i", super.real, super.img));
            }
            if (e.getSource() == formGeoButton) {
                textField.setText(String.format("la form geo.. %.2f (cos %.0f + i sin %.0f)", super.modulo(), super.argDeg(), super.argDeg()));
            }
            if (e.getSource() == dispButton){
                if( operator == '+'){
                float result [] = super.addition(r,im);
                textField.setText(String.format("Real : %.2f || Img : %.2f",result[0],result[1]));
                } else if (operator == '-') {
                float result [] = super.substraction(r,im);
                textField.setText(String.format("Real : %.2f || Img : %.2f",result [0], result [1]));
                } else if (operator == '*') {
                    float result [] = super.multi(r,im);
                    textField.setText(String.format("Real : %.2f || Img : %.2f",result [0], result [1]));
                } else if (operator == '/'){
                    float result [] = super.division(r,im);
                    textField.setText(String.format("Real : %.2f / %.2f || Img %.2f / %.2f",result[0],result[1],result[2],result[3]));
                } else if (operator == '^') {
                    float result [] = super.power();
                    textField.setText(String.format("Real : %.2f || Img : %.2f ",super.real,super.img));
                }
            }
      }
}
