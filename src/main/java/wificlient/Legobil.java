package wificlient;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Legobil {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Legobil(String host, int port) throws Exception {
        try {
            clientSocket = new Socket(host, port);
            clientSocket.setSoTimeout(20000);

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            throw e;
        }
    }

    public void send(String msg) throws Exception {
        try {
           this.out.println(msg);
        } catch (Exception e) {
            throw e;
        }
    }

    public String read() throws Exception {
        try {
            return this.in.readLine(); 
        } catch (Exception e) {
            throw e;
        }
    }

    public void disconnect() throws Exception {
        try {
            this.in.close();
            this.out.close();
            this.clientSocket.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
