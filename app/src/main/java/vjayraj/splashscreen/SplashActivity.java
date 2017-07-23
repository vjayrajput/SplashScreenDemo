package vjayraj.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;


public class SplashActivity extends Activity {
    boolean isFinish = false;
    public Runnable mSplashRunnable = new Runnable() {

        @Override
        public void run() {
            isFinish = true;
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    Handler mSplashHandler;
    private int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        TextView tvText = (TextView) findViewById(R.id.txt_appname);
        tvText.setText(getResources().getString(R.string.app_name));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSplashHandler = new Handler();
        mSplashHandler.postDelayed(mSplashRunnable, SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!isFinish) {
            if (mSplashRunnable != null) {
                if (mSplashHandler != null) {
                    mSplashHandler.removeCallbacks(mSplashRunnable);
                }
            }
        }
    }

}
