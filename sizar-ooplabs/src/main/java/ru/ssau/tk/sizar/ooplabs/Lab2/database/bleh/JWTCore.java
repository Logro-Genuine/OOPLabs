package ru.ssau.tk.sizar.ooplabs.Lab2.database.bleh;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.ssau.tk.sizar.ooplabs.Lab2.database.config.UserData;

import java.util.Date;

@Component
public class JWTCore {
    @Value("$ru.ssau.tk.sizar.ooplabs.app.secret")
    private String secret;
    @Value("$ru.ssau.tk.sizar.ooplabs.app.lifetime")
    private int lifetime;
    public String generateToken(Authentication authentication){
        UserData userData = (UserData) authentication.getPrincipal();
        return Jwts.builder().setSubject((userData.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
                        .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public String getNameFromJwt(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getPayload().getSubject();
    }
}
