package net.archeryc.vlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void jumpMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void jumpMultiLayou(View view) {
        startActivity(new Intent(this, MultiLayoutActivity.class));
    }

    public void jumpQF(View view) {
        startActivity(new Intent(this, QfLayoutActivity.class));
    }
}
