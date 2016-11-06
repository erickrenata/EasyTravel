package id.go.kemlu.easytravel.listener;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public interface MvpView {
    void onShowLoading();

    void onDismissLoading();

    void onFailed(String message);
}
