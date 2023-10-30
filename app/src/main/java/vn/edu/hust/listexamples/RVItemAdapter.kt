package vn.edu.hust.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVItemAdapter(val items: ArrayList<ItemModel>, val listener: ItemClickListener?): RecyclerView.Adapter<RVItemAdapter.RVItemViewHolder>() {
    class RVItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb = itemView.findViewById<ImageView>(R.id.image_thumb)
        val textCaption = itemView.findViewById<TextView>(R.id.text_caption)
        val checkSelected = itemView.findViewById<CheckBox>(R.id.check_selected)

        init {
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_single_item, parent, false)

        return RVItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.textCaption.text = items[position].caption
        holder.checkSelected.isChecked = items[position].selected
    }
}