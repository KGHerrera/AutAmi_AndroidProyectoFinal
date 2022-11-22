package controladores;

import androidx.room.*;

import java.util.List;

import entidades.Fabricantes;

@Dao
public interface FabricanteDAO {
    //Altas-----------------------------------------------------------------------------
    @Insert
    public void agregarAlumno(Fabricantes f); //agreagr UN SOLO alumno

    @Insert
    public void agregarAlumnos(Fabricantes... fabricantes); //agregar MUCHOS alumnos

    //Bajas-----------------------------------------------------------------------------
    @Delete
    void delete(Fabricantes f); //borrar sin SQL

    @Query("DELETE FROM fabricantes WHERE idFabricantes = :idf")  //borrar con SQL
    void eliminarPorNumeroDeControl(String idf);

    //Cambios -----------------------------------------------------------------------------
    @Query("UPDATE fabricantes SET nombre= :n, direccion= :d, telefono= :t WHERE idFabricantes = :idf")
    void modificarPorNumeroDeControl(String n, String d, String t, String idf);

    //Consultas-----------------------------------------------------------------------------
    @Query("SELECT * FROM fabricantes")
    List<Fabricantes> obtenerTodos();

    @Query("SELECT * FROM fabricantes WHERE idFabricantes LIKE :idf")
    Fabricantes findByNumControl(String idf);
}
