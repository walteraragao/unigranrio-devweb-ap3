package controller;

import java.util.List;

import controller.dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

	public ClienteController() {
		// TODO Auto-generated constructor stub
	}

	public void insertCliente(Cliente cli) {
		ClienteDAO dao = new ClienteDAO();
		dao.insert(cli);

		System.out.println("Cliente Cadastrado Com Sucesso.");
	}

	public void atualizaCliente(Cliente cli) {
		ClienteDAO dao = new ClienteDAO();
		dao.atualiza(cli);
		System.out.println("Cliente Atualizado Com Sucesso.");
	}

	public void inativaCliente(Integer codigo) {
		ClienteDAO dao = new ClienteDAO();
		dao.inativa(codigo);
		System.out.println("Cliente Inativado Com Sucesso.");
	}

	public List<Cliente> buscaTodosOsClientesAtivos() {
		return new ClienteDAO().buscaTodosOsClientesCadastrados();
	}

	public Cliente buscaClientePorCodigo(Integer codigoCliente) {
		return new ClienteDAO().buscaClientePorCodigo(codigoCliente);
	}

}
