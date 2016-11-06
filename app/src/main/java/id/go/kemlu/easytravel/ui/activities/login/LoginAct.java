package id.go.kemlu.easytravel.ui.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.go.kemlu.easytravel.R;
import id.go.kemlu.easytravel.base.BaseActivity;
import id.go.kemlu.easytravel.ui.activities.home.HomeAct;
import id.go.kemlu.easytravel.ui.activities.register.RegisterAct;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class LoginAct extends BaseActivity{

    @Bind(R.id.ed_username) EditText edUsername;
    @Bind(R.id.ed_password) EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_forgot_password)
    void btnForgotPasswordClicked(){
        // TODO forgot password
        Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_register)
    void btnRegisterClicked(){
        // TODO register
        startActivity(new Intent(this, RegisterAct.class));
//        Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    void btnLoginClicked(){
        // TODO login
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomeAct.class));
    }
}
