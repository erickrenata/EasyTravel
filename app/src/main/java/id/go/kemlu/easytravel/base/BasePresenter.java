package id.go.kemlu.easytravel.base;

import android.content.Context;

import javax.inject.Inject;

import id.go.kemlu.easytravel.EasyTravelApp;
import id.go.kemlu.easytravel.listener.MvpView;
import id.go.kemlu.easytravel.network.ApiService;
import id.go.kemlu.easytravel.network.DataManager;

/**
 * Created by Erick Renata on 05/11/2016.
 */
public class BasePresenter {

    @Inject protected Context mContext;
    @Inject protected ApiService mApiService;
    @Inject protected DataManager dataManager;

    private MvpView mvpView;

//    public BasePresenter() {
//        EasyTravelApp.getComponent().inject(this);
//    }

    /* --------------------------------------------------- */
    /* > LifeCycle */
    /* --------------------------------------------------- */

    // TODO must be change to generic type
    public void attachView(MvpView mvpView){
        this.mvpView = mvpView;
    }

    public void detachView(){
        this.mvpView = null;
    }

    @SuppressWarnings("unchecked")
    public <T extends MvpView> T getView(){
        return (T) mvpView;
    }
}
