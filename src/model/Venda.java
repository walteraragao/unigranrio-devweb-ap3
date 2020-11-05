package model;

import java.util.Date;

import model.enums.StatusVendaEnum;

public class Venda {

	private Integer codigo;
	private Motocicleta motocicleta;
	private Cliente cliente;
	private StatusVendaEnum statusVendaEnum;
	private double subtotal;
	private double desconto;
	private double total;
	private Date dataVenda;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}
	
	public Venda(Integer codigo, Motocicleta motocicleta, Cliente cliente, StatusVendaEnum statusVendaEnum,
			double subtotal, double desconto, double total, Date dataVenda) {
		super();
		this.codigo = codigo;
		this.motocicleta = motocicleta;
		this.cliente = cliente;
		this.statusVendaEnum = statusVendaEnum;
		this.subtotal = subtotal;
		this.desconto = desconto;
		this.total = total;
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", motocicleta=" + motocicleta + ", cliente=" + cliente
				+ ", statusVendaEnum=" + statusVendaEnum + ", subtotal=" + subtotal + ", desconto=" + desconto
				+ ", total=" + total + ", dataVenda=" + dataVenda + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Motocicleta getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(Motocicleta motocicleta) {
		this.motocicleta = motocicleta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatusVendaEnum getStatusVendaEnum() {
		return statusVendaEnum;
	}

	public void setStatusVendaEnum(StatusVendaEnum statusVendaEnum) {
		this.statusVendaEnum = statusVendaEnum;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
