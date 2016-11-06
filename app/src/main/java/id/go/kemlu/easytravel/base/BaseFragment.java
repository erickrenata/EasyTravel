package id.go.kemlu.easytravel.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class BaseFragment extends RxFragment {

    protected Activity mContext;
    protected LayoutInflater mInflater;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        mInflater = LayoutInflater.from(activity);
    }
}
