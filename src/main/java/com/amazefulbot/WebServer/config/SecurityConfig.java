/*
 * Copyright (c) 2020. Amazeful. All rights reserved!
 */

package com.amazefulbot.WebServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  TwitchUserService oAuth2UserService;


    @Autowired
    private TwitchOauthRequestRepository twitchOauthRequestRepository;

    @Bean
    public TwitchOauthRequestRepository cookieAuthorizationRequestRepository() {
        return new TwitchOauthRequestRepository();
    }

//    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
//        DefaultAuthorizationCodeTokenResponseClient oAuth2Client =
//                new DefaultAuthorizationCodeTokenResponseClient();
//
//        OAuth2AccessTokenResponseHttpMessageConverter oAuth2AccessTokenResponseHttpMessageConverter =
//                new OAuth2AccessTokenResponseHttpMessageConverter();
//        oAuth2AccessTokenResponseHttpMessageConverter.setTokenResponseConverter(
//                new TwitchAccessTokenResponseConverter()
//        );
//
//        RestTemplate restTemplate = new RestTemplate(Arrays.asList(
//                new FormHttpMessageConverter(),
//                oAuth2AccessTokenResponseHttpMessageConverter
//        ));
//
//        oAuth2Client.setRestOperations(restTemplate);
//
//        return oAuth2Client;
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionFixation().none().and()
                .exceptionHandling()
                .authenticationEntryPoint(new TwitchAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .antMatchers("/auth/**", "/oauth2/**", "/v1/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login").and()
                .oauth2Login()
                .defaultSuccessUrl("http://localhost:3000/home")
                .authorizationEndpoint()
                .baseUri("/auth")
                .and()
                .redirectionEndpoint()
                .baseUri("/auth/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(oAuth2UserService);


    }
}
