package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoDTO {

	private Clip sound;

	public SonidoDTO() {
	}

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
