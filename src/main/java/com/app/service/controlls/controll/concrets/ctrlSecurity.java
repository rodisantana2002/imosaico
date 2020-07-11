package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ctrlSecurity implements UserDetailsService {

    @Autowired
    private ctrlUsuario ctrUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = ctrUser.obterByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuaŕio não foi encontrado ou não esta correto: " + username);
        }
        return user;
    }
}
