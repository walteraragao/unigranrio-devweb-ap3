package controller;

import java.util.Date;
import java.util.List;

import controller.dao.ClienteDAO;
import controller.dao.MotocicletaDAO;
import controller.dao.VendaDAO;
import model.Cliente;
import model.Motocicleta;
import model.Venda;
import model.enums.StatusVendaEnum;

public class VendaController {

	public VendaController() {
		// TODO Auto-generated constructor stub
	}
	
	public void efetuaVenda(Integer codigoCliente, Integer codigoMotocicleta) {
		
		Cliente cliente = new ClienteDAO().buscaClientePorCodigo(codigoCliente);
		if(cliente == null)
			throw new RuntimeException("O Cliente Informado não existe.");
		
		Motocicleta moto = new MotocicletaDAO().buscaPorCodigo(codigoMotocicleta);
		if(moto == null)
			throw new RuntimeException("A motocicleta informada não existe.");
		
		double desconto = 0.0;
		
		Venda v = new Venda();
		v.setCliente(cliente);
		v.setMotocicleta(moto);
		v.setDataVenda(new Date());
		v.setDesconto(desconto);
		v.setStatusVendaEnum(StatusVendaEnum.PENDENTE_DE_PAGAMENTO);
		v.setSubtotal(moto.getPreco());
		v.setTotal(moto.getPreco() - desconto);

		new VendaDAO().insert(v);
		System.out.println("Venda Cadastrada Com Sucesso.");
	}
	
	public List<Venda> listaDevendasPorCliente(Integer codigo){
		return new VendaDAO().buscaVendasPorCliente(codigo);
	}
	
	
	public List<Venda> listaDevendasPorMotocicleta(Integer codigo){
		return new VendaDAO().buscaVendasPorMotocicleta(codigo);
	}
}
