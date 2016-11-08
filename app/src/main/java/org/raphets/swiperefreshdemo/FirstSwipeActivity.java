package org.raphets.swiperefreshdemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FirstSwipeActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_swipe);

        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.srl);
        mTextView= (TextView) findViewById(R.id.tv);

        mSwipeRefreshLayout.measure(0,0);
        mSwipeRefreshLayout.setRefreshing(true);

        Log.i("getMeasuredWidth",mSwipeRefreshLayout.getMeasuredWidth()+"");

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
}
