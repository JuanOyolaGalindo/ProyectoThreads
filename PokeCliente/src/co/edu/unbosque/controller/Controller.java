package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.SonidoDAO;
import co.edu.unbosque.view.FramePrincipal;

public class Controller implements ActionListener{
	
	private FramePrincipal fp;
	private SonidoDAO sd;

	
	public Controller() {
		fp = new FramePrincipal(this);
		sd = new SonidoDAO();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sd.click();
		
	}
	
	
	
}
