package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Thread{
    private Socket socket;
    private ServerSocket server; 
    private DataOutputStream out;
    private DataInputStream in; 
    private String address;
    private int port;
    private Controller c;
  
    public Client(String address, int port){ 
        this.socket= null;
        this.server=null;
        this.out= null;
        this.address=address;
        this.port=port;
        c = new Controller();
    }
    
    @Override
    public void run() {
    	
        String line = ""; 
  
        while (!line.equals("Over")) 
        { 
        	try
            { 
        		this.socket = new Socket(this.address, this.port); 
                System.out.println("Connected"); 
            
                this.out = new DataOutputStream(socket.getOutputStream()); 
        		
                line=c.getN()+"";
                this.out.writeUTF(line);
                this.out.close(); 
                this.socket.close(); 
                
                this.server = new ServerSocket(this.port+1);
    	        this.socket = server.accept(); 
    	        System.out.println("Received message:"); 
    	        
    	        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    	        
                System.out.println(in.readUTF());
                c.callMethod(line);
                this.in.close();
                this.server.close();
            } 
            catch(IOException i) 
            { 
                System.out.println(i);
                i.printStackTrace();
                System.exit(0);
            } 
        } 
        
        try
        { 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    	
    }
}
