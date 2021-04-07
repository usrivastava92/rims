package com.app.controllers.oauth;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.app.hibernate.entity.masters.UserPo;
import com.app.hibernate.service.BaseService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth/users")
public class UserRestService {

    @Inject
    @Named("baseServiceImpl")
    private BaseService baseServiceImpl;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<UserPo> getAllUsers() {
        return baseServiceImpl.findAll(UserPo.class);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private UserPo getUserById(@PathVariable Long id) {
        return baseServiceImpl.getEntityById(UserPo.class, id);
    }

}