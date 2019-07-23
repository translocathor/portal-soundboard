package com.github.translocathor.portalsoundboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.translocathor.portalsoundboard.model.Sound

class MyAdapter(private val myDataset: List<Sound>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(v: View, var itemClickListener: ItemClickListener) : RecyclerView.ViewHolder(v),
        View.OnClickListener {
        private var view: View = v
        var soundTextView: TextView

        init {
            v.setOnClickListener(this)
            soundTextView = v.findViewById(com.github.translocathor.R.id.text)
        }

        override fun onClick(v: View) {
            itemClickListener.onClick(v, adapterPosition)
        }
    }

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(com.github.translocathor.R.layout.sound_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(textView, itemClickListener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.soundTextView.text = myDataset[position].name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}