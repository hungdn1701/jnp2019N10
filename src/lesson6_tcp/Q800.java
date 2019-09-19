/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Q800 {
    public static void main(String[] args) {
        try (Socket c = new Socket("localhost", 1107);
                DataOutputStream out = new DataOutputStream(c.getOutputStream());
                DataInputStream in = new DataInputStream(c.getInputStream())) {
            out.writeUTF("B16DCCN999;800");
            int a = in.readInt();
            int b = in.readInt();
            out.writeInt(a+b);
            out.writeInt(a*b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
