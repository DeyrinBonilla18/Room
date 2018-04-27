package rodriguez.bonilla.uca.com.roomapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class People {


    public People(String name, String gender, String preferencia) {

        this.name = name;
        this.gender = gender;
        this.preferencia = preferencia;
    }


    //Variables
    @PrimaryKey(autoGenerate = true)
    @Expose
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    @Expose
    private String gender;

    @SerializedName("preferencia")
    @ColumnInfo(name = "preferencia")
    @Expose
    private String preferencia;


    //Metodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
