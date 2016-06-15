package oleg.hubal.com.fambud.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import oleg.hubal.com.fambud.Constants;
import oleg.hubal.com.fambud.R;
import oleg.hubal.com.fambud.list.BudgetAdapter;
import oleg.hubal.com.fambud.models.Budget;
import oleg.hubal.com.fambud.models.Procedure;

/**
 * Created by User on 13.06.2016.
 */
public class ListActivity extends AppCompatActivity {

    private Budget budget;
    private List<Procedure> procedures;
    private RecyclerView procedureRecyclerView;
    private RecyclerView.Adapter procedureAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        budget = new Budget();
        procedures = budget.getProcedures();

        setRecyclerView();
    }

    private void setRecyclerView() {
        procedureRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_AL);
        procedureRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        procedureRecyclerView.setLayoutManager(layoutManager);

        procedureAdapter = new BudgetAdapter(procedures);
        procedureRecyclerView.setAdapter(procedureAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, ProcedureActivity.class);

        switch(item.getItemId()) {
            case R.id.btn_income:
                intent.putExtra("isIncome", true);
                startActivityForResult(intent, Constants.REQUEST_CODE);
                return true;
            case R.id.btn_consum:
                intent.putExtra("isIncome", false);
                startActivityForResult(intent, Constants.REQUEST_CODE);
                return true;
            case R.id.btn_info:
                Toast.makeText(this, "Your balans is: " + budget.getBudget(), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String age = data.getStringExtra("age");
            String date = data.getStringExtra("date");
            int value = Integer.valueOf(data.getStringExtra("value"));
            boolean isIncome = data.getBooleanExtra("isIncome", true);

            budget.addProcedure(new Procedure(name, age, date, value, isIncome));

            procedureAdapter.notifyItemInserted(budget.getProcSize() - 1);
        }
    }
}
