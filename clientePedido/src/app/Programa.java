package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemDoPedido;
import entidades.Pedido;
import entidades.Produto;
import enums.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		System.out.println("Entre com os dados do cliente");
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		System.out.print("Email: ");
		String email = teclado.nextLine();
		System.out.print("Data de nascimento: ");
		Date nascimento = sdf.parse(teclado.next());
		teclado.nextLine();
		Cliente cliente = new Cliente(nome, email, nascimento);
		
		System.out.println("Dados do pedido");
		System.out.print("Status do pedido: ");
		String status = teclado.nextLine();
		
		Pedido pedido = new Pedido(new Date(), StatusPedido.valueOf(status), cliente);
		
		System.out.print("Quantos itens terá seu pedido? ");
		int n = teclado.nextInt();
		teclado.nextLine();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Item Nº%d:%n", i + 1);
			System.out.print("Nome do produto: ");
			String nomep = teclado.nextLine();
			System.out.print("Preço do produto: ");
			double preco = teclado.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = teclado.nextInt();
			teclado.nextLine();
			Produto produto = new Produto(nomep, preco);
			ItemDoPedido item = new ItemDoPedido(quantidade, preco, produto);
			pedido.addItem(item);
		}
		
		System.out.println();
		System.out.print(pedido);
		
		teclado.close();
	}

}
