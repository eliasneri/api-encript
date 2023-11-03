package br.agsi.apyencript.core;

import br.agsi.apyencript.entities.json.ContextEntity;

public interface ContextCore {
    ContextEntity context();
    ContextEntity contextDecrypt();
}
