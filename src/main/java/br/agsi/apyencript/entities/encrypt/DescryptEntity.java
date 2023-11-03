package br.agsi.apyencript.entities.encrypt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescryptEntity {

    @JsonProperty
    private String descrypt;

    public DescryptEntity(){
    }

    public DescryptEntity(String descrypt){
        this.descrypt = descrypt;
    }
}
