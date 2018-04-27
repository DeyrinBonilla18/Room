package rodriguez.bonilla.uca.com.roomapp.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rodriguez.bonilla.uca.com.roomapp.models.People;

public interface PeopleInterface {

    @GET("People")
    Call<List<People>> getAllPeople();
}
