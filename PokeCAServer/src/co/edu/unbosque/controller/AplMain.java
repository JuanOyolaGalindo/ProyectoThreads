package co.edu.unbosque.controller;
/**
 * Aqui se inicia el servidor
 * @author Grupo
 *
 */
public class AplMain {
	public static void main(String[] args) {
		Server server = new Server(5000);
    	server.start();
	}
}
