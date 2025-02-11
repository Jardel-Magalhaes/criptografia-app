package com.project.criptografiaapp.controller;

import com.project.criptografiaapp.service.CriptografiaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.crypto.SecretKey;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api") // Define o prefixo da URL para todos os endpoints desta classe
public class CriptografiaController {

    private final SecretKey chave;

    public CriptografiaController() throws Exception {
        // Gera uma chave AES ao inicializar o controller
        this.chave = CriptografiaService.gerarChave();
    }

    @PostMapping("/criptografar")
    public ResponseEntity<String> criptografar(@RequestParam String texto) throws Exception {
        // Valida a entrada do usuário
        if (texto == null || texto.isEmpty()) {
            return ResponseEntity.badRequest().body("O texto não pode ser vazio.");
        }

        try {
            // Chama o serviço para criptografar o texto
            String resultado = CriptografiaService.criptografar(texto, chave);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criptografar o texto.");
        }
    }

    @PostMapping("/descriptografar")
    public ResponseEntity<String> descriptografar(@RequestParam String textoCriptografado) throws Exception {
        // Valida a entrada do usuário
        if (textoCriptografado == null || textoCriptografado.isEmpty()) {
            return ResponseEntity.badRequest().body("O texto criptografado não pode ser vazio.");
        }

        try {
            // Chama o serviço para descriptografar o texto
            String resultado = CriptografiaService.descriptografar(textoCriptografado, chave);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao descriptografar o texto.");
        }
    }

}