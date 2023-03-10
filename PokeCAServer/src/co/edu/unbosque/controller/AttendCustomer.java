package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.PokeDataDAO;

public class AttendCustomer implements Runnable{
	
	    private Socket socket; 
	    private Socket socketR;
	    private ServerSocket server; 
	    private DataInputStream in;
	    private DataOutputStream out;
	    private int	port;
	    private String addressClient;
	    private PokeDataDAO pdao;
	    public static int cantHilos = 0;
	    
	public AttendCustomer(Socket cliente) {
		cantHilos++;
		socket=cliente;
    	this.socketR=null;
    	this.server=null; 
    	this.in=null;
    	this.out=null;
    	this.port=port;
    	this.addressClient=addressClient;
	}

	@Override
	public void run() {
		String line = "";
		try {
			this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
        	
        	line = in.readUTF(); 
        	
            System.out.println(line);
            
        	this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
        	
            this.out = new DataOutputStream(socketR.getOutputStream());
//            if(pdao.lista(line) == true) {
//            	this.out.writeUTF("Pokemon: "+line+" "+pdao.listarUnPokemon(line));
//            	this.out.close();
//                this.socketR.close();
//                
//                this.in.close();
//                this.server.close();
//            }else {
//            	this.out.writeUTF("Pokemon not found.");
//            	this.out.close();
//                this.socketR.close();
//                
//                this.in.close();
//                this.server.close();
//            }
		}catch (Exception e) {
            System.out.println(e); 
		}
		System.out.println("Closing connection"); 

        // close connection 
        try {
			socket.close();
			in.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cantHilos--;
	}
}
