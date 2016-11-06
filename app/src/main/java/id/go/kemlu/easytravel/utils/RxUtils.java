package id.go.kemlu.easytravel.utils;

import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import id.go.kemlu.easytravel.EasyTravelApp;
import id.go.kemlu.easytravel.base.BaseResponse;
import id.go.kemlu.easytravel.utils.network.EasyTravelException;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class RxUtils {

    public static <T> Observable.Transformer<T, T> applyScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> applyApiCall() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {

                    Logger.log(throwable);
                    if (throwable instanceof HttpException) {
                        try {
                            HttpException httpException = (HttpException) throwable;
                            String res = httpException.response().errorBody().string();

                            Gson gson = EasyTravelApp.getComponent().gson();
                            BaseResponse baseResponse = gson.fromJson(res, BaseResponse.class);
                            EasyTravelException e = new EasyTravelException(baseResponse, httpException.response().code());
                            return Observable.error(e);

                        } catch (IOException e) {
                            return Observable.empty();
                        }
                    } else
                        return Observable.empty();
                });
    }

    public static void checkMainThread() {
        boolean isMainThread = Looper.myLooper() == Looper.getMainLooper();
        Logger.log(Log.DEBUG, "RX___ Is main thread :" + isMainThread);
    }

}
