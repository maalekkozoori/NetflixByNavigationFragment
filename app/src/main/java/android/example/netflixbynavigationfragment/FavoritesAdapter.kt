import android.content.Context
import android.example.netflixbynavigationfragment.MoviesInfo
import android.example.netflixbynavigationfragment.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.animation.core.updateTransition
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(private val context: Context, private val list: ArrayList<MoviesInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var imgThumb: ImageView
        var isFavorite: ImageView
        lateinit var itemBackground: LinearLayout


        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            imgThumb = itemView.findViewById(R.id.imgThumb)
            isFavorite = itemView.findViewById(R.id.isFavoritsIcon)
            itemBackground = itemView.findViewById(R.id.linearBackground)

        }

        fun bind(position: Int) {

            tvTitle.text = list[position].title
            imgThumb.setImageResource(list[position].thumbRes)
            itemBackground.setBackgroundResource(list[position].thumbRes)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.favorites_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}