package id.go.kemlu.easytravel.dagger.component;

import dagger.Component;
import id.go.kemlu.easytravel.base.BaseActivity;
import id.go.kemlu.easytravel.dagger.ActivityContext;
import id.go.kemlu.easytravel.dagger.modules.ActivityModule;
import id.go.kemlu.easytravel.dagger.modules.FragmentModule;
import id.go.kemlu.easytravel.dagger.modules.PresenterModule;

/**
 * Created by Erick Renata on 05/11/2016.
 */
@ActivityContext
@Component(modules = {
        FragmentModule.class, PresenterModule.class, ActivityModule.class
}, dependencies = AppComponent.class)
public interface ActivityComponent {

//    void inject(HomeAct homeAct);
//
//    class Initializer {
//        public static ActivityComponent init(BaseActivity baseActivity, AppComponent appComponent) {
//            return DaggerActivityComponent.builder()
//                    .fragmentModule(new FragmentModule())
//                    .presenterModule(new PresenterModule())
//                    .activityModule(new ActivityModule(baseActivity))
//                    .appComponent(appComponent)
//                    .build();
//        }
//    }
}
