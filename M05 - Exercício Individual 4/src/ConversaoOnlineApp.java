import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ConversaoOnlineApp {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/BRL"; // Exemplo de URL
    // Uma string para armazenar a chave da API caso necessário
    // private static final String API_KEY = "sua_chave_api_aqui";

    public ConversaoOnlineApp() {
        JFrame frame = new JFrame("Conversor de Moedas Online");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelValor = new JLabel("Valor em Reais:");
        JTextField textValor = new JTextField();

        JLabel labelMoeda = new JLabel("Converter para:");
        JComboBox<String> comboMoeda = new JComboBox<>(new String[] { "USD", "EUR", "GBP" });

        JButton buttonConverter = new JButton("Converter");
        JLabel labelResultado = new JLabel("Resultado: -");

        panel.add(labelValor);
        panel.add(textValor);

        panel.add(labelMoeda);
        panel.add(comboMoeda);
        panel.add(new JLabel());
        panel.add(buttonConverter);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(labelResultado, BorderLayout.SOUTH);

        buttonConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorReais = Double.parseDouble(textValor.getText());
                    String moedaSelecionada = (String) comboMoeda.getSelectedItem();
                    double taxaConversao = buscarTaxaConversao(moedaSelecionada);

                    if (taxaConversao == 0) {
                        labelResultado.setText("Erro na busca da cotação.");
                    } else {
                        double resultado = valorReais * taxaConversao;
                        labelResultado.setText(String.format("Resultado: %.2f %s", resultado, moedaSelecionada));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um valor numérico válido.",
                            "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private double buscarTaxaConversao(String moeda) {
        try {
            URL url = new URL(API_URL); // Use a chave da API caso necessário
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // Parseando a resposta JSON para obter a taxa de câmbio
            JSONObject json = new JSONObject(content.toString());
            return json.getJSONObject("rates").getDouble(moeda);

        } catch (Exception e) {
            // Trata exceções e retorna zero se houver erro
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversaoOnlineApp());
    }
}