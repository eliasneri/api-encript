package br.agsi.apyencript.core;

import br.agsi.apyencript.entities.json.ContextEntity;

public interface ConnectionsCore {
    String connectionHikary(ContextEntity context);
    String connectionDataSource(ContextEntity context);
}
