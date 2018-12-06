package com.github.translocathor.portalsoundboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.translocathor.portalsoundboard.model.Sound;

import java.util.List;

public class SoundsAdapter extends RecyclerView.Adapter<SoundsAdapter.MyViewHolder> {
    private List<Sound> sounds;
    private ItemClickListener itemClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView soundTextView;
        public Button soundButton;
        private ItemClickListener itemClickListener;

        public MyViewHolder(View v, ItemClickListener itemClickListener) {
            super(v);
            this.itemClickListener = itemClickListener;
            v.setOnClickListener(this);
            soundTextView = v.findViewById(R.id.text);
            soundButton = v.findViewById(R.id.button);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SoundsAdapter(List<Sound> myDataset) {
        sounds = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SoundsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sounds_text_item, parent, false);

        //...
        MyViewHolder vh = new MyViewHolder(v, itemClickListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.soundTextView.setText(sounds.get(position).getName());

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sounds.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
