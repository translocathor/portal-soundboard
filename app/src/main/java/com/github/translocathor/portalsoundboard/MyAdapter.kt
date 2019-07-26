package com.github.translocathor.portalsoundboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.translocathor.portalsoundboard.model.Sound

class MyAdapter(private val sounds: MutableList<Sound>, private val itemClickListener: SoundViewHolderClickListener) :
    RecyclerView.Adapter<MyAdapter.SoundViewHolder>(), Filterable {

    var soundsFull: List<Sound> = sounds.toMutableList()

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class SoundViewHolder(v: View, var itemClickListener: SoundViewHolderClickListener) : RecyclerView.ViewHolder(v),
        View.OnClickListener {
        private var view: View = v
        var soundTextView: TextView

        init {
            v.setOnClickListener(this)
            soundTextView = v.findViewById(com.github.translocathor.R.id.sound_item_title)
        }

        override fun onClick(v: View) {
            itemClickListener.onClick(v, adapterPosition)
        }

        interface SoundViewHolderClickListener {
            fun onClick(view: View, adapterPosition: Int)
        }
    }

    interface SoundViewHolderClickListener {
        fun onClick(view: View, sound: Sound)
    }

    override fun getFilter(): Filter {

        return object : Filter() {

            override fun performFiltering(charSequence: CharSequence): FilterResults {
                // Contains the filtered sounds
                val filteredList: List<Sound>

                // If no input is given, all items are displayed
                if (charSequence.isEmpty()) {
                    filteredList = soundsFull.toMutableList()
                } else {
                    val searchQuery = charSequence.toString().toLowerCase().trim()
                    filteredList = soundsFull.filter { it.name.toLowerCase().contains(searchQuery) }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                sounds.clear()
                sounds.addAll(filterResults!!.values as MutableList<Sound>)
                notifyDataSetChanged()
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SoundViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(com.github.translocathor.R.layout.sound_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return SoundViewHolder(textView, object : SoundViewHolder.SoundViewHolderClickListener {
            override fun onClick(view: View, adapterPosition: Int) {
                itemClickListener.onClick(view, sounds[adapterPosition])
            }
        })
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.soundTextView.text = sounds[position].name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = sounds.size
}