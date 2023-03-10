package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Esta clase representa un DTO de sonido que puede reproducir archivos de audio.
 * @author Grupo 
 *
 */
public class SonidoDTO {

	private Clip sound;

	public SonidoDTO() {
	}
	/**
	 * Reproduce un archivo de audio ubicado en la URL dada
	 * @param url la ubicación del archivo de audio que se va a reproducir
	 */

	public void reproducir(String url) {
		try {
			sound = AudioSystem.getClip();
			sound.open(AudioSystem.getAudioInputStream(new File(url)));
			sound.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}

	}
}
