package br.com.malualves.gestao_vagas.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // classe de configuração - que gerencia a aplicação na hora que é startado
public class ConfiguracaoSegurancao {

    @Bean // indicar que o metodo da classe é usado para definir um objeto ja
          // gerenciadov-> sobreescrita do metodo SecurityFilterChain
          // pelo Spring(->sobreescrever um metodo existente<-)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // desabilitar spring security, acessando o csrf
        http.csrf(csrf -> csrf.disable())
                // authorizeHttpRequests diz quais rotas podem ser acessadas sem autenticacao
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidato/").permitAll().requestMatchers("/empresa/").permitAll();
                    // demais rotas precisa de autenticação
                    auth.anyRequest().authenticated();

                });

        return http.build();

    }

}
