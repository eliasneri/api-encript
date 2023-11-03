package br.agsi.apyencript.service;

import br.agsi.apyencript.core.ContextCore;
import br.agsi.apyencript.entities.json.ContextEntity;
import br.agsi.apyencript.service.utils.LoadContextJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonService  implements ContextCore {

    @Autowired
    private LoadContextJson loadContextJson;


    @Override
    public ContextEntity context() {
        return loadContextJson.loadContextJson();
    }

    @Override
    public ContextEntity contextDecrypt()  {
        return loadContextJson.loadContextDecrypt();
    }
}
