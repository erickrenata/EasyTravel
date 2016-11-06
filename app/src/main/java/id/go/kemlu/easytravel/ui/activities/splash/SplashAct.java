package id.go.kemlu.easytravel.ui.activities.splash;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.go.kemlu.easytravel.R;
import id.go.kemlu.easytravel.permission.AbsRuntimePermission;
import id.go.kemlu.easytravel.ui.activities.login.LoginAct;

/**
 * Created by Erick Renata on 06/11/2016.
 */

public class SplashAct extends AbsRuntimePermission {

    ProgressBar progressBar;
    TextView tvSynchronize;

    public boolean isCancelled = false;
    int progressStatus = 0;
    private Handler handle = new Handler();
    private static final int REQUEST_PERMISSION = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvSynchronize = (TextView) findViewById(R.id.tv_synchronize);

        requestAppPermissions(new String[]{
                        Manifest.permission.CAMERA},
                R.string.msg, REQUEST_PERMISSION);
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        runApp();
    }

    private void runApp() {
        if (!isCancelled) {
            progressStatus = 0;
            new Thread(() -> {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handle.post(() -> {
                        Log.w("progress", String.valueOf(progressStatus));
                        progressBar.setProgress(progressStatus);
                        tvSynchronize.setText("Synchronize... " + progressStatus + " %");
                        if (progressStatus == 100) {
                            startActivity(new Intent(SplashAct.this, LoginAct.class));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            SplashAct.this.finish();
                        }
                    });
                }
            }).start();
        }
    }

    @Override
    public void onBackPressed() {
        isCancelled = true;
        finish();
    }
}
