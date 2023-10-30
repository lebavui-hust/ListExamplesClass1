package vn.edu.hust.listexamples

data class ItemModel(var caption: String, val imageThumb: Int, val imageLarge: Int = 0) {
    var selected: Boolean = false
}
