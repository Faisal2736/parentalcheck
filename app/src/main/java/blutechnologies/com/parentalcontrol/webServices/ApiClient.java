package blutechnologies.com.parentalcontrol.webServices;


import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static final String BASE_URL = "http://parental-control-app.herokuapp.com/api/";
    private static final String TAG = "ApiClient";
    public static Retrofit retrofit = null;


    public static Retrofit getApiClient()

    {


        Log.d(TAG, "getApiClient: is called ");
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;

    }

}
