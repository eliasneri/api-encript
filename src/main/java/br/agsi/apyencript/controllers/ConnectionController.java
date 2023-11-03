package br.agsi.apyencript.controllers;

import br.agsi.apyencript.service.ConnectionUtilService;
import br.agsi.apyencript.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conn")
public class ConnectionController {

    @Autowired
    private ConnectionUtilService connectionUtil;

    @Autowired
    private JsonService jsonService;

    @GetMapping
    public ResponseEntity<String> connectionHikary(){
        try {
            return ResponseEntity.ok(connectionUtil.connectionHikary(jsonService.contextDecrypt()) + " Hikary");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro! Hikary" + e.toString());
        }
    }

    @GetMapping("/datasource")
    public ResponseEntity<String> connectionDataSource(){
        try {
            return ResponseEntity.ok(connectionUtil.connectionDataSource(jsonService.contextDecrypt()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro!" + e.toString());
        }
    }
}
