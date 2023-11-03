package br.agsi.apyencript;

import br.agsi.apyencript.entities.encrypt.EncryptEntity;
import br.agsi.apyencript.entities.json.ContextEntity;
import br.agsi.apyencript.service.EncryptService;
import br.agsi.apyencript.service.utils.UtilsJson;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class ApyEncriptApplication {

	@Autowired
	private EncryptService service;

	public static void main(String[] args) {
		SpringApplication.run(ApyEncriptApplication.class, args);

		// Carrega as configurações do arquivo Json



	}

}
