import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MensagemApp {

    public static void criarEExibirGUI() {
        // Cria o frame da aplicação
        JFrame frame = new JFrame("Aplicação de Mensagens");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Cria os botões
        JButton botao1 = new JButton("Mensagem 1");
        JButton botao2 = new JButton("Mensagem 2");
        JButton botao3 = new JButton("Mensagem 3");

        // Adiciona os botões ao frame
        frame.add(botao1);
        frame.add(botao2);
        frame.add(botao3);

        // Adiciona ActionListeners para cada botão
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Você pressionou o Botão 1! Aqui está uma mensagem interessante: Lembre-se sempre de fazer backups dos seus dados!");
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Você pressionou o Botão 2! Dica interessante: Beber água regularmente é essencial para a saúde!");
            }
        });

        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Você pressionou o Botão 3! Curiosidade: O golfinho é um dos poucos animais que usa ferramentas!");
            }
        });

        // Torna o frame visível
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Executa a criação da GUI na thread de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                criarEExibirGUI();
            }
        });
    }
}