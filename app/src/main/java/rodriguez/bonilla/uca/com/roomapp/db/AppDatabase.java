package rodriguez.bonilla.uca.com.roomapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import rodriguez.bonilla.uca.com.roomapp.Api.PeopleDao;
import rodriguez.bonilla.uca.com.roomapp.models.People;

@Database(entities = {People.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PeopleDao peopleDao();
}
