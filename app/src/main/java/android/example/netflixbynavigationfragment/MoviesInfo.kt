package android.example.netflixbynavigationfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class MoviesInfo(
    var title: String,
    var thumbRes: Int,
    var category: Category,
    var isFavorite : Boolean)