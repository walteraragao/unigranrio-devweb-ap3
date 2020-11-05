package view;

import controller.ClienteController;
import controller.MotocicletaController;
import controller.VendaController;
import model.Cliente;
import model.Motocicleta;
import model.enums.StatusMotocicletaEnum;

public class Main {

	public static void main(String[] args) {
		Main.criaCliente();
		Main.atualizaCliente();
		Main.buscaTodosOsClientesCadastrados();
		Main.criaMotocicleta();
		Main.buscaTodasMotocicletas();
		Main.criaVenda();
		Main.buscaVendaPorCliente();
	}

	public static void criaCliente() {
		Cliente cliente = new Cliente(null, "Walter Aragão", "walteracf@gmail.com", "12345678902", "(21) 99456-7756");
		new ClienteController().insertCliente(cliente);
	}

	public static void atualizaCliente() {
		Cliente cliente = new Cliente(1, "Walter Aragão Costa Filho", "walteracf@gmail.com", null, "(21) 99456-7756");
		new ClienteController().atualizaCliente(cliente);
	}

	public static void inativaCliente(Integer codigo) {
		new ClienteController().inativaCliente(codigo);
	}

	public static void buscaTodosOsClientesCadastrados() {
		new ClienteController().buscaTodosOsClientesAtivos().forEach(c -> System.out.println(c.toString()));
	}

	public static void criaMotocicleta() {
		Motocicleta m = new Motocicleta(null, "João Silva", 2020, "CB600F Hornet", "Honda", 23000.00,
				StatusMotocicletaEnum.DISPONIVEL);
		new MotocicletaController().criaMotocicleta(m);
	}
	
	
	public static void buscaTodasMotocicletas() {
		new MotocicletaController().buscarTodasDisponiveis().forEach(m -> System.out.println(m.toString()));
	}
	
	public static void criaVenda() {
		new VendaController().efetuaVenda(1, 1);
	}
	
	public static void buscaVendaPorCliente(){
		new VendaController().listaDevendasPorCliente(1).forEach(v -> System.out.println(v.toString()));
	}
	
	public static void buscaVendaPorMotocicleta(){
		new VendaController().listaDevendasPorMotocicleta(1).forEach(v -> System.out.println(v.toString()));
	}
}
