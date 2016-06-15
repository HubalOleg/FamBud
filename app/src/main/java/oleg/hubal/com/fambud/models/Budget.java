package oleg.hubal.com.fambud.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.06.2016.
 */
public class Budget {

    private List<Procedure> procedures;
    private int budget, income, consume;

    public Budget(){
        procedures = new ArrayList<>();
        budget = 0;
        income = 0;
        consume = 0;
    }

    public List getProcedures() {
        return procedures;
    }

    public void addProcedure(Procedure procedure) {
        procedures.add(procedure);

        int value = procedure.getValue();
        if(procedure.isIncome()) {
            budget += value;
            income += value;
        } else {
            budget -= value;
            consume += value;
        }
    }

    public int getProcSize() {
        return procedures.size();
    }

    public int getBudget() {
        return budget;
    }
}
