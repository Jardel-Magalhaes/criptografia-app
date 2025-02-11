package com.project.criptografiaapp.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class CriptografiaService {

    public static SecretKey gerarChave() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Tamanho da chave (128 bits)
        return keyGen.generateKey();
    }

    public static String criptografar(String texto, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado); // Codifica em Base64
    }

    public static String descriptografar(String textoCriptografado, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoDecodificado = Base64.getDecoder().decode(textoCriptografado); // Decodifica de Base64
        byte[] textoDescriptografado = cipher.doFinal(textoDecodificado);
        return new String(textoDescriptografado);
    }
}