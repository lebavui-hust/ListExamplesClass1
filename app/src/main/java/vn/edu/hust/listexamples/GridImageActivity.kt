package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class GridImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_image)

        val thumbs = arrayListOf<Int>()
        repeat(28) {
            val index = it + 1
            thumbs.add(resources.getIdentifier(
                "thumb$index", "drawable", packageName
            ))
        }

        findViewById<GridView>(R.id.grid_view).adapter = ImageAdapter(thumbs)
    }
}