package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

public class PokeDataDAO {
	
	ArrayList<PokeDataDTO>list = new ArrayList<>();
	
	public PokeDataDAO() {
		// TODO Auto-generated constructor stub
		loadFile();
	}
	
	public void loadFile() {
		String content = FileHandler.loadFile("Datos.csv");
		String[] lines = content.split("\n");
		for (String s : lines) {
			if(s.equals(""))
				continue;
			String[] columns = s.split(";");
			list.add(new PokeDataDTO(Integer.parseInt(columns[0]), columns[1], Integer.parseInt(columns[2]), Integer.parseInt(columns[3]), Integer.parseInt(columns[4])));
		}
	}
	
	public String listarUnPokemon(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum()==num) {
				sb.append(
						list.get(i).getNombre()+" "+
						list.get(i).getAtaque()+" "+
						list.get(i).getDefensa()+" "+
						list.get(i).getNivel());
			}
		}
		return sb.toString();
	}
	
	public boolean lista(int num) {
		boolean found = false;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum()==num) {
				found = true;
			}
		}
		return found;
	}
}
