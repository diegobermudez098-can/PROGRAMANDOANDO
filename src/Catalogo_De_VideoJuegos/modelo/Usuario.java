package Catalogo_De_VideoJuegos.modelo;

public class Usuario {

    private int    id;
    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(int id, String username, String password) {
        this.id       = id;
        this.username = username;
        this.password = password;
    }

    public int    getId()       { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setId(int id)             { this.id       = id; }
    public void setUsername(String u)     { this.username = u; }
    public void setPassword(String p)     { this.password = p; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", username='" + username + "'}";
    }
}
