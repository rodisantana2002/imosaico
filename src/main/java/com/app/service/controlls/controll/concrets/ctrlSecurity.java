package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Usuario;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ctrlSecurity implements UserDetailsService {

    @Autowired
    private ctrlUsuario ctrUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(username);

        Usuario user = new Usuario(username, "");
        user = ctrUser.obterByFilter(user, predEMail).get(0);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getPessoa().getNomecompleto(), user.getSenha(), new ArrayList<>());
    }

}
