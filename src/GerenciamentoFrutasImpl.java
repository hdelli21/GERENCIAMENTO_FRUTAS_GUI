import java.util.ArrayList;

// Implementação da interface GerenciamentoFrutas
public class GerenciamentoFrutasImpl implements GerenciamentoFrutas {
    // ArrayList para armazenar as frutas
    ArrayList<String> frutas;

    // Construtor que inicializa a lista de frutas
    public GerenciamentoFrutasImpl() {
        frutas = new ArrayList<>(); // Cria um novo ArrayList para armazenar as frutas
    }

    // Método que adiciona uma fruta à lista
    @Override
    public void adicionarFruta(String fruta) {
        frutas.add(fruta); // Adiciona a fruta ao ArrayList
        System.out.println(fruta + " foi adicionada."); // Mensagem de confirmação
    }

    // Método que remove uma fruta da lista
    @Override
    public void removerFruta(String fruta) {
        // Remove a fruta e verifica se a operação foi bem-sucedida
        if (frutas.remove(fruta)) {
            System.out.println(fruta + " foi removida."); // Mensagem de confirmação
        } else {
            System.out.println(fruta + " não encontrada."); // Mensagem se a fruta não existir
        }
    }

    // Método que lista todas as frutas cadastradas
    @Override
    public void listarFrutas() {
        if (frutas.isEmpty()) {
            System.out.println("Nenhuma fruta cadastrada."); // Mensagem se não houver frutas
        } else {
            System.out.println("Lista de frutas:"); // Cabeçalho da lista
            for (String fruta : frutas) {
                System.out.println("- " + fruta); // Imprime cada fruta na lista
            }
        }
    }
}
