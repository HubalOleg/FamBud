package oleg.hubal.com.fambud.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import oleg.hubal.com.fambud.R;

/**
 * Created by User on 14.06.2016.
 */
public class ProcedureActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isIncome;
    private TextView tvTitle;
    private EditText etName, etAge, etDate, etValue;
    private Button btnAdd;
    private String name, age, date, value;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proc);

        initViews();

        Intent intent = getIntent();
        isIncome = intent.getBooleanExtra("isIncome", true);
        if(isIncome) {
            tvTitle.setText("Income");
        } else {
            tvTitle.setText("Consumption");
        }
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tv_title_text);
        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);
        etDate = (EditText) findViewById(R.id.et_date);
        etValue = (EditText) findViewById(R.id.et_value);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        name = etName.getText().toString();
        age = etAge.getText().toString();
        date = etDate.getText().toString();
        value = etValue.getText().toString();
        if(name.isEmpty() || age.isEmpty() || date.isEmpty() || value.isEmpty()) {
            Toast.makeText(this, "Fill each field", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            intent.putExtra("date", date);
            intent.putExtra("value", value);
            intent.putExtra("isIncome", isIncome);
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
