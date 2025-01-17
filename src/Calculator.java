import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField inputField;
    private JTextField resultField;


    private double result = 0;
    private String operator = "=";
    private boolean startOfNumber = true;
    public Calculator() {
        setTitle("Calculator");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.PLAIN, 35));// 调整字体大小

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(new Font("Arial", Font.PLAIN, 35)); // 调整字体大小

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(resultField, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(9, 4));

        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");
        addButton(buttonPanel, "÷");
        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");
        addButton(buttonPanel, "*");
        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "0");
        addButton(buttonPanel, ".");
        addButton(buttonPanel, "%");
        addButton(buttonPanel, "+");
        addButton(buttonPanel, "√");
        addButton(buttonPanel, "^");
        addButton(buttonPanel, "ln");
        addButton(buttonPanel, "lg");
        addButton(buttonPanel, "!");
        addButton(buttonPanel, "1/x","|/x");
        addButton(buttonPanel, "sin");
        addButton(buttonPanel, "cos");
        addButton(buttonPanel, "tan");
        addButton(buttonPanel, "asin");
        addButton(buttonPanel, "acos");
        addButton(buttonPanel, "atan");
        addButton(buttonPanel, "e^x");
        addButton(buttonPanel, "π","3.1415926535897932384626433832795");
        addButton(buttonPanel, "e","2.7182818284590452353602874713527");
        addButton(buttonPanel, "|x|");
        addButton(buttonPanel, "10^x","^x");
        addButton(buttonPanel, "=");
        addButton(buttonPanel, "←");
        addButton(buttonPanel, "CE");

        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addButton(Container container, String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 24)); // 调整按钮字体大小
        button.addActionListener(new ButtonClickListener());
        container.add(button);
    }

    private void addButton(Container container, String label ,String actionCommand) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 24)); // 调整按钮字体大小
        button.addActionListener(new ButtonClickListener());
        button.setActionCommand(actionCommand);
        container.add(button);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ('0' <= command.charAt(0) && command.charAt(0) <= '9' || command.equals(".")) {
                if (startOfNumber) {
                    inputField.setText(command);
                    startOfNumber = false;
                } else {
                    inputField.setText(inputField.getText() + command);
                    String output = processString(inputField.getText());
                    inputField.setText(output);
                }
            } else {
                if (startOfNumber) {
                    String buffer = inputField.getText();
                    if (command.equals("-") && buffer.equals("") ) {
                        inputField.setText(command);
                        String output = processString(inputField.getText());
                        inputField.setText(output);
                        startOfNumber = false;
                    } else {
                        operator = command;
                    }
                } else {
                    calculate(Double.parseDouble(inputField.getText()));
                    operator = command;
                    startOfNumber = true;
                }
            }

            if (command.equals("CE")) {
                inputField.setText("");
                resultField.setText("");
                result = 0;
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("√")) {
                result = Math.sqrt(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("ln")) {
                result = Math.log(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("!")) {
                if (result == (long) result && result >= 0) {
                    result = factorial(result);
                    resultField.setText("" + (long)result);
                }else{
                    resultField.setText("Error");
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("lg")) {
                result = Math.log10(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("|/x")) {
                result = 1/result;
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("sin")) {
                result = Math.sin(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("cos")) {
                result = Math.cos(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("tan")) {
                result = Math.tan(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("asin")) {
                result = Math.asin(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("acos")) {
                result = Math.acos(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("atan")) {
                result = Math.log10(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("e^x")) {
                result = Math.exp(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("|x|")) {
                result = Math.abs(result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("^x")) {
                result = Math.pow(10, result);
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
                operator = "=";
                startOfNumber = true;
            }

            if (command.equals("=") || command.equals("√")) {
                if (result == (long) result) {
                    resultField.setText("" + (long)result);
                } else {
                    resultField.setText("" + result);
                }
            }
            if (command.equals("←")){
            String removed = removeLastDigit(inputField.getText());
            inputField.setText(removed);
            result = Double.parseDouble(inputField.getText());
            }
        }

        public String removeLastDigit(String numberString) {
            // Check if the current string length is 1
            if (numberString.length() == 1) {
                numberString = "0";
            } else {
                // Remove the last character from the string
                numberString = numberString.substring(0, numberString.length() - 1);

                // Handle the case where the string ends with a decimal point
                if (numberString.endsWith(".")) {
                    numberString = numberString.substring(0, numberString.length() - 1);
                }

                // Handle the case where the string becomes empty after removing the last character
                if (numberString.isEmpty()) {
                    numberString = "0";
                }
            }
            return numberString;
        }
        public String processString(String input) {
            int firstDotIndex = input.indexOf('.');
            if (firstDotIndex == -1) {
                return input;
            }

            String beforeDot = input.substring(0, firstDotIndex + 1);
            String afterDot = input.substring(firstDotIndex + 1).replace(".", "");

            return beforeDot + afterDot;
        }
        private double factorial(double m) {
            if (m == 0) {
                return 1;
            } else {
                return m * factorial(m - 1);
            }
        }
        private void calculate(double n) {
            switch (operator) {
                case "+":
                    result += n;
                    break;
                case "-":
                    result -= n;
                    break;
                case "*":
                    result *= n;
                    break;
                case "÷":
                    result /= n;
                    break;
                case "=":
                    result = n;
                    break;
                case "%":
                    result %= n;
                    break;
                case "^":
                    result = Math.pow(result, n);
                    break;
                }
            }
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calculator = new Calculator();
                calculator.setVisible(true);
            }
        });
    }
}
