package android.example.netflixbynavigationfragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(var context: Activity, private var arrayMoviesInfo: ArrayList<MoviesInfo>) :
    ArrayAdapter<MoviesInfo>(context, R.layout.list_item, arrayMoviesInfo) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item, parent,false)
        val ivTitle = view.findViewById<ImageView>(R.id.imgTumb)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val favoriteIcon = view.findViewById<ImageView>(R.id.favoriteIcon)
        ivTitle.setImageResource(arrayMoviesInfo[position].thumbRes)
        tvTitle.text = arrayMoviesInfo[position].title
        return view
    }
}