# Projeto de Criptografia  e Descryptografia utilizando a lib Jasypt

#### Definir variavel de ambiente: SECRET_KEY

Repositório Maven

```xml
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>1.9.2</version>
</dependency> 
````

#### Ler um arquivo que configuração .JSON com informações criptografadas e converter em um objeto.
Utilizado para este processo a dependência GSON

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
````

* Java 8 
* SpringBoot 2.7.17
* MySQL 5.7
* HikariCP (pool de conexões)
* localhost:9195/swagger-ui.html

Encrypt de Propriedades:
<strong> application.properties</strong>
```
mysecretpassword= DEC(password)
```
<strong>Execute no terminal:</strong>
```
$ mvn jasypt:encrypt-value -Djasypt.encryptor.password=secretkey
```
Após a execução, a(s propriedade(s) com DEC, serão criptografadas:
```
mysecretpassword= ENC(XwqTvw9e+17bTAqBZ6YN0C9XC/nSjlb79IBGfvnD8gxzeG6DOgQE5OUE6WTc/jzZ)
```
