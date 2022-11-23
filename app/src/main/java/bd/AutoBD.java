package bd;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import controladores.FabricanteDAO;
import entidades.Fabricantes;


@Database(entities = {Fabricantes.class}, version = 1, exportSchema = false)
public abstract class AutoBD extends RoomDatabase {

    public abstract FabricanteDAO fabricanteDAO();
    private static AutoBD INSTANCE;
    public static AutoBD getAppDatabase(Context context){
        if(INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AutoBD.class, "autos").build();
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}

