import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

import static java.awt.Font.DIALOG_INPUT;

public class Calculator extends Actualcalculations implements ActionListener
         {
    private double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public String inputBuffer = "";
    public double memory = 0.0;

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[12];
    JButton[] functionButtons = new JButton[5];
    JButton[] complexButtons = new JButton[36];
    JButton addButton, subButton, mulButton, divButton, equButton;
    JButton decButton;
    JButton delButton, clrButton, negButton, obracButton, cbracButton, mcButton, mpButton, mnButton, mrButton, pnButton, modButton, secButton, pow2Button, pow3Button, powxButton, poweButton, pow10Button, xButton, recButton, sinButton, cosButton, tanButton, eButton, r2Button, r3Button, rxButton, lnButton, logButton, xeButton, EEButton, radButton, sinhButton, coshButton, tanhButton, piButton, randButton;
    JPanel panel;



    Font textfont = new Font(DIALOG_INPUT, Font.PLAIN, 25);
    Font myfont = new Font("SansSerif", Font.PLAIN, 16);
    Color orangeColor = new Color(243, 128, 6);
    Color blackColor = Color.BLACK;
    Color lgray = new Color(103, 102, 103);
    Color dgray = new Color(57, 53, 59, 247);


    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 420);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(40, 5, 600, 70);
        textfield.setFont(textfont);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textfield.setHorizontalAlignment(JButton.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        obracButton = new JButton("(");
        cbracButton = new JButton(")");
        mcButton = new JButton("mc");
        mpButton = new JButton("m+");
        mnButton = new JButton("m-");
        mrButton = new JButton("mr");
        pnButton = new JButton("+/-");
        modButton = new JButton("%");
        secButton = new JButton("2nd");
        pow2Button = new JButton("x^2");
        pow3Button = new JButton("x^3");
        powxButton = new JButton("x^y");
        poweButton = new JButton("e^x");
        pow10Button = new JButton("10^x");
        xButton = new JButton("x");
        recButton = new JButton("1/x");
        r2Button = new JButton("2√x");
        r3Button = new JButton("3√x");
        rxButton = new JButton("x√y");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        xeButton = new JButton("x!");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        eButton = new JButton("e");
        EEButton = new JButton("EE");
        radButton = new JButton("Rad");
        sinhButton = new JButton("sinh");
        coshButton = new JButton("cosh");
        tanhButton = new JButton("tanh");
        piButton = new JButton("π");
        randButton = new JButton("Rand");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        ;

//        functionButtons[6] = delButton;
//        functionButtons[7] = clrButton;
//        functionButtons[8] = negButton;
        complexButtons[0] = delButton;
        complexButtons[1] = clrButton;
        complexButtons[2] = mrButton;
        complexButtons[3] = delButton;
        complexButtons[4] = obracButton;
        complexButtons[5] = cbracButton;
        complexButtons[6] = mcButton;
        complexButtons[7] = mpButton;
        complexButtons[8] = mnButton;
        complexButtons[9] = pnButton;
        complexButtons[10] = modButton;
        complexButtons[11] = secButton;
        complexButtons[12] = pow2Button;
        complexButtons[13] = pow3Button;
        complexButtons[14] = powxButton;
        complexButtons[15] = poweButton;
        complexButtons[16] = pow10Button;
        complexButtons[17] = xButton;
        complexButtons[18] = recButton;
        complexButtons[19] = sinButton;
        complexButtons[20] = cosButton;
        complexButtons[21] = tanButton;
        complexButtons[22] = eButton;
        complexButtons[23] = r2Button;
        complexButtons[24] = r3Button;
        complexButtons[25] = rxButton;
        complexButtons[26] = lnButton;
        complexButtons[27] = logButton;
        complexButtons[28] = xeButton;
        complexButtons[29] = EEButton;
        complexButtons[30] = sinhButton;
        complexButtons[31] = coshButton;
        complexButtons[32] = tanhButton;
        complexButtons[33] = radButton;
        complexButtons[34] = piButton;
        complexButtons[35] = randButton;


        numberButtons[11] = decButton;


        for (int i = 0; i < 5; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(orangeColor);
            functionButtons[i].setSize(30, 10);
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setBorder(BorderFactory.createEmptyBorder());
        }

        for (int i = 0; i < 12; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setBackground(lgray);

            numberButtons[i].setFocusable(false);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createEmptyBorder());

        }

        decButton.setBackground(lgray);
        decButton.setForeground(Color.WHITE);


        for (int i = 1; i < 12; i++) {
            numberButtons[i].setSize(30,10);
        }
        numberButtons[0].setSize(60,10);


        for (int i = 0; i < 36; i++) {
            complexButtons[i].addActionListener(this);
            complexButtons[i].setFont(myfont);
            complexButtons[i].setFocusable(false);
            complexButtons[i].setBackground(dgray);
            complexButtons[i].setSize(30, 10);
            complexButtons[i].setForeground(Color.WHITE);
            complexButtons[i].setBorder(BorderFactory.createEmptyBorder());

        }

//  negButton.setBounds(300, 550, 50,50);
//        delButton.setBounds(50, 550, 50, 50);
//        clrButton.setBounds(205, 550, 50, 50);


        panel = new JPanel();
        panel.setBounds(40, 70, 600, 300);
        panel.setLayout(new GridLayout(5, 9, 2, 2));
        panel.setBackground(Color.BLACK);


        panel.add(obracButton);
        panel.add(cbracButton);
        panel.add(mcButton);
        panel.add(mpButton);
        panel.add(mnButton);
        panel.add(mrButton);
        panel.add(clrButton);
        panel.add(pnButton);
        panel.add(modButton);
        panel.add(divButton);
        panel.add(secButton);
        panel.add(pow2Button);
        panel.add(pow3Button);
        panel.add(powxButton);
        panel.add(poweButton);
        panel.add(pow10Button);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(recButton);
        panel.add(r2Button);
        panel.add(r3Button);
        panel.add(rxButton);
        panel.add(lnButton);
        panel.add(logButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(xeButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(eButton);
        panel.add(EEButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(radButton);
        panel.add(sinhButton);
        panel.add(coshButton);
        panel.add(tanhButton);
        panel.add(piButton);
        panel.add(randButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);


        frame.add(textfield);
        //       frame.add(negButton);
        //       frame.add(delButton);
        //       frame.add(clrButton);
        frame.add(panel);

        frame.setVisible(true);

    }

   public static void main(String[] args) {

       Calculator calc;
       calc = new Calculator();


  }


    public void actionPerformed(ActionEvent e) {



        String command= e.getActionCommand();
        switch (command) {
            case "=":
                evaluateExpression();
                break;
            case "C":
                clearEntry();
                break;
            case "π":
                addToInput(Math.PI);

                break;
            case "e":
                addToInput(Math.E);
                break;
            case "x^2":
                addToInput("^2");
                break;
            case "x^3":
                addToInput("^3");
                break;
            case "x^y":
                addToInput("^");
                break;
            case "e^x":
                addToInput("exp(");
                break;
            case "10^x":
                addToInput("10^x(");
                break;
            case "sin":
                addToInput("sin(");
                break;
            case "cos":
                addToInput("cos(");
                break;
            case "tan":
                addToInput("tan(");
                break;
            case "2√x":
                addToInput("2√");
                break;
            case "log":
                addToInput("log(");
                break;
            case "1/x":
                addToInput("1/");
                break;
            case "log10":
                addToInput("log10(");
                break;
            case "mc":
                memoryClear();
                break;
            case "mr":
                memoryRecall();
                break;
            case "ms":
                memoryStore();
                break;
            case "m+":
                memoryAdd();
                break;
            case "m-":
                memorySubtract();
                break;
            case "EE":
                addToInput("E"); // Assuming EE means E (scientific notation)
                break;
            case "x!": // Handle factorial button
                try {
                    double value = Double.parseDouble(textfield.getText());
                    int n = (int) value; // Ensure integer for factorial
                    if (n < 0) {
                        textfield.setText("Error: Factorial not defined for negative numbers");
                    } else {
                        double result = factorial(n);
                        textfield.setText(Double.toString(result));
                    }
                } catch (NumberFormatException ex) {
                    textfield.setText("Invalid input for factorial");
                }
                break;
            default:
                addToInput(command);
                break;
        }



    }



             @Override
    public void addToInput(String s) {
        inputBuffer += s;
        textfield.setText(inputBuffer);
    }

             @Override
    public void addToInput(double d) {
        inputBuffer += d;
        textfield.setText(inputBuffer);
    }
             @Override
    public void evaluateExpression() {
        try {
            String expression = inputBuffer.replaceAll("e\\^", "exp");
            double result = eval(expression);
            textfield.setText(Double.toString(result));
            inputBuffer = "";
        } catch (Exception ex) {
            textfield.setText("Error");
            inputBuffer = "";
        }
    }


             @Override
    public void clearEntry() {
        inputBuffer = "";
        textfield.setText("");
    }

             @Override
    public void memoryClear() {
        memory = 0.0;
    }
             @Override
    public void memoryRecall() {
        addToInput(memory);
    }
             @Override
    public void memoryStore() {
        try {
            memory = Double.parseDouble(textfield.getText());
        } catch (NumberFormatException e) {
            textfield.setText("Invalid Memory Value");
        }
    }
             @Override
    public void memoryAdd() {
        try {
            double value = Double.parseDouble(textfield.getText());
            memory += value;
        } catch (NumberFormatException e) {
            textfield.setText("Invalid Memory Value");
        }
    }
             @Override
    public void memorySubtract() {
        try {
            double value = Double.parseDouble(textfield.getText());
            memory -= value;
        } catch (NumberFormatException e) {
            textfield.setText("Invalid Memory Value");
        }
    }
             @Override
    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else if (eat('%')) x %= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                double x;
                int startPos = this.pos;
                if (eat('+')) {
                    return parseFactor();
                } else if (eat('-')) {
                    return -parseFactor();
                } else if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);

                        x = parseFactor();
                        if (func.equals("squrt")) x = Math.sqrt(x);
                        else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                        else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                        else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                        else if (func.equals("sinh")) x = Math.sinh(x);
                        else if (func.equals("cosh")) x = Math.cosh(x);
                        else if (func.equals("tanh")) x = Math.tanh(x);
                            // else if (func.equals("log")) x = Math.log(x);
                        else if (func.equals("exp")) x = Math.exp(x);
                        else if (func.equals("log")) x = Math.log10(x);
                        else if (func.equals("x^2")) x = Math.pow(x, 2);
                        else if (func.equals("x^3")) x = Math.pow(x, 3);
                        else if (func.equals("1/x")) x = 1 / x;
                        else if (func.equals("x^y")) {
                            eat('^');
                            double y = parseFactor();
                            x = Math.pow(x, y);
                        } else if (func.equals("e^x")) {
                            eat('^');
                            double b = parseFactor();
                            x = Math.pow(Math.E, b);
                        } else if (func.equals("x√y")) {
                            eat('√');
                            double y = parseFactor();
                            x = Math.pow(x, 1.0 / y);
                        } else if (func.equals("mod")) {
                            eat('%');
                            x %= parseFactor();
                        } else if (func.equals("x!")) {
                            int n = (int) x;
                            x = factorial(n);
                        } else throw new RuntimeException("Unknown function: " + func);
                    } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;

            }

        }.parse();
    }







}