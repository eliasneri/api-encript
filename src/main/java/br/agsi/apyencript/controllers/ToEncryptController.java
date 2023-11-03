package br.agsi.apyencript.controllers;

import br.agsi.apyencript.entities.encrypt.DescryptEntity;
import br.agsi.apyencript.entities.encrypt.EncryptEntity;
import br.agsi.apyencript.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypt")
public class ToEncryptController {

    @Autowired
    private EncryptService service;

    @RequestMapping(value = "/encrypter", method = RequestMethod.POST)
    public ResponseEntity<EncryptEntity> toEncrypt (@RequestBody EncryptEntity encrypt){
        try{
            return ResponseEntity.ok(service.toEncrypt(encrypt.getToEncrypt()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EncryptEntity("Erro ao Criptografar"));
        }
    }

    @RequestMapping(value = "/descrypter", method = RequestMethod.POST)
    public ResponseEntity<DescryptEntity> toDescrypt (@RequestBody DescryptEntity descrypt){
        return ResponseEntity.ok(service.toDescrypt(descrypt.getDescrypt()));

    }


}
