package id.go.kemlu.easytravel;

import android.app.Application;
import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

import id.go.kemlu.easytravel.dagger.component.AppComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class EasyTravelApp extends Application {

    private static AppComponent mAppComponent;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        setupHawk();
        setupCalligraphy();

//        mAppComponent = AppComponent.Initializer.init(this);
        context = getApplicationContext();
    }

    private void setupHawk() {
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .setLogLevel(LogLevel.NONE)
                .build();
    }

    private void setupCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ProximaNova-Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public static AppComponent getComponent() {
        return mAppComponent;
    }

    public static Context getContext() {
        return context;
    }
}
