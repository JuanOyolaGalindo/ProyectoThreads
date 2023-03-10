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
		fct = new FrameCaja3(this);
		sd = new SonidoDAO();
		showFr1();
		showFr2();
	}
	
	public void showFr1() {
		fp = new FramePrincipal(this);
		fp.setVisible(false);
	}
	
	public void showFr2() {
		fc = new FrameCaja2(this);
		fc.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sd.click();
		if(arg0.getActionCommand().equals("exit")) {
			System.exit(0);
		}
		if(arg0.getActionCommand().equals("sigto1")) {
			fct.setVisible(false);fp.setVisible(true);
		}
		if(arg0.getActionCommand().equals("sigto2")) {
			fp.setVisible(false);fc.setVisible(true);
		}
		if(arg0.getActionCommand().equals("sigto3")) {
			fc.setVisible(false);fct.setVisible(true);
		}
		if(arg0.getActionCommand().equals("atras1")) {
			fc.setVisible(false);fp.setVisible(true);
		}
		if(arg0.getActionCommand().equals("atras2")) {
			fct.setVisible(false);fc.setVisible(true);
		}
		if(arg0.getActionCommand().equals("atras3")) {
			fp.setVisible(false);fct.setVisible(true);
		}
		if(arg0.getActionCommand().equals("poke")) {
			setN(fp.getNumran());
			
		}
	}
	public void callMethod(String info) {
		fp.crearMenuMovimientos(info);
	}
	
	public int getN() {
		return fp.getNumran();
	}

	public void setN(int n) {
		n = fp.getNumran();
	}
}
