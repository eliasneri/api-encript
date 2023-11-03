package br.agsi.apyencript.controllers;

import br.agsi.apyencript.entities.json.ContextEntity;
import br.agsi.apyencript.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private JsonService service;

    @GetMapping("/load")
    public ResponseEntity<ContextEntity> context(){
        try {
            return ResponseEntity.ok(service.context());
        } catch (RuntimeException e) {
            // lançar exception personalizada
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ContextEntity());
        }
    }

    @GetMapping("/load/descrypt")
    public ResponseEntity<ContextEntity> contextDescrypt() {
        try {
            return ResponseEntity.ok(service.contextDecrypt());
        } catch (RuntimeException e) {
            // lançar exception personalizada
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ContextEntity());
        }

    }

}
