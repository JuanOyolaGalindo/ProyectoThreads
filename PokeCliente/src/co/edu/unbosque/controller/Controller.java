package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.SonidoDAO;
import co.edu.unbosque.view.FrameCaja2;
import co.edu.unbosque.view.FrameCaja3;
import co.edu.unbosque.view.FramePrincipal;

public class Controller implements ActionListener{
	
	private FramePrincipal fp;
	private FrameCaja2 fc;
	private FrameCaja3 fct;
	private SonidoDAO sd;

	
	public Controller() {
		//fp = new FramePrincipal(this);
		//fc = new FrameCaja2(this);
		fct = new FrameCaja3(this);
		sd = new SonidoDAO();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sd.click();
		
	}
	
	
	
}
