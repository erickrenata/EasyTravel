package id.go.kemlu.easytravel.utils.network;

import id.go.kemlu.easytravel.base.BaseResponse;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class EasyTravelException extends Exception {

    private final int mResponseCode;
    private final BaseResponse mBaseResponse;

    public EasyTravelException(BaseResponse baseResponse, int responseCode) {
        this.mBaseResponse = baseResponse;
        this.mResponseCode = responseCode;
    }

    public BaseResponse getResponse() {
        return mBaseResponse;
    }

    public int getResponseCode() {
        return mResponseCode;
    }
}

