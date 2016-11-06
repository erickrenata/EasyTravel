package id.go.kemlu.easytravel.base;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import id.go.kemlu.easytravel.EasyTravelApp;
import id.go.kemlu.easytravel.dagger.component.ActivityComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class BaseActivity extends RxAppCompatActivity {

    public FragmentManager getBaseFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

//    public ActivityComponent activityComponent() {
//        return ActivityComponent.Initializer.init(this, EasyTravelApp.getComponent());
//    }

}

