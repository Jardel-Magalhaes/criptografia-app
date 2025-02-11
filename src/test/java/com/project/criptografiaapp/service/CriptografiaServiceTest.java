package com.project.criptografiaapp.service;

import org.junit.jupiter.api.Test;
import javax.crypto.SecretKey;
import static org.junit.jupiter.api.Assertions.*;

public class CriptografiaServiceTest {

    @Test
    public void testCriptografiaDescriptografia() throws Exception {
        SecretKey chave = CriptografiaService.gerarChave();
        String textoOriginal = "Texto secreto";

        String textoCriptografado = CriptografiaService.criptografar(textoOriginal, chave);
        String textoDescriptografado = CriptografiaService.descriptografar(textoCriptografado, chave);

        assertEquals(textoOriginal, textoDescriptografado);
    }
}