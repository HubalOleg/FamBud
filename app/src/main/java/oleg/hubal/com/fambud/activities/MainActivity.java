package oleg.hubal.com.fambud.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import oleg.hubal.com.fambud.R;
import oleg.hubal.com.fambud.models.Budget;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOpenApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnOpenApp = (Button) findViewById(R.id.btn_openlist_AM);

        btnOpenApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_openlist_AM:
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
