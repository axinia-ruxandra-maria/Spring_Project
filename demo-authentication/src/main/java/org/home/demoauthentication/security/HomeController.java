package org.home.demoauthentication.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/login")
    public Principal home(Principal principal) {
        return principal;
    }

    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}

