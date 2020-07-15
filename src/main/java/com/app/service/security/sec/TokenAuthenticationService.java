package com.app.service.security.sec;

import com.app.helpers.excecoes.excAcessDeniedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Collections;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class TokenAuthenticationService {

    // EXPIRATION_TIME = 10 dias
    static final long EXPIRATION_TIME = 800_000_000;
    static final String SECRET = "RodolfoSantanaMaisFodaQueNunca";
    static final String TOKEN_PREFIX = "Token";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        String user;

        if (token != null) {
            // faz parse do token
            try {
                user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                }

            } catch (SignatureException e) {
                throw new excAcessDeniedException("Token com assinatura inválida");
            } catch (MalformedJwtException e) {
                throw new excAcessDeniedException("Token não esta com o formato válido");
            } catch (ExpiredJwtException e) {
                throw new excAcessDeniedException("Token expirou");
            } catch (UnsupportedJwtException e) {
                throw new excAcessDeniedException("Token não é suportado");
            } catch (IllegalArgumentException e) {
                throw new excAcessDeniedException("Token com argumentos inválidos");
            }

        }
        return null;
    }

}
