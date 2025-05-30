import javax.swing.JOptionPane;

public class Divisores {
    public static void main(String[] args) {
        // Solicitar entrada do usuário com JOptionPane
        String input = JOptionPane.showInputDialog(null, "Digite um número inteiro positivo:");

        try {
            // Tentar converter a entrada em um número inteiro
            int numero = Integer.parseInt(input);

            // Verificar se o número é positivo
            if (numero <= 0) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro positivo.");
            } else {
                // Encontrar divisores do número
                StringBuilder divisores = new StringBuilder();
                for (int i = 1; i <= numero; i++) {
                    if (numero % i == 0) {
                        if (divisores.length() > 0) {
                            divisores.append(", ");
                        }
                        divisores.append(i);
                    }
                }

                // Exibir os divisores
                JOptionPane.showMessageDialog(null, "Os divisores de " + numero + " são: " + divisores.toString());
            }
        } catch (NumberFormatException e) {
            // Tratamento caso a entrada não seja um número inteiro
            JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, digite um número inteiro.");
        }
    }
}