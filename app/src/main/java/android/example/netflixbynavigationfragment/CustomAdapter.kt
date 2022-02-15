import android.content.Context
import android.example.netflixbynavigationfragment.*
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView



class CustomAdapter(private val context: Context, private val list: ArrayList<MoviesInfo>, val onClickAction: (Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var listData : ArrayList<MoviesInfo> = list as ArrayList<MoviesInfo>

     inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView
        var imgThumb : ImageView
        var favoirteIcon : ImageView



        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            imgThumb = itemView.findViewById(R.id.imgTumb)
            favoirteIcon = itemView.findViewById(R.id.favoriteIcon)


       /*     itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }*/

            itemView.setOnClickListener {

                val position = adapterPosition
                if(list[position].isFavorite){
                    favoirteIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    list[position].isFavorite = false

                }else{
                    favoirteIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
                    list[position].isFavorite = true
                    println(list.filter { it.isFavorite })


                }

                //Toast.makeText(context, list[position].title +" "+list[position].isFavorite, Toast.LENGTH_SHORT).show()

            }


            fun getAdapterPosition(): Int{
                return adapterPosition
            }


        }



        fun bind(position: Int) {
            tvTitle.text = list[position].title
            imgThumb.setImageResource(list[position].thumbRes)
            if (list[position].isFavorite){
                favoirteIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            }else{
                favoirteIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItemPosition(index : Int){
        listData[index].isFavorite = true
        notifyDataSetChanged()
    }
}