package id.go.kemlu.easytravel.utils;

import id.go.kemlu.easytravel.base.BaseResponse;
import id.go.kemlu.easytravel.constant.Constant;
import id.go.kemlu.easytravel.listener.MvpView;
import id.go.kemlu.easytravel.utils.network.EasyTravelException;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class ErrorHandler {

    public static void handlerErrorPresenter(MvpView mvpView, Throwable throwable) {
        String message = ErrorHandler.handleError(throwable);
        mvpView.onFailed(message);
    }

    public static String handleError(Throwable throwable) {
        Logger.log(throwable);

        if (throwable == null) return Constant.NETWORK_ERROR;
        if (throwable instanceof EasyTravelException) {
            EasyTravelException cetunException = (EasyTravelException) throwable;
            BaseResponse baseResponse = cetunException.getResponse();
            return baseResponse.getMeta().getMessage();
        }

        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            if (httpException.code() == 403) {
                forceLogout();
                return null;
            }
        }
        return Constant.NETWORK_ERROR;
    }

    private static void forceLogout() {
    }
}
