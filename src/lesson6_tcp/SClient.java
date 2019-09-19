/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class SClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 1107);
            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();
            out.write("hungdn@ptit.edu.vn".getBytes());
            byte[] data = new byte[1024];
            in.read(data);
            System.out.println(new String(data).trim());
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
