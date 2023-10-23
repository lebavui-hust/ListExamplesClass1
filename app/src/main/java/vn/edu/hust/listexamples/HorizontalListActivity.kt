package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class HorizontalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_list)

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val index = it + 1
            items.add(ItemModel(
                "Item $index",
                resources.getIdentifier("thumb$index", "drawable", packageName),
                resources.getIdentifier("wall$index", "drawable", packageName)
            ))
        }
        val imageLarge = findViewById<ImageView>(R.id.image_large)
        val layoutItems = findViewById<LinearLayout>(R.id.layout_items)
        repeat(28) {
            val itemView: View = LayoutInflater.from(this)
                .inflate(R.layout.layout_item, layoutItems, false)

            itemView.id = it

            itemView.findViewById<TextView>(R.id.text_caption).text = items[it].caption
            itemView.findViewById<ImageView>(R.id.image_thumb).setImageResource(items[it].imageThumb)

            layoutItems.addView(itemView)

            itemView.setOnClickListener {
                val index = it.id
                imageLarge.setImageResource(items[index].imageLarge)
            }
        }
    }
}