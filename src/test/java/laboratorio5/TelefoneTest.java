package laboratorio5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;


public class TelefoneTest {

	private Telefone telefone = new Telefone();
	@Test
	public void testeParaAdicionarContato() {
		Contato contato = new Contato("Contato 1", "123");
		telefone.adicionarContato("Contato 1", "123");
		assertEquals(List.of(contato), telefone.getContatos());
	}
	
	@Test
	public void testeParaRemoverContatoSemContatos() {
		assertThrows(NoSuchElementException.class, () -> telefone.removerContato("123"));
	}
	
	@Test
	public void testeParaRemoverContatoComContatos() {
		telefone.adicionarContato("Contato 1","123");
		telefone.adicionarContato("Contato 2", "456");
		telefone.adicionarContato("Contato 3", "789");
		
		telefone.removerContato("123");
		
		assertEquals(List.of(new Contato("Contato 2", "456"), new Contato("Contato 3", "789")), telefone.getContatos());
	}
	
	@Test
	public void testeParaAdicionarChamadaNaoAtendida() {
		telefone.adicionarChamadaNaoAtendida("456");
		assertEquals(List.of(new Chamada("456")), telefone.getChamadas());
	}
	
	@Test
	public void testeParaRemoverChamadaNaoAtendida() {
		telefone.adicionarContato("Contato 1","123");
		telefone.adicionarChamadaNaoAtendida("123");
		telefone.adicionarChamadaNaoAtendida("456");
		telefone.removerChamadaNaoAtendida();
		assertEquals(List.of(), telefone.getChamadas());
	}
	
	@Test
	public void testeParaMostrarChamadasNaoAtendidas() {
		telefone.adicionarContato("Contato 1","123");
		telefone.adicionarChamadaNaoAtendida("123");
		telefone.adicionarChamadaNaoAtendida("456");
		assertEquals(List.of(new Contato("Contato 1","123"), new Contato("Número desconhecido", "456")), telefone.mostrarChamadasNaoAtendidas());
	}

	@Test
	public void testeParaBuscarNomePorNumero() {
		telefone.adicionarContato("Contato 1","123");
		assertEquals("Contato 1", telefone.buscarNomePorNumero("123"));
	}
	
	@Test
	public void testeParaBuscarNomePorNumeroInexistente() {
		telefone.adicionarContato("Contato 1","123");
		assertThrows(NoSuchElementException.class, () -> telefone.buscarNomePorNumero("456"));
	}
	
}
