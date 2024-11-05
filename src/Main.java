import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe principal para executar o gerenciamento de frutas com interface gráfica
public class Main {
    public static void main(String[] args) {
        // Cria uma instância do gerenciamento de frutas
        GerenciamentoFrutasImpl gerenciamento = new GerenciamentoFrutasImpl();

        // Configura a janela principal da interface gráfica
        JFrame frame = new JFrame("Gerenciamento de Frutas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        frame.setSize(400, 300); // Define o tamanho da janela

        // Cria os componentes da interface
        JTextField frutaField = new JTextField(20); // Campo de texto para inserir o nome da fruta
        JButton adicionarButton = new JButton("Adicionar Fruta"); // Botão para adicionar fruta
        JButton removerButton = new JButton("Remover Fruta"); // Botão para remover fruta
        JButton listarButton = new JButton("Listar Frutas"); // Botão para listar frutas
        JTextArea textArea = new JTextArea(10, 30); // Área de texto para exibir a lista de frutas
        textArea.setEditable(false); // Define a área de texto como não editável

        // Ação para adicionar uma fruta
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fruta = frutaField.getText(); // Obtém o texto do campo
                if (!fruta.isEmpty()) {
                    gerenciamento.adicionarFruta(fruta); // Adiciona a fruta
                    frutaField.setText(""); // Limpa o campo após adicionar
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira uma fruta."); // Mensagem de erro
                }
            }
        });

        // Ação para remover uma fruta
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fruta = frutaField.getText(); // Obtém o texto do campo
                if (!fruta.isEmpty()) {
                    gerenciamento.removerFruta(fruta); // Remove a fruta
       frutaField.setText(""); // Limpa o campo após remover
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira uma fruta para remover."); // Mensagem de erro
                }
            }
        });

        // Ação para listar as frutas
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Limpa a área de texto antes de listar
                if (gerenciamento.frutas.isEmpty()) {
                    textArea.append("Nenhuma fruta cadastrada.\n"); // Mensagem se não houver frutas
                } else {
                    textArea.append("Lista de frutas:\n"); // Cabeçalho da lista
                    for (String fruta : gerenciamento.frutas) {
                        textArea.append("- " + fruta + "\n"); // Adiciona cada fruta à lista
                    }
                }
            }
        });

        // Cria um painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.add(frutaField); // Adiciona o campo de texto
        panel.add(adicionarButton); // Adiciona o botão de adicionar
        panel.add(removerButton); // Adiciona o botão de remover
        panel.add(listarButton); // Adiciona o botão de listar
        panel.add(new JScrollPane(textArea)); // Adiciona a área de texto com rolagem

        // Adiciona o painel à janela e a torna visível
        frame.getContentPane().add(panel);
        frame.setVisible(true); // Torna a janela visível
    }
}
