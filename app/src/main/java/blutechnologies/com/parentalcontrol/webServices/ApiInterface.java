package blutechnologies.com.parentalcontrol.webServices;

import blutechnologies.com.parentalcontrol.dataModels.ActivationResponse;
import blutechnologies.com.parentalcontrol.dataModels.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> registerAPI(
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password
    );

    @FormUrlEncoded
    @POST("activation")
    Call<ActivationResponse> activationAPI(
            @Header("Authorization") String token,
            @Field("activation_code") String activation_code
    );
}
