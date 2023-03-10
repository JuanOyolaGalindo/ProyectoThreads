package co.edu.unbosque.model;


public class PokeDataDTO {
	
	private int num;
	private String nombre;
	private int nivel;
	private int ataque;
	private int defensa;
	
	public PokeDataDTO(int num, String nombre, int nivel, int ataque, int defensa) {
		super();
		this.num = num;
		this.nombre = nombre;
		this.nivel = nivel;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
}
