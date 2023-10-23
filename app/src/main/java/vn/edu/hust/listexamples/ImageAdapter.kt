package vn.edu.hust.listexamples

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.view.setPadding

class ImageAdapter(val thumbs: ArrayList<Int>): BaseAdapter() {
    override fun getCount(): Int = thumbs.size

    override fun getItem(position: Int): Any = thumbs[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(parent?.context)
        imageView.layoutParams = ViewGroup.LayoutParams(300, 300)
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        imageView.setPadding(4)
        imageView.setImageResource(thumbs[position])
        Log.v("TAG", "getView")
        return imageView
    }
}