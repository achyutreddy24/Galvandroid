package com.galvandroid.galvandroid;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.galvandroid.galvandroid.Chemistry.HalfReaction;
import com.galvandroid.galvandroid.Chemistry.StandardHalfReactionList;

import java.util.ArrayList;
import java.util.List;

public class SelectHRxnActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<HalfReaction> items;
    private RecyclerView recList;
    private HalfReactionAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hrxn);

        //setHasOptionsMenu(true);

        recList = (RecyclerView) findViewById(R.id.rec_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        StandardHalfReactionList.initialize(this);
        items = StandardHalfReactionList.getHalfreactions();
        ca = new HalfReactionAdapter(items);
        recList.setAdapter(ca);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.halfreaction_list_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<HalfReaction> filteredModelList = filter(items, query);
        ca.animateTo(filteredModelList);
        ca.setItems(filteredModelList);
        recList.scrollToPosition(0);
        return true;
    }

    private List<HalfReaction> filter(List<HalfReaction> items, String query) {
        query = query.toLowerCase();

        final List<HalfReaction> filteredModelList = new ArrayList<>();
        for (HalfReaction hf : items) {
            final String text = hf.toString().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(hf);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
