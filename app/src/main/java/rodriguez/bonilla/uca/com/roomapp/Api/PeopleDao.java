package rodriguez.bonilla.uca.com.roomapp.Api;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rodriguez.bonilla.uca.com.roomapp.models.People;

@Dao
public interface PeopleDao {

    @Query("SELECT * FROM People")
    List<People> getAllPeople();

    @Insert
    void insertAll(People... people);


}
