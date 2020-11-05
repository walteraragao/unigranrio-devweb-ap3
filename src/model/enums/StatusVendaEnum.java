package model.enums;

public enum StatusVendaEnum {
	PENDENTE_DE_PAGAMENTO, PAGAMENTO_APROVADO, PAGAMENTO_RECUSADO, CANCELADO;

	public static StatusVendaEnum buscaEnum(String name) {
		for (StatusVendaEnum obj : StatusVendaEnum.values()) {
			if (obj.name().equalsIgnoreCase(name))
				return obj;
		}
		return null;
	}
}
