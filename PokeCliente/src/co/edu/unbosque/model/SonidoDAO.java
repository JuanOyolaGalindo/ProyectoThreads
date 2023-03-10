package co.edu.unbosque.model;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * La clase SonidoDAO maneja la l�gica para la reproducci�n de sonidos
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
		 * M�todo que reproduce un sonido al hacer clic en un bot�n
		 */
		public void click() {
			sound.reproducir("src/co/edu/unbosque/util/sounds/click.wav");
		}	
}
