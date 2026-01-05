package udemy.aplicacion.dto;

public class LoginResponse {

    private int id;
    private String username;
    private String nombre;

    public LoginResponse(int id, String username, String nombre) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }
}
