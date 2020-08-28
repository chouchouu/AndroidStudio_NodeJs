package api;

import java.util.List;
import java.util.Observable;

import model.Data;
import model.buy;
import model.catagory;
import model.user;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @GET("/api/buy")
    Call<Data> getBuys();
    @GET("/api/loaisanpham/{id}")
    Call<Data> getloaisanpham(@Path("id") String id);
    @GET("/api/catagory")
    Call<List<catagory>> getCatagory();
//    @GET("/api/admin")
//    Call<List<user>> getLogin (@Path("email") String email,
//                               @Path("password") String password);

}
