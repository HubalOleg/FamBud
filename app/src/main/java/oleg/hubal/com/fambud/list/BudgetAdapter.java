package oleg.hubal.com.fambud.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import oleg.hubal.com.fambud.R;
import oleg.hubal.com.fambud.models.Procedure;

/**
 * Created by User on 13.06.2016.
 */
public class BudgetAdapter extends RecyclerView.Adapter<BudgetViewHolder> {

    private List<Procedure> procedures;

    public BudgetAdapter(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public BudgetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.budget_card, parent, false);

        BudgetViewHolder budgetViewHolder = new BudgetViewHolder(v);
        return budgetViewHolder;
    }

    @Override
    public void onBindViewHolder(BudgetViewHolder holder, int position) {
        Procedure procedure = procedures.get(position);
        holder.changeTheme(procedure.isIncome());

        holder.tvName.setText(procedure.getName());
        holder.tvAge.setText(procedure.getAge());
        holder.tvDate.setText(procedure.getDate());
        holder.tvValue.setText((String.valueOf(procedure.getValue())));
    }

    

    @Override
    public int getItemCount() {
        return procedures.size();
    }
}
