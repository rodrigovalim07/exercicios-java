package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private StatusPedido status;
	private Cliente cliente;
	
	private List<ItemDoPedido> itens = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Date agora, StatusPedido status, Cliente cliente) {
		momento = agora;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(ItemDoPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemDoPedido item) {
		itens.remove(item);
	}
	
	public double total() {
		double soma = 0;
		for (ItemDoPedido item : itens) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("INFORMAÇÕES DO PEDIDO:" + "\n");
		sb.append("Momemento do pedido: " + sdf.format(momento) + "\n");
		sb.append("Status do pedido: " + status + "\n");
		sb.append("Cliente: " + cliente + "\n");
		sb.append("ITENS DO PEDIDO:" + "\n");
		for (ItemDoPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Preço total: " + String.format("%.2f", total()));
		return sb.toString();
	}
}
