package org.raphets.swiperefreshdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class FourthSwipeAcitivty extends Activity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTextView;
    private boolean isFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_swipe);

        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.srl);
        mTextView= (TextView) findViewById(R.id.tv);

        ViewTreeObserver viewTreeObserver=mSwipeRefreshLayout.getViewTreeObserver();
        viewTreeObserver.addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean b) {
                if (isFirst){
                    mSwipeRefreshLayout.setRefreshing(true);
                    isFirst=false;
                    Log.i("getMeasuredWidth",mSwipeRefreshLayout.getMeasuredWidth()+"");

                }
            }
        });

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
                        mTextView.setText("fourth-首次进入自动刷新");
                    }
                });

            }
        }.start();
    }
}
