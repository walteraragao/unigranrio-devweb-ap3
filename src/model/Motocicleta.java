package model;

import model.enums.StatusMotocicletaEnum;

public class Motocicleta {
	
	private Integer codigo;
	private String nomeDono;
	private Integer ano;
	private String modelo;
	private String marca;
	private double preco;
	private StatusMotocicletaEnum status;
	
	public Motocicleta() {
		// TODO Auto-generated constructor stub
	}

	public Motocicleta(Integer codigo, String nomeDono, Integer ano, String modelo, String marca, double preco,
			StatusMotocicletaEnum status) {
		super();
		this.codigo = codigo;
		this.nomeDono = nomeDono;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.preco = preco;
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Motocicleta [codigo=" + codigo + ", nomeDono=" + nomeDono + ", ano=" + ano + ", modelo=" + modelo
				+ ", marca=" + marca + ", preco=" + preco + ", status=" + status + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public StatusMotocicletaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusMotocicletaEnum status) {
		this.status = status;
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
		Motocicleta other = (Motocicleta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
