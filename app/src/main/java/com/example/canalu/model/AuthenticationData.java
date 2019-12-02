package com.example.canalu.model;

public final class AuthenticationData {

    // Se declara una variable de tipo singleton y se hace la instacia
    private static AuthenticationData authenticationData;
    private String token;

    // Constructor Privado para que no pueda ser instaciado desde otro lugar
    private AuthenticationData() {

    }

    // Metodo para obtener la instacia
    public static AuthenticationData getInstance() {

        if(authenticationData == null){
            authenticationData = new AuthenticationData();
        }
        return authenticationData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not allowed.");
    }
}
