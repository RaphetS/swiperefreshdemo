package org.raphets.swiperefreshdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFirst;
    private Button btnSecond;
    private Button btnThird;
    private Button btnFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst= (Button) findViewById(R.id.btn_first);
        btnSecond= (Button) findViewById(R.id.btn_second);
        btnThird= (Button) findViewById(R.id.btn_third);
        btnFourth= (Button) findViewById(R.id.btn_fourth);

        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);
        btnFourth.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_first:
                startActivity(new Intent(MainActivity.this,FirstSwipeActivity.class));
                break;
            case R.id.btn_second:
                startActivity(new Intent(MainActivity.this,SecondSwipeActivity.class));
                break;
            case R.id.btn_third:
                startActivity(new Intent(MainActivity.this,ThirdSwipeActivity.class));
                break;
            case R.id.btn_fourth:
                startActivity(new Intent(MainActivity.this,FourthSwipeAcitivty.class));
                break;
            default:
                break;
        }
    }
}
