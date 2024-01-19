package com.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin() {
        return "Has accedido como ADMIN";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String accessUser() {
        return "Has accedido como USER";
    }

    @GetMapping("/invited")
    @PreAuthorize("hasAnyRole('INVITED','ADMIN')")
    public String accessInvited() {
        return "Has accedido como INVITED";
    }
}
