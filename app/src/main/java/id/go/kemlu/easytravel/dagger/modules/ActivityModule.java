package id.go.kemlu.easytravel.dagger.modules;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import id.go.kemlu.easytravel.base.BaseActivity;
import id.go.kemlu.easytravel.dagger.ActivityContext;

/**
 * Created by Erick Renata on 05/11/2016.
 */
@Module
public class ActivityModule {

    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity appCompatActivity) {
        this.baseActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    BaseActivity provideActivity() {
        return baseActivity;
    }

    @Provides
    @ActivityContext
    FragmentManager provideFragmentManager() {
        return baseActivity.getBaseFragmentManager();
    }
}
