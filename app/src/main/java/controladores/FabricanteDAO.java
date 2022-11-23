package controladores;

import androidx.room.*;

import java.util.List;

import entidades.Fabricantes;

@Dao
public interface FabricanteDAO {
    //Altas-----------------------------------------------------------------------------
    @Insert
    public void agregarFabricante(Fabricantes f); //agreagr UN SOLO alumno

    @Insert
    public void agregarFabricantes(Fabricantes... fabricantes); //agregar MUCHOS alumnos

    //Bajas-----------------------------------------------------------------------------
    @Delete
    void delete(Fabricantes f); //borrar sin SQL

    @Query("DELETE FROM fabricantes WHERE idFabricantes = :idf")  //borrar con SQL
    int eliminarPorIdFrabricante(int idf);

    //Cambios -----------------------------------------------------------------------------
    @Query("UPDATE fabricantes SET nombre= :n, direccion= :d, telefono= :t WHERE idFabricantes = :idf")
    int modificarPorIdFabricante(String n, String d, String t, int idf);

    //Consultas-----------------------------------------------------------------------------

    @Query("SELECT * FROM fabricantes WHERE idFabricantes LIKE :id AND " +
            "nombre LIKE :n AND " + "direccion LIKE :d AND " + "telefono LIKE :t")
    List<Fabricantes> obtenerConsulta(int id, String n, String d, String t);

    @Query("SELECT * FROM fabricantes")
    List<Fabricantes> obtenerTodos();

    @Query("SELECT * FROM fabricantes WHERE idFabricantes LIKE :idf")
    Fabricantes findByIdFabricante(int idf);
}
