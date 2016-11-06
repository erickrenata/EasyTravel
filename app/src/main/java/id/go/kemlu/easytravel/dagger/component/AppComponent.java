package id.go.kemlu.easytravel.dagger.component;

import android.content.Context;

import com.google.gson.Gson;

import dagger.Component;
import id.go.kemlu.easytravel.base.BasePresenter;
import id.go.kemlu.easytravel.dagger.modules.AppModule;
import id.go.kemlu.easytravel.dagger.modules.NetworkModule;
import id.go.kemlu.easytravel.network.DataManager;

/**
 * Created by Erick Renata on 05/11/2016.
 */
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(BasePresenter basePresenter);

    Gson gson();
    DataManager datamanager();

//    class Initializer {
//        public static AppComponent init(Context context) {
//            return DaggerAppComponent.builder()
//                    .networkModule(new NetworkModule())
//                    .appModule(new AppModule(context))
//                    .build();
//        }
//    }
}