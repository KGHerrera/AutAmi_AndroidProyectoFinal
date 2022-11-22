package entidades;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity
public class Fabricantes {
    @NonNull
    @PrimaryKey
    private String idFabricantes;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "direccion")
    private String direccion;

    @NonNull
    @ColumnInfo(name = "telefono")
    private String telefono;

    public Fabricantes(@NonNull String idFabricantes, @NonNull String nombre, @NonNull String direccion, @NonNull String telefono) {
        this.idFabricantes = idFabricantes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @NonNull
    public String getIdFabricantes() {
        return idFabricantes;
    }

    public void setIdFabricantes(@NonNull String idFabricantes) {
        this.idFabricantes = idFabricantes;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NonNull String direccion) {
        this.direccion = direccion;
    }

    @NonNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NonNull String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Fabricantes{" +
                "idFabricantes='" + idFabricantes + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
