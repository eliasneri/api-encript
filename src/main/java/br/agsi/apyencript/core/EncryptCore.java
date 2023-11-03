package br.agsi.apyencript.core;

import br.agsi.apyencript.entities.encrypt.DescryptEntity;
import br.agsi.apyencript.entities.encrypt.EncryptEntity;

public interface EncryptCore {
    EncryptEntity toEncrypt (String toEncrypt);
    DescryptEntity toDescrypt (String toDescrypt);
    String toDescryptStr (String toDescrypt);
}
