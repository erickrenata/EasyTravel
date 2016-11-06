package id.go.kemlu.easytravel.dagger.modules;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import id.go.kemlu.easytravel.constant.Constant;
import id.go.kemlu.easytravel.network.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erick Renata on 05/11/2016.
 */
@Module
public class NetworkModule {

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .serializeNulls()
                        .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.d("Cetun", message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .writeTimeout(25, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request();

                    Request newRequest = request.newBuilder()
//                            .addHeader("Accept", "application/json")
//                            .addHeader("Authorization","Basic NTc2YWNjNDkzNTU0MTA5MDc5ODI2NWFkOk94MXJaeWxRaFd2OGp1UmFmS0JnaUc5YldSbGw4TUo5")
//                            .addHeader("Cache-Control", "no-cache")
//                            .addHeader("Cache-Control", "no-store")
                            .build();

                    return chain.proceed(newRequest);
                }).build();
    }

    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
