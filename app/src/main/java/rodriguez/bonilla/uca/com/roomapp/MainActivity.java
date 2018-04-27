package rodriguez.bonilla.uca.com.roomapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rodriguez.bonilla.uca.com.roomapp.Api.PeopleInterface;
import rodriguez.bonilla.uca.com.roomapp.db.AppDatabase;
import rodriguez.bonilla.uca.com.roomapp.models.People;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private final String URL = "http://172.16.29.206:3000/api/";

    RecyclerView recyclerView;
    List<People> listaPeople = new ArrayList<>();
    PeopleInterface peopleInterface;
    PeopleAdapter peopleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        /*AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "api")
                .allowMainThreadQueries()
                .build();

        final List<People> people = appDatabase.peopleDao().getAllPeople();
        peopleAdapter = new PeopleAdapter(people);
        recyclerView.setAdapter(peopleAdapter);*/

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                    .build();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        peopleInterface = retrofit.create(PeopleInterface.class);

        final Call<List<People>> call = peopleInterface.getAllPeople();
        call.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if (response.isSuccessful())
                {
                    deleteDatabase("api");
                    AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "api")
                            .allowMainThreadQueries()
                            .build();

                    listaPeople = response.body();
                    peopleAdapter = new PeopleAdapter(listaPeople);
                    recyclerView.setAdapter(peopleAdapter);
                    peopleAdapter.notifyDataSetChanged();

                   // Log.i("nombre: ", response.body().get(0).getName());

                    for (People people : listaPeople)
                    {
                        appDatabase.peopleDao().insertAll(people);

                    }

                }
            }
            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
                AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "api")
                        .allowMainThreadQueries()
                        .build();

                List<People> people1 = appDatabase.peopleDao().getAllPeople();
                peopleAdapter = new PeopleAdapter(people1);
                recyclerView.setAdapter(peopleAdapter);

            }
        });


    }
}
