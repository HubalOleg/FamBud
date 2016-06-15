package oleg.hubal.com.fambud.list;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import oleg.hubal.com.fambud.R;

/**
 * Created by User on 13.06.2016.
 */
public class BudgetViewHolder extends RecyclerView.ViewHolder {

    private CardView procedureCard;

    public TextView tvName, tvAge, tvDate, tvValue;

    public BudgetViewHolder(View itemView) {
        super(itemView);

        procedureCard = (CardView) itemView.findViewById(R.id.procedure_card);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvAge = (TextView) itemView.findViewById(R.id.tv_age);
        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvValue = (TextView) itemView.findViewById(R.id.tv_value);

    }

    public void changeTheme(boolean b) {
        if(!b) {
            procedureCard.setBackgroundColor(Color.rgb(255,130,130));
        } else
            procedureCard.setBackgroundColor(Color.rgb(130,255,130));
    }



}
