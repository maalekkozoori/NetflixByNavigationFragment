package android.example.netflixbynavigationfragment

import CustomAdapter
import FavoritesAdapter
import android.app.Activity
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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FavoritesFragment : Fragment(R.layout.fragment_favorite) {

    lateinit var binding: FragmentFavoriteBinding
    lateinit var customAdapter: FavoritesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        val sharedViewModel = ViewModelProvider(requireActivity()).get(MoviesDataBase::class.java)

        favoritesList(sharedViewModel)

    }




    private fun favoritesList(viewModel : MoviesDataBase) {


        var m = viewModel.moviesList.filter { it.isFavorite }
        customAdapter = FavoritesAdapter(requireContext(),ArrayList(viewModel.moviesList.filter { it.isFavorite }) )
        binding.rvFavorites.adapter = customAdapter
        binding.rvFavorites.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        customAdapter.notifyDataSetChanged()



    }

    fun deleteItem(index: Int) {
        //customAdapter.notifyDataSetChanged()
    }


}


