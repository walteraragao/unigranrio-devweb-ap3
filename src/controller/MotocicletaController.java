package controller;

import java.util.List;

import controller.dao.MotocicletaDAO;
import model.Motocicleta;
import model.enums.StatusMotocicletaEnum;

public class MotocicletaController {

	public MotocicletaController() {
		// TODO Auto-generated constructor stub
	}
	
	public void criaMotocicleta(Motocicleta moto) {
		new MotocicletaDAO().insert(moto);
		System.out.println("Motocicleta cadastrada com sucesso");
	}
	
	public void atualiza(Motocicleta moto) {
		new MotocicletaDAO().atualiza(moto);
		System.out.println("Motocicleta atualizada com sucesso");
	}
	
	public List<Motocicleta> buscarTodasDisponiveis() {
		return buscaPorStatus(StatusMotocicletaEnum.DISPONIVEL);
	}
	
	public List<Motocicleta> buscarTodasVendidas() {
		return buscaPorStatus(StatusMotocicletaEnum.VENDIDA);
	}

	public List<Motocicleta> buscaTodasAtivas() {
		return new MotocicletaDAO().buscaTodos();
	}
	
	public List<Motocicleta> buscaPorStatus(StatusMotocicletaEnum status) {
		return new MotocicletaDAO().buscaTodosPorStatus(status);
	}
}
