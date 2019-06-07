package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION = "jp.ac.titech.itpro.sdl.startservice.BROADCAST";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        Intent sentIntent = new Intent(Service3.ACTION);
        sentIntent.putExtra(EXTRA_MYARG, "✌('ω'✌ )三✌('ω')✌三( ✌'ω')✌");
        try {
            Thread.sleep(5000); // 5 sec
            Log.d(TAG, "Send broadcast at " + sentIntent.getAction());
            sendBroadcast(sentIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}
