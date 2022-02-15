package android.example.netflixbynavigationfragment

import androidx.compose.ui.text.createTextLayoutResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class MoviesDataBase : ViewModel() {



    lateinit var favLiveData: MutableLiveData<Boolean>

   /* var users = arrayListOf(
        Users("maalek","maalek.kozoori","123456",R.drawable.ic_baseline_person_24, ))*/

    var registerStatus = false
    var moviesList = arrayListOf(
        MoviesInfo("Trend1", R.drawable.film10, Category.TREND, false),
        MoviesInfo("Trend2", R.drawable.film11, Category.TREND, true),
        MoviesInfo("Trend3", R.drawable.film12, Category.TREND, false),

        MoviesInfo("Original1", R.drawable.film13, Category.NETFLIX_ORIGINALS, false),
        MoviesInfo("Original2", R.drawable.film14, Category.NETFLIX_ORIGINALS, false),
        MoviesInfo("Original3", R.drawable.film15, Category.NETFLIX_ORIGINALS, false),

        MoviesInfo("Popular1", R.drawable.film16, Category.POPULAR, false),
        MoviesInfo("Popular2", R.drawable.film17, Category.POPULAR, false),
        MoviesInfo("Popular3", R.drawable.film2, Category.POPULAR, false),

        MoviesInfo("Box Office1", R.drawable.film3, Category.BOX_OFFICE,false),
        MoviesInfo("Box Office2", R.drawable.film4, Category.BOX_OFFICE, false),
        MoviesInfo("Box Office3", R.drawable.shaaaa, Category.BOX_OFFICE, false),

        MoviesInfo("Tv Series", R.drawable.film5, Category.TV_SERIES, false),
        MoviesInfo("Tv Series", R.drawable.film6, Category.TV_SERIES, false),
        MoviesInfo("Tv Series", R.drawable.film7, Category.TV_SERIES, false),

        MoviesInfo("Indian", R.drawable.film8, Category.INDIAN_MOVIES, false),
        MoviesInfo("Indian", R.drawable.film9, Category.INDIAN_MOVIES, false),
        MoviesInfo("Indian", R.drawable.film10, Category.INDIAN_MOVIES, false),

        MoviesInfo("News1", R.drawable.film11, Category.MOVIE_NEWS, false),
        MoviesInfo("News1", R.drawable.film12, Category.MOVIE_NEWS, false),
        MoviesInfo("News1", R.drawable.film14, Category.MOVIE_NEWS, false),

        MoviesInfo("Coming Soon1", R.drawable.film7, Category.COMING_SOON, false),
        MoviesInfo("Coming Soon2", R.drawable.film5, Category.COMING_SOON, false),
        MoviesInfo("coming Soon3", R.drawable.film8, Category.COMING_SOON, false),
        MoviesInfo("coming Soon4", R.drawable.film17, Category.COMING_SOON, false)
    )




}