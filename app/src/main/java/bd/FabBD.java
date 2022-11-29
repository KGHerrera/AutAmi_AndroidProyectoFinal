package bd;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import controladores.FabricanteDAO;
import controladores.UsuarioDAO;
import entidades.Fabricantes;
import entidades.Usuarios;


@Database(entities = {Fabricantes.class, Usuarios.class}, version = 1, exportSchema = false)
public abstract class FabBD extends RoomDatabase {

    public abstract FabricanteDAO fabricanteDAO();
    public abstract UsuarioDAO usuarioDAO();
    private static FabBD INSTANCE;
    public static FabBD getAppDatabase(Context context){
        if(INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FabBD.class, "fab").build();
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
