package com.ironman.lijiangang.programmersocial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv=(TextView) this.findViewById(R.id.tv);


        tv.setText("i love u,android!");


        //这是1

        //这是本地测试2

        //这是本地测试3

    }
}
