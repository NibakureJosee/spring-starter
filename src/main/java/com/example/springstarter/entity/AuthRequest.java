package com.example.springstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @Getter
    private String username;
    private String password;

    public Object getPassword()
    {
        return password;
    }
}

