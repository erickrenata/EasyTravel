package id.go.kemlu.easytravel.ui.activities.register;

import android.os.Bundle;

import butterknife.ButterKnife;
import id.go.kemlu.easytravel.R;
import id.go.kemlu.easytravel.base.BaseActivity;

/**
 * Created by Erick Renata on 06/11/2016.
 */

public class RegisterAct extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}