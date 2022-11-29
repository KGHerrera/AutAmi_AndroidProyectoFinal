package controladores;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import entidades.Fabricantes;
import entidades.Usuarios;

@Dao
public interface UsuarioDAO {

    @Insert
    public void agregarUsuario(Usuarios u);

    @Query("SELECT username FROM usuarios WHERE username LIKE :u AND password LIKE :p")
    String verificarUsuario(String u, String p);
}
