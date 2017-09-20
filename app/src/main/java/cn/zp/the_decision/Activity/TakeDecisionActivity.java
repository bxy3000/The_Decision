package cn.zp.the_decision.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import cn.zp.the_decision.Common.Constants;
import cn.zp.the_decision.R;
import info.hoang8f.widget.FButton;

public class TakeDecisionActivity extends Activity implements View.OnClickListener {

    private FButton btnControl;
    private TextView tvOptionsShow;
    private DecideThread mThread;
    private boolean isDeciding = false;
    private Handler mHandler = new Handler(){
        Random random = new Random();

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    Log.d("Handle msg","case 0");
                    tvOptionsShow.setText(Constants.DEFAULT_OPTION_NAMES[random.nextInt(Constants
                            .DEFAULT_OPTION_NAMES.length)]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_decision);

        btnControl = findViewById(R.id.btn_control);
        tvOptionsShow = findViewById(R.id.tv_options_show);
        btnControl.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_control:
                if(isDeciding == false){
                    mThread = null;
                    mThread = new DecideThread();
                    mThread.start();
                    isDeciding = true;
                    btnControl.setText("停止");
                }else {
                    isDeciding = false;
                    btnControl.setText("开始");
                }
                break;
        }

    }

    private class DecideThread extends Thread{

        @Override
        public void run() {
            while (isDeciding){
                try {
                    sleep(50);
                    mHandler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
