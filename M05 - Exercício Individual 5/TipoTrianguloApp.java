import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipoTrianguloApp {

    public TipoTrianguloApp() {
        JFrame frame = new JFrame("Tipo de Triângulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lado1Label = new JLabel("Lado 1:");
        JTextField lado1Field = new JTextField();

        JLabel lado2Label = new JLabel("Lado 2:");
        JTextField lado2Field = new JTextField();

        JLabel lado3Label = new JLabel("Lado 3:");
        JTextField lado3Field = new JTextField();

        JButton buttonCheck = new JButton("Verificar");

        JLabel resultLabel = new JLabel("Resultado: -");

        panel.add(lado1Label);
        panel.add(lado1Field);

        panel.add(lado2Label);
        panel.add(lado2Field);

        panel.add(lado3Label);
        panel.add(lado3Field);

        panel.add(new JLabel());
        panel.add(buttonCheck);

        panel.add(resultLabel);
        panel.add(new JLabel());

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    double lado1 = Double.parseDouble(lado1Field.getText());
                    double lado2 = Double.parseDouble(lado2Field.getText());
                    double lado3 = Double.parseDouble(lado3Field.getText());

                    if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
                        g.setColor(Color.BLUE);

                        int padding = 50;
                        double scaleFactor = Math.min(
                                (getWidth() - 2 * padding) / Math.max(Math.max(lado1, lado2), lado3),
                                (getHeight() - 2 * padding) / Math.max(Math.max(lado1, lado2), lado3));

                        int x1 = padding;
                        int y1 = getHeight() - padding;

                        int x2 = padding + (int) (lado1 * scaleFactor);
                        int y2 = getHeight() - padding;

                        double angulo = Math
                                .acos((lado1 * lado1 + lado2 * lado2 - lado3 * lado3) / (2 * lado1 * lado2));
                        int x3 = padding + (int) (lado2 * scaleFactor * Math.cos(angulo));
                        int y3 = getHeight() - padding - (int) (lado2 * scaleFactor * Math.sin(angulo));

                        int[] xPoints = { x1, x2, x3 };
                        int[] yPoints = { y1, y2, y3 };

                        g.drawPolygon(xPoints, yPoints, 3);
                    }
                } catch (NumberFormatException ex) {
                    g.clearRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        buttonCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double lado1 = Double.parseDouble(lado1Field.getText());
                    double lado2 = Double.parseDouble(lado2Field.getText());
                    double lado3 = Double.parseDouble(lado3Field.getText());

                    if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
                        if (lado1 == lado2 && lado2 == lado3) {
                            resultLabel.setText("Resultado: Equilátero");
                        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                            resultLabel.setText("Resultado: Isósceles");
                        } else {
                            resultLabel.setText("Resultado: Escaleno");
                        }
                        drawingPanel.repaint();
                    } else {
                        resultLabel.setText("Medidas não formam um triângulo válido");
                        drawingPanel.repaint();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos.",
                            "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(drawingPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TipoTrianguloApp());
    }
}