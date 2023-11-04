/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pt.ipp.estg.ed.ex4;

import Exceptions.DifferentArraysSizeException;
import Exceptions.QueueEmptyException;

/**
 *
 * @author sssan
 */
public class Ex4 {

    public static void main(String[] args) throws QueueEmptyException, DifferentArraysSizeException {
        
        MessageCodificator mc = new MessageCodificator("[g}i%Ihujunume", new int[]{1,2,3,4,5,6,7,8,9,3,5,7,5,4});
        
        System.out.println(mc.codifier.toString());
        System.out.println(mc.MessageDescodifier());
    }
}
