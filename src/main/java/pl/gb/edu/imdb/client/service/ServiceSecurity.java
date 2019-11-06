package pl.gb.edu.imdb.client.service;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

public class ServiceSecurity {
    static void authenticateService(String user, String password, RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, password));
    }
}
