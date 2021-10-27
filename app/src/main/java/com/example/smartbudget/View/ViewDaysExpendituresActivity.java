package com.example.smartbudget.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.R;

import java.util.ArrayList;
import java.util.List;

public class ViewDaysExpendituresActivity extends SmartBudgetActivity implements ListItemClickListener{
    private RecyclerView expenditureView;
    private ExpenditureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_days_expenditures);

        Button addExpenditureBtn = findViewById(R.id.add_expenditure);
        addExpenditureBtn.setOnClickListener(v->launchActivity(AddExpenditureActivity.class));


        List<Expenditure> expenditures = new ArrayList<>();
        expenditures.add(new Expenditure(new Category("Rent", 0), "a descriptioin", 4.56f));
        expenditures.add(new Expenditure(new Category("Rent", 0), "Another description", 7.12f));
        expenditures.add(new Expenditure(new Category("Rent", 0), "Another Thing", 20.45f));
        expenditures.add(new Expenditure(new Category("Rent", 0), "Another nother thing", 100f));
        DataCache.getInstance().setCurrExpenditure(expenditures);

        // TODO actual line here, take out dummy data
        //DataCache.getInstance().setCurrExpenditure(new ArrayList<>());

        expenditureView = findViewById(R.id.expenditure_day_view);
        adapter = new ExpenditureAdapter(DataCache.getInstance().getCurrExpenditure(), this);
        expenditureView.setAdapter(adapter);
        expenditureView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.expenditure_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.expenditure_done_btn) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchActivity(Class<?> activityClass){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    @Override
    public void onListItemClick(int position) {
        // TODO edit budget activity
    }
}

class ExpenditureAdapter extends RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder> {
    private List<Expenditure> expenditures;
    private ListItemClickListener listener;

    protected static class ExpenditureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView categoryDisplay;
        public TextView descriptionDisplay;
        public TextView amountDisplay;
        public ListItemClickListener listener;
        public ExpenditureViewHolder(View itemView, ListItemClickListener listener) {
            super(itemView);
            categoryDisplay = itemView.findViewById(R.id.expenditure_category_view);
            descriptionDisplay = itemView.findViewById(R.id.expenditure_description_view);
            amountDisplay = itemView.findViewById(R.id.expenditure_amount_view);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }
    }

    public ExpenditureAdapter(List<Expenditure> expenditures, ListItemClickListener listener) {
        this.expenditures = expenditures;
        this.listener = listener;
    }

    @Override
    public ExpenditureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        View expenditureView = inflator.inflate(R.layout.expenditure_item_detail, parent, false);

        ExpenditureViewHolder v  = new ExpenditureViewHolder(expenditureView, listener);
        return v;
    }

    @Override
    public void onBindViewHolder(ExpenditureViewHolder holder, int position) {
        Expenditure expenditure = expenditures.get(position);
        holder.descriptionDisplay.setText(expenditure.getDescription());
        // TODO format the string of amount
        holder.amountDisplay.setText(String.format("", expenditure.getAmount()));
        // TODO Not sure how to handle this either, but needs a category
        holder.categoryDisplay.setText("Category");
    }

    @Override
    public int getItemCount() {
        return expenditures.size();
    }
}