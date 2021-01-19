package com.app.Task.service.userservice;

import com.app.Task.data.model.AppUser;
import com.app.Task.data.model.Roles;
import com.app.Task.data.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    AppUserRepository appUserRepository;

    public AppUserServiceImpl(BCryptPasswordEncoder encoder, AppUserRepository repository){
        bCryptPasswordEncoder = encoder;
        appUserRepository = repository;
    }
    @Override
    public void encryptPassword(AppUser user) {
        user.setRoles(List.of(Roles.ROLE_USER));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }
}
