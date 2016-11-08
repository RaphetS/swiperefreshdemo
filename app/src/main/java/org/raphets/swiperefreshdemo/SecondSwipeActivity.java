package org.raphets.swiperefreshdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.TextView;

public class SecondSwipeActivity extends Activity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextView;
    private boolean isFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_swipe);

        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.srl);
        mTextView= (TextView) findViewById(R.id.tv);

        getData();
    }

    private void getData() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                        mTextView.setText("first-首次进入自动刷新");
                    }
                });

            }
        }.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (isFirst){
            mSwipeRefreshLayout.setRefreshing(true);
            isFirst=false;
            Log.i("getMeasuredWidth",mSwipeRefreshLayout.getMeasuredWidth()+"");

        }

    }
}
