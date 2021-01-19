package com.app.Task.service;

import com.app.Task.data.model.AppUser;
import com.app.Task.data.model.Roles;
import com.app.Task.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser == null){
            throw new UsernameNotFoundException("username not found " + username);
        }

        return new User(appUser.getUsername(), appUser.getPassword(), getAuthorities(appUser.getRoles()));
    }
    public Collection<? extends GrantedAuthority> getAuthorities(List<Roles> authorities){
        return getAuthority(authorities);
    }
    private List<GrantedAuthority> getAuthority(List<Roles> roles){
        return roles.stream().map(role ->
             new SimpleGrantedAuthority(String.valueOf(role))
        ).collect(Collectors.toList());
    }
}
