package br.agsi.apyencript.service.utils;

import br.agsi.apyencript.entities.json.ContextEntity;
import br.agsi.apyencript.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoadContextJson {

    @Autowired
    private EncryptService service;

    @Value("${context.json}")
    private String pathContext;

    public ContextEntity loadContextJson() {
        ContextEntity contextEntity =  UtilsJson.readJsonFile(pathContext);
        return contextEntity;
    }

    public ContextEntity loadContextDecrypt(){
        ContextEntity contextEntity =  UtilsJson.readJsonFile(pathContext);
            // tratar possíveis exceptions
            assert contextEntity != null;
            contextEntity.setUsername(service.toDescryptStr(contextEntity.getUsername()));
            contextEntity.setPassword(service.toDescryptStr(contextEntity.getPassword()));
            contextEntity.setUrl(service.toDescryptStr(contextEntity.getUrl()));
        return contextEntity;
    }
}
