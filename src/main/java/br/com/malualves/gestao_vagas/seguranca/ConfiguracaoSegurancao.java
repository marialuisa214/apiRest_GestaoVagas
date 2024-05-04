package br.com.malualves.gestao_vagas.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // classe de configuração - que gerencia a aplicação na hora que é startado
public class ConfiguracaoSegurancao {

    @Bean // indicar que o metodo da classe é usado para definir um objeto ja gerenciado
          // pelo Spring(->sobreescrever um metodo existente<-)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }

}
