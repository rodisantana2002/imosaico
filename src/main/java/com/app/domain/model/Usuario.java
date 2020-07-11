/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.Core;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Core implements UserDetails {

    @JsonIgnore
    private String senha;
    private String token;
    private Boolean superuser;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

    public Usuario() {
        this.pessoa = new Pessoa();
    }

    public Usuario(String email, String senha) {
        BCryptPasswordEncoder cripto = new BCryptPasswordEncoder();
        this.pessoa = new Pessoa();
        this.pessoa.setEmail(email);
        this.senha = cripto.encode(senha);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean isSuperuser() {
        return superuser;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.pessoa.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
