package com.galvandroid.galvandroid;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galvandroid.galvandroid.Chemistry.HalfReaction;

import java.util.ArrayList;
import java.util.List;

public class HalfReactionAdapter extends RecyclerView.Adapter<HalfReactionAdapter.HalfReactionViewHolder> {
    private List<HalfReaction> hreactionList;

    public HalfReactionAdapter(List<HalfReaction> hreactionList) {
        this.hreactionList = hreactionList;
    }

    public List<HalfReaction> getList() {
        return hreactionList;
    }

    @Override
    public int getItemCount() {
        return hreactionList.size();
    }

    public void setItems(List<HalfReaction> hreactions) {
        hreactionList = new ArrayList<>(hreactions);
    }

    @Override
    public void onBindViewHolder(HalfReactionViewHolder hreactionViewHolder, int i) {
        HalfReaction ci = hreactionList.get(i);
        final HalfReaction hreaction = hreactionList.get(i);
        hreactionViewHolder.text.setText(ci.toString());
        hreactionViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GalvanicCellActivity.class);
                i.putExtra("HalfReaction", hreaction);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public HalfReactionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View hreactionView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.list_hreaction, viewGroup, false);

        return new HalfReactionViewHolder(hreactionView);
    }

    public HalfReaction removeHalfReaction(int position) {
        final HalfReaction hreaction = hreactionList.remove(position);
        notifyItemRemoved(position);
        return hreaction;
    }

    public void addHalfReaction(int position, HalfReaction hreaction) {
        hreactionList.add(position, hreaction);
        notifyItemInserted(position);
    }

    public void moveHalfReaction(int fromPosition, int toPosition) {
        final HalfReaction hreaction = hreactionList.remove(fromPosition);
        hreactionList.add(toPosition, hreaction);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<HalfReaction> hreactions) {
        applyAndAnimateRemovals(hreactions);
        applyAndAnimateAdditions(hreactions);
        applyAndAnimateMovedHalfReactions(hreactions);
    }

    private void applyAndAnimateRemovals(List<HalfReaction> newModels) {
        for (int i = hreactionList.size() - 1; i >= 0; i--) {
            final HalfReaction hreaction = hreactionList.get(i);
            if (!newModels.contains(hreaction)) {
                removeHalfReaction(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<HalfReaction> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final HalfReaction hreaction = newModels.get(i);
            if (!hreactionList.contains(hreaction)) {
                addHalfReaction(i, hreaction);
            }
        }
    }

    private void applyAndAnimateMovedHalfReactions(List<HalfReaction> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final HalfReaction hreaction = newModels.get(toPosition);
            final int fromPosition = hreactionList.indexOf(hreaction);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveHalfReaction(fromPosition, toPosition);
            }
        }
    }

    public static class HalfReactionViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        CardView card;

        public HalfReactionViewHolder(View v) {
            super(v);
            card = (CardView) v.findViewById(R.id.card_view);
            text = (TextView) v.findViewById(R.id.formula);
        }
    }
}
