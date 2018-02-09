package victor.proyectofinal;

/**
 * Created by Victor on 05/02/2016.
 */
public class Usuario {
    String usuario;

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(String usuario, String pass) {
        this.usuario=usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}




