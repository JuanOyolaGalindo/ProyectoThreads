package co.edu.unbosque.model;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * La clase SonidoDAO maneja la lógica para la reproducción de sonidos
 * @author Grupo
 *
 */
public class SonidoDAO {

		JFileChooser chooser;
		FileNameExtensionFilter filter;
		SonidoDTO sound;
	/**
	 * Constructor de la clase SonidoDAO
	 */
		public SonidoDAO() {
			sound = new SonidoDTO();
		}
		/**
		 * Método que reproduce un sonido al hacer clic en un botón
		 */
		public void click() {
			sound.reproducir("src/co/edu/unbosque/util/sounds/click.wav");
		}	
}
