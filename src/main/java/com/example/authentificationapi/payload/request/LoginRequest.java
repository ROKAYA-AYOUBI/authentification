package com.example.authentificationapi.payload.request;


import javax.validation.constraints.NotBlank;
/*
Objet LoginRequest utilisé comme objet de requête pour obtenir le nom d'utilisateur et le mot de passe
  du client.
 */
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

