/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ollaberganov-PC
 */
public class UtilServices {
    
    public static String md5(String parol) throws NoSuchAlgorithmException {
        String par = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(parol.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        par = sb.toString();
        return par;
    }
    
}
