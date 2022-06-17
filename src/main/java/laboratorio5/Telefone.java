package laboratorio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Telefone {

    private List<Contato> contatos = new ArrayList<>();
    private List<Chamada> chamadas = new ArrayList<>();

    Scanner menu = new Scanner(System.in);

    public void adicionarContato(String nome, String numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void removerContato(String numero) {
        final var contatoASerRemovido = buscarContatoPorNumero(numero).orElseThrow();
        contatos.remove(contatoASerRemovido);
    }

    public String buscarNomePorNumero(String numero) {
        return buscarContatoPorNumero(numero).map(Contato::getNome).orElseThrow();
    }

    private Optional<Contato> buscarContatoPorNumero(String numero) {
        return contatos.stream().filter(contato -> contato.getNumero().equals(numero)).findFirst();
    }

    public void adicionarChamadaNaoAtendida(String numero) {
        chamadas.add(new Chamada(numero));
    }

    public List<Contato> mostrarChamadasNaoAtendidas() {
        return chamadas.stream().map(paraContato(contatos)).collect(Collectors.toList());
    }

    private static Function<Chamada, Contato> paraContato(List<Contato> contatos) {
        return chamada ->
                contatos.stream()
                        .filter(contato -> contato.getNumero().equals(chamada.getNumero()))
                        .findFirst()
                        .orElseGet(() -> new Contato("Número desconhecido", chamada.getNumero()));
    }

    public void removerChamadaNaoAtendida() {
        chamadas.clear();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public List<Chamada> getChamadas() {
        return chamadas;
    }
}

