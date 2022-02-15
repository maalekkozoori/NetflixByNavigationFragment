package android.example.netflixbynavigationfragment

import CustomAdapter
import FavoritesAdapter
import android.content.Context
import android.example.netflixbynavigationfragment.databinding.FragmentFavoriteBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FavoritesFragment : Fragment(R.layout.fragment_favorite) {

    lateinit var binding: FragmentFavoriteBinding
    val sharedViewModel: MoviesDataBase by activityViewModels()
    lateinit var customAdapter: CustomAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)




        println(sharedViewModel.moviesList.filter { it.isFavorite })


        favoritesList(ArrayList(sharedViewModel.moviesList.filter { it.isFavorite }))



    }




    private fun favoritesList(list : ArrayList<MoviesInfo>) {

//        var m = viewModel.moviesList.filter { it.isFavorite }
        customAdapter = CustomAdapter(requireContext(), list , {index -> deleteItem(index)})
        binding.rvFavorites.adapter = customAdapter
        binding.rvFavorites.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        customAdapter.notifyDataSetChanged()



    }

    fun deleteItem(index: Int) {
        //customAdapter.notifyDataSetChanged()
    }


}


