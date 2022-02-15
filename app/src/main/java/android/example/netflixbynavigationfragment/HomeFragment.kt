package android.example.netflixbynavigationfragment

import CustomAdapter
import FavoritesAdapter
import android.example.netflixbynavigationfragment.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    val sharedViewModel: MoviesDataBase by viewModels()
    lateinit var customAdapter: CustomAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        trendedMovies()
       /* netflixOriginal()
        popularMovies()
        boxOffice()
        tvSeries()
        indianMovies()
        netflixNews()*/
        binding.imageView3.setOnClickListener {
            println(sharedViewModel.moviesList.filter { it.isFavorite  })
            sharedViewModel.moviesList[0].isFavorite = true
        }

    }

    private fun trendedMovies() {


        customAdapter = CustomAdapter(requireActivity(), ArrayList(sharedViewModel.moviesList.filter { it.category == Category.TREND })) { index ->
            deleteItem(
                index
            )
        }
        binding.rvTrend.adapter = customAdapter
        binding.rvTrend.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        customAdapter.notifyDataSetChanged()


    }


    fun deleteItem(index : Int){
  /*      viewModel.moviesList[index].isFavorite = true
        customAdapter.notifyDataSetChanged()*/
    }

/*

    private fun netflixOriginal() {
        val customAdapter = CustomAdapter(requireActivity(), ArrayList(viewModel.moviesList.filter { it.category == Category.NETFLIX_ORIGINALS }))
        binding.rvNetflixOriginal.adapter = customAdapter
        binding.rvNetflixOriginal.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }


    fun popularMovies() {
        val customAdapter = CustomAdapter(requireActivity(), ArrayList(viewModel.moviesList.filter { it.category == Category.POPULAR }))
        binding.rvPopular.adapter = customAdapter
        binding.rvPopular.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun boxOffice() {

        val customAdapter = CustomAdapter(requireActivity(),  ArrayList(viewModel.moviesList.filter { it.category == Category.BOX_OFFICE }))
        binding.rvBoxOffice.adapter = customAdapter
        binding.rvBoxOffice.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun tvSeries() {

        val customAdapter = CustomAdapter(requireActivity(),  ArrayList(viewModel.moviesList.filter { it.category == Category.TV_SERIES }))
        binding.rvTvSeries.adapter = customAdapter
        binding.rvTvSeries.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun netflixNews() {

        val customAdapter = CustomAdapter(requireActivity(),  ArrayList(viewModel.moviesList.filter { it.category == Category.MOVIE_NEWS }))
        binding.rvNews.adapter = customAdapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun indianMovies() {

        val customAdapter = CustomAdapter(requireActivity(),  ArrayList(viewModel.moviesList.filter { it.category == Category.INDIAN_MOVIES }))
        binding.rvIndianMovies.adapter = customAdapter
        binding.rvIndianMovies.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }





    private fun onListItemClick(position: Int) {
        Toast.makeText(requireContext(), viewModel.moviesList[position].title, Toast.LENGTH_SHORT).show()
    }

*/


}