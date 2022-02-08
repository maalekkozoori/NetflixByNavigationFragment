import android.content.Context
import android.example.netflixbynavigationfragment.MoviesInfo
import android.example.netflixbynavigationfragment.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val list: ArrayList<MoviesInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var imgThumb : ImageView
        var favoirteIcon : ImageView

        init {
            tvTitle = itemView.findViewById(R.id.tvComingSoonTitle)
            imgThumb = itemView.findViewById(R.id.imgTumb)
            favoirteIcon = itemView.findViewById(R.id.favoriteIcon)
        }

        fun bind(position: Int) {
            tvTitle.text = list[position].title
            imgThumb.setImageResource(list[position].thumbRes)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}