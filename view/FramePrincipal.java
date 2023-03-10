package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import co.edu.unbosque.controller.Controller;

public class FramePrincipal extends JFrame{
	
	private JPanel panel1;
	private JButton atrasbut;
	private JButton sigbut;
	private JButton[][] pokemones;
	private JButton salirbut;
	
	public FramePrincipal(ActionListener listener) {
		this.setSize(800, 600);
		pokemones = new JButton[5][6];	
		this.setLayout(null);
		
		this.setLocationRelativeTo(null);
		this.panel1 = crearPanel1();
		panel1.setBounds(0,0,160,100);
		this.add(panel1);
		JLayeredPane panelCaja = ponerComponentes(listener);
		panelCaja.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.add(panelCaja);
	}
	
	
	
	public JPanel crearPanel1() {
		JLabel nompokemon = new JLabel("Nombre del pokemon");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		nompokemon.setBounds(35,0,150,150);
		panel.add(nompokemon);	
		return panel;		
	}
	public JLayeredPane ponerComponentes(ActionListener listener) {
		ImageIcon imageicon = new ImageIcon("src/co/edu/unbosque/util/images/Caja1.jpg");
		ImageIcon img = new ImageIcon("src/co/edu/unbosque/util/images/Entrenador.gif");
		atrasbut = new JButton();
		sigbut = new JButton();
		salirbut = new JButton("Salir");
		salirbut.setFont(new Font("Arial", Font.PLAIN, 15));
		JLabel entrenador = new JLabel(img);
		JLabel fondo = new JLabel(imageicon);
		JLabel numcaja = new JLabel("Caja 1");
		JLayeredPane panelcapas = new JLayeredPane();
		JPanel panelpokemones = crearMenuPokemones(listener);
		JPanel panelInfoPokemon = crearMenuMovimientos("", "", "", "");
		panelpokemones.setOpaque(false);
		atrasbut.setContentAreaFilled(false);	
		atrasbut.setFocusPainted(false);
		atrasbut.setBorderPainted(false);
		atrasbut.addActionListener(listener);
		atrasbut.setActionCommand("atras3");
		sigbut.addActionListener(listener);
		sigbut.setContentAreaFilled(false);
		sigbut.setBorderPainted(false);
		sigbut.setActionCommand("sigto2");
		salirbut.addActionListener(listener);
		salirbut.setActionCommand("exit");
		panelcapas.setLayout(null);
		numcaja.setFont(new Font("Arial", Font.PLAIN, 25));
		salirbut.setBounds(665,500, 110,40);
		panelpokemones.setBounds(225, 125, 550, 350);
		panelInfoPokemon.setBounds(0, 345, 200, 185);
		numcaja.setBounds(465, 25, 100, 50);
		fondo.setBounds(200, 0, 600,550);
		entrenador.setBounds(-10, 125, 235, 225);
		atrasbut.setBounds(205, 12, 70, 80);
		sigbut.setBounds(720, 12, 70, 80);
		panelcapas.add(fondo, Integer.valueOf(0));
		panelcapas.add(entrenador,Integer.valueOf(0));
		panelcapas.add(salirbut, Integer.valueOf(1));
		panelcapas.add(panelpokemones, Integer.valueOf(1));
		panelcapas.add(atrasbut,Integer.valueOf(1));
		panelcapas.add(sigbut,Integer.valueOf(1));
		panelcapas.add(numcaja,Integer.valueOf(1));
		panelcapas.add(panelInfoPokemon,Integer.valueOf(1));
		return panelcapas;
	}
	int numran=1;
	public JPanel crearMenuPokemones(ActionListener listener) {			
		JPanel panel = new JPanel();
		Random random = new Random();
		panel.setLayout(new GridLayout(5, 6));
		 for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 6; j++) {
	            	setNumran(random.nextInt(50)+1);
	            	ImageIcon pokemon = new ImageIcon("src/co/edu/unbosque/util/images/pkmn/pkmn/"+ numran +".gif");
	            
	                JButton boton = new JButton();	              
	                boton.setOpaque(false);
	                boton.setContentAreaFilled(false);
	                boton.setBorderPainted(false);
	                boton.setFocusPainted(false);
	                boton.setIcon(pokemon);
	                boton.addActionListener(listener);
	                boton.setActionCommand("pokemon");
	               
	                pokemones[i][j] = boton;
	                panel.add(boton);
	            }
	        }
		 return panel;
	}
	public JPanel crearMenuMovimientos(String nom,String niv,String ataq,String def) {
		JLabel tipo,nivel,objeto,movimiento;
		tipo = new JLabel("Tipo de pokemon: "+nom);
		nivel = new JLabel("Nivel del pokemon: "+niv);
		objeto = new JLabel("Ataque: "+ataq);
		movimiento = new JLabel("Defensa: "+def);
		JPanel panel = new JPanel();
		tipo.setFont(new Font("Arial", Font.PLAIN, 20));
		nivel.setFont(new Font("Arial", Font.PLAIN, 20));
		objeto.setFont(new Font("Arial", Font.PLAIN, 20));
		movimiento.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.setLayout(new GridLayout(4,1));
		panel.add(nivel);
		panel.add(tipo);
		panel.add(movimiento);
		panel.add(objeto);
		return panel;
		
	}

	public int getNumran() {
		return numran;
	}

	public void setNumran(int numran) {
		this.numran = numran;
	}
	
}
