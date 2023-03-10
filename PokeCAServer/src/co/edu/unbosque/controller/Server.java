package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.PokeDataDAO;
/**
 * Controllador del servidor
 * @author Usuario
 *
 */
public class Server extends Thread{
    private Socket socket; 
    private Socket socketR;
    private ServerSocket server; 
    private DataInputStream in;
    private DataOutputStream out;
    private int	port;
    private String addressClient;
    private PokeDataDAO pdao;
  /**
   * constructor del Server
   * @param port
   */
    public Server(int port){ 
    	
    	this.socket=null;
    	this.socketR=null;
    	this.server=null; 
    	this.in=null;
    	this.out=null;
    	this.port=port;
    	this.addressClient=addressClient;
    	pdao = new PokeDataDAO();
    }
    @Override
    /**
     * Metodo para listar los pokemones
     */
    public void run(){

        String line = ""; 
        
        while (!line.equals("Over")) 
        { 
            try
            { 
            	this.server = new ServerSocket(this.port);
    			System.out.println("Server started"); 
    	        System.out.println("Waiting for a client ..."); 
    	        this.socket = server.accept();
    	        System.out.println("Client "+this.socket.getInetAddress()+" connected of port: "+port); 
//    	        if(AttendCustomer.cantHilos<5) {
//    	        	this.socket = server.accept();
//    	        	at = new AttendCustomer(this.socket);
//    	        	t = new Thread(at);
//    	        	t.start();
//    	        	
//    	        	System.out.println("Client "+this.socket.getInetAddress()+" connected of port: "+port); 
//    	        }else {
//    	        	System.out.println("Maximum amount of customers.");
//    	        }
    	        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
            	
            	line = in.readUTF(); 
            	
                System.out.println(line);
                
            	this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
            	
                this.out = new DataOutputStream(socketR.getOutputStream());
                if(pdao.lista(Integer.parseInt(line)) == true) {
                	this.out.writeUTF("Pokemon: "+line+" "+pdao.listarUnPokemon(Integer.parseInt(line)));
                	this.out.close();
                    this.socketR.close();
                    
                    this.in.close();
                    this.server.close();
                }else {
                	this.out.writeUTF("Pokemon not found.");
                	this.out.close();
                    this.socketR.close();
                    
                    this.in.close();
                    this.server.close();
                }
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
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
        
    } 
}
