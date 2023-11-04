/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pt.ipp.estg.ed.ex5;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;
import Exceptions.QueueFullException;

/**
 *
 * @author sssan
 */
public class Ex5 {

    public static void main(String[] args) throws QueueEmptyException, DifferentArraysSizeException, QueueFullException {
        MessageCodificator mc = new MessageCodificator("Tboesp", new int[]{1,1,1,1,1,1});
        
        System.out.println(mc.message.toString());
        System.out.println(mc.message.size());
        System.out.println(mc.MessageDescodifier());
    }
}
