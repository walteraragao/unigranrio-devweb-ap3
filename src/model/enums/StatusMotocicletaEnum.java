package model.enums;

public enum StatusMotocicletaEnum {
	DISPONIVEL, VENDIDA, INATIVA;

	public static StatusMotocicletaEnum buscaEnum(String name) {
		for (StatusMotocicletaEnum obj : StatusMotocicletaEnum.values()) {
			if (obj.name().equalsIgnoreCase(name))
				return obj;
		}
		return null;
	}
}
