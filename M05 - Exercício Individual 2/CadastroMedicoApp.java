import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class CadastroMedicoApp {

    public CadastroMedicoApp() {
        // Criação do frame principal
        JFrame frame = new JFrame("Cadastro de Médico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Criação do painel de cadastro
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Define margens de 10px ao redor do painel

        // Campos do formulário
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel especialidadeLabel = new JLabel("Especialidade:");
        JTextField especialidadeField = new JTextField();

        JLabel crmLabel = new JLabel("CRM:");
        JTextField crmField = new JTextField();

        JButton button = new JButton("Cadastrar");

        // Adicionando componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);

        panel.add(especialidadeLabel);
        panel.add(especialidadeField);

        panel.add(crmLabel);
        panel.add(crmField);

        panel.add(new JLabel()); // Espaço vazio no Grid para alinhamento
        panel.add(button);

        // Adicionando o painel ao frame
        frame.add(panel, BorderLayout.CENTER);

        // ActionListener para o botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                JOptionPane.showMessageDialog(frame, "Médico cadastrado: " + nome);
            }
        });

        // Torna o frame visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroMedicoApp());
    }
}