package br.agsi.apyencript.entities.encrypt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncryptEntity {

    @JsonProperty
    private String toEncrypt;

    public EncryptEntity(){
    }

    public EncryptEntity(String toEncrypt){
        this.toEncrypt = toEncrypt;
    }
}
