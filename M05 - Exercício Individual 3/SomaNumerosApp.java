import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SomaNumerosApp {

    public SomaNumerosApp() {
        // Criação do frame principal
        JFrame frame = new JFrame("Soma de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new BorderLayout());

        // Criação do painel de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos de entrada
        JLabel num1Label = new JLabel("Número 1:");
        JTextField num1Field = new JTextField();

        JLabel num2Label = new JLabel("Número 2:");
        JTextField num2Field = new JTextField();

        JButton button = new JButton("Calcular Soma");

        // Adicionando componentes ao painel
        panel.add(num1Label);
        panel.add(num1Field);

        panel.add(num2Label);
        panel.add(num2Field);

        panel.add(new JLabel()); // Espaço vazio no Grid para alinhamento
        panel.add(button);

        // Adicionando o painel ao frame
        frame.add(panel, BorderLayout.CENTER);

        // ActionListener para o botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double soma = num1 + num2;
                    JOptionPane.showMessageDialog(frame, "A soma é: " + soma);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Torna o frame visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SomaNumerosApp());
    }
}