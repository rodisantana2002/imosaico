package com.app;

import com.app.helpers.mensagens.clsPSR;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
        clsPSR.prt(new BCryptPasswordEncoder().encode("12345"));
    }

}
//teste