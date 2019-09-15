/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author mam
 */
public class Ex2 {
    public static void main(String[] args) {
        String[] name ={"orange", "lemon", "apple"};
        double[] price = {10.5, 2.5, 5.5};
        
        String file = "C:\\jnp\\2019\\n10\\ex2.bin";
        try (FileInputStream fos = new FileInputStream(file);
                DataInputStream dos = new DataInputStream(fos)) {
            for(int i = 0; i < name.length; i++)
            {
                System.out.println(dos.readDouble() + " - " + dos.readUTF());
            }
        } catch (Exception e) {
            System.out.println("err: " + e.getStackTrace());

        }
    }
}
