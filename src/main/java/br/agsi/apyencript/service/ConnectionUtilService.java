package br.agsi.apyencript.service;

import br.agsi.apyencript.core.ConnectionsCore;
import br.agsi.apyencript.entities.json.ContextEntity;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class ConnectionUtilService implements ConnectionsCore {

    @Autowired
    private JsonService js;

    @Override
    public String connectionHikary(ContextEntity context) {
        HikariConfig config = new HikariConfig();
            config.setUsername(context.getUsername());
            config.setPassword(context.getPassword());
            config.setJdbcUrl(context.getUrl());
        HikariDataSource ds = new HikariDataSource(config);

        try {
            ds.getConnection();
            return "Conectado ao banco de dados! " + context.getUrl();
        } catch (SQLException e) {
            e.printStackTrace();
            return "não conectado!";
        } finally {
            ds.close();
        }
    }

    @Override
    public String connectionDataSource(ContextEntity context){
        DataSource ds = DataSourceBuilder.create()
                .username(context.getUsername())
                .password(context.getPassword())
                .url(context.getUrl())
                .driverClassName(context.getDriverClassName())
                .build();

        try {
            ds.getConnection();
            return "Conectado ao banco de dados via DATASOURCE! " + context.getUrl();
        } catch (SQLException e) {
            e.printStackTrace();
            return "não conectado (DATASOURCE) !";
        } finally {
            try {
                ds.getConnection().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



