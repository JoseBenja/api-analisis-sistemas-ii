package umg.edu.analisis_ii.sistema_votaciones.security;

public class AuthenticationResponse {
    private String jwt;
    private String nombre;
    private String rol;
    private String nombreCompleto;

    public AuthenticationResponse(String jwt, String nombre, String rol, String nombreCompleto){
        this.nombre = nombre;
        this.jwt = jwt;
        this.rol = rol;
        this.nombreCompleto = nombreCompleto;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }
}
