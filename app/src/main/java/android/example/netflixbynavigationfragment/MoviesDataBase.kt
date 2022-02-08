package android.example.netflixbynavigationfragment

import androidx.lifecycle.ViewModel

class MoviesDataBase : ViewModel() {


    var registerStatus = false
    var trendMoviesList = arrayListOf(
    MoviesInfo("Trend1",R.drawable.shaaaa,false),
    MoviesInfo("Trend2",R.drawable.shaaaa,false),
    MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )


    var netflixOriginalsMoviesList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var popularMoviesList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var boxOfficeMoviesList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var tvSeriesMoviesList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var indianMoviesList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var newsList = arrayListOf(
        MoviesInfo("Trend1",R.drawable.shaaaa,false),
        MoviesInfo("Trend2",R.drawable.shaaaa,false),
        MoviesInfo("Trend3",R.drawable.shaaaa,false)
    )

    var comingSoonMoviesList = arrayListOf(
        MoviesInfo("Coming Soon1",R.drawable.shaaaa,false),
        MoviesInfo("Coming Soon2",R.drawable.shaaaa,false),
        MoviesInfo("coming Soon3",R.drawable.shaaaa,false),
        MoviesInfo("coming Soon4",R.drawable.shaaaa,false)
    )





}