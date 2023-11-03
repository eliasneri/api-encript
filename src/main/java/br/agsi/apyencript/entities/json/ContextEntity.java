/*
    Author: Elias Neri
    Novembro/2023
 */
package br.agsi.apyencript.entities.json;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContextEntity implements Serializable {

    private String name;
    private String auth;
    private String type;
    private String factory;
    private String driverClassName;
    private boolean ignoreExceptionOnPreLoad;
    private int maxActive;
    private int maxIdle;
    private int initialSize;
    private long maxWait;
    private long maxAge;
    private boolean testOnReturn;
    private boolean testWhileIdle;
    private long timeBetweenEvictionRunsMillis;
    private boolean removeAbandoned;
    private boolean logAbandoned;
    private int suspectTimeout;
    private String validationQuery;
    private String closeMethod;
    private String username;
    private String password;
    private String url;

    public ContextEntity(){
    }


}
