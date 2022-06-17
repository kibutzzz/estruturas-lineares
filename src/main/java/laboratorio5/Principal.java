package laboratorio5;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Telefone telefone = new Telefone();
		Scanner menu = new Scanner(System.in);

		while (true) {

			System.out.print("\n----------MENU----------\n");
			System.out.print("1 - Cadastrar contato\n");
			System.out.print("2 - Remover contato\n");
			System.out.print("3 - Cadastrar chamada não atendida\n");
			System.out.print("4 - Mostrar lista de chamadas não atendidas\n");
			System.out.print("5 - Excluir todas chamadas não atendidas\n");
			System.out.print("6 - Sair\n");
			System.out.print("Escolha uma opção: ");

			int opcao = menu.nextInt();
			menu.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o nome do contato a ser adicionado: \n");
				String nomeAdicionado = menu.nextLine();

				System.out.print("Digite o número do contato a ser adicionado: \n");
				String numeroAdicionado = menu.nextLine();

				telefone.adicionarContato(nomeAdicionado, numeroAdicionado);
				break;
				
			case 2:
				System.out.print("Digite o número a ser removido: \n");
				String numeroRemovido = menu.nextLine();

				System.out.println("É esse o contato que deseja apagar? Nome: " + telefone.buscarNomePorNumero(numeroRemovido));
				String confirmacao = menu.nextLine();
				
				if (confirmacao.equalsIgnoreCase("sim")) {
					telefone.removerContato(numeroRemovido);
					System.out.println("Contato apagado com sucesso!.");
				} else {
					System.out.println("Operação cancelada! Tente novamente.");
				}
				break;
				
			case 3:
				System.out.print("Digite o número a ser adicionado: \n");
				String numeroNaoAtendido = menu.nextLine();

				telefone.adicionarChamadaNaoAtendida(numeroNaoAtendido);
				break;
				
			case 4:
				if (!telefone.getChamadas().isEmpty()) {
					System.out.println("Chamadas não atendidas:");
					telefone.mostrarChamadasNaoAtendidas()
						.forEach(contato -> System.out.println(contato.getNome() + "\t" + contato.getNumero()));
				} else {
					System.out.println("Não há chamadas não atendidas.");
				}
				break;
				
			case 5:
				telefone.removerChamadaNaoAtendida();
				break;
				
			case 6:
				menu.close();
				System.exit(0);
				
			default:
				System.out.print("Opção inválida! Tente novamente. \n");
				break;
			}
		}
	}

	

}