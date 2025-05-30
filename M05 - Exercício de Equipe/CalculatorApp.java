import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {

    // Variáveis para armazenar os números e o operador atual
    private double num1;
    private double num2;
    private char operator;

    // Componentes
    private JTextField display;

    public CalculatorApp() {
        // Criação do frame principal
        JFrame frame = new JFrame("Calc2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // Criação do painel de visualização
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(display, BorderLayout.NORTH);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setPreferredSize(new Dimension(frame.getWidth(), 50));

        // Criação do painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Adicionando botões ao painel
        String[] buttons = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "/", "=", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            buttonsPanel.add(button);
        }

        // Adicionando o painel de botões ao frame
        frame.add(buttonsPanel, BorderLayout.CENTER);

        // Tornando o frame visível
        frame.setVisible(true);
    }

    // ActionListener para botões
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();

            switch (command) {
                case "C": // Limpa
                    display.setText("");
                    num1 = 0;
                    num2 = 0;
                    operator = '\0';
                    break;
                case "+":
                case "-":
                case "*":
                case "/": // Operadores
                    num1 = Double.parseDouble(display.getText());
                    operator = command.charAt(0);
                    display.setText("");
                    break;
                case "=": // Calcula o resultado
                    num2 = Double.parseDouble(display.getText());
                    double result = computeResult(num1, num2, operator);
                    display.setText(Double.toString(result));
                    break;
                default: // Números
                    display.setText(display.getText() + command);
                    break;
            }
        }
    }

    // Método para computar o resultado
    private double computeResult(double n1, double n2, char op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n2 != 0 ? n1 / n2 : 0; // Evita divisão por zero
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}