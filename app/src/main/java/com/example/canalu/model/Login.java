package com.example.canalu.model;

public class Login {

    private String Usuario;
    private String Clave;

    public Login(String usuario, String clave) {
        Usuario = usuario;
        Clave = clave;
    }

    public Login() {
    }

    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }
    public void setClave(String clave) {
        Clave = clave;
    }

    @Override
    public String toString() {
        return "Login{" +
                "Usuario='" + Usuario + '\'' +
                ", Clave='" + Clave + '\'' +
                '}';
    }
}
