package br.agsi.apyencript.service;

import br.agsi.apyencript.core.EncryptCore;
import br.agsi.apyencript.entities.encrypt.DescryptEntity;
import br.agsi.apyencript.entities.encrypt.EncryptEntity;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptService implements EncryptCore {

    @Value("${secretkey}")
    private String property;

    @Override
    public EncryptEntity toEncrypt (String toEncrypt){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPasswordCharArray(property.toCharArray());
        return new EncryptEntity(encryptor.encrypt(toEncrypt));
    }

    @Override
    public DescryptEntity toDescrypt (String toDescrypt){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPasswordCharArray(property.toCharArray());
        try {
            return new DescryptEntity(encryptor.decrypt(toDescrypt));
        } catch (Exception e){
            return new DescryptEntity("secretKey Error!");
        }
    }

    @Override
    public String toDescryptStr (String toDescrypt){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPasswordCharArray(property.toCharArray());
        return encryptor.decrypt(toDescrypt);
    }
}
