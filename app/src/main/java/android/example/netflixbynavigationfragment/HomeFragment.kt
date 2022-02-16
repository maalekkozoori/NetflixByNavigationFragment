package android.example.netflixbynavigationfragment

import CustomAdapter
import android.example.netflixbynavigationfragment.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var customAdapter: CustomAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val sharedViewModel = ViewModelProvider(requireActivity()).get(MoviesDataBase::class.java)
        trendedMovies(sharedViewModel)
        netflixOriginal(sharedViewModel)
        popularMovies(sharedViewModel)
        boxOffice(sharedViewModel)
        tvSeries(sharedViewModel)
        indianMovies(sharedViewModel)
        netflixNews(sharedViewModel)
        binding.imageView3.setOnClickListener {
            println(sharedViewModel.moviesList.filter { it.isFavorite })
            sharedViewModel.moviesList[0].isFavorite = true
        }

    }

    private fun trendedMovies(viewModel: MoviesDataBase) {


        val sharedViewModel = ViewModelProvider(requireActivity()).get(MoviesDataBase::class.java)

        customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(sharedViewModel.moviesList.filter { it.category == Category.TREND })
        )
        binding.rvTrend.adapter = customAdapter
        binding.rvTrend.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        customAdapter.notifyDataSetChanged()


    }


    private fun netflixOriginal(viewModel: MoviesDataBase) {
        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.NETFLIX_ORIGINALS })
        )
        binding.rvNetflixOriginal.adapter = customAdapter
        binding.rvNetflixOriginal.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }


    fun popularMovies(viewModel: MoviesDataBase) {
        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.POPULAR })
        )
        binding.rvPopular.adapter = customAdapter
        binding.rvPopular.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun boxOffice(viewModel: MoviesDataBase) {

        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.BOX_OFFICE })
        )
        binding.rvBoxOffice.adapter = customAdapter
        binding.rvBoxOffice.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun tvSeries(viewModel: MoviesDataBase) {

        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.TV_SERIES })
        )
        binding.rvTvSeries.adapter = customAdapter
        binding.rvTvSeries.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun netflixNews(viewModel: MoviesDataBase) {

        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.MOVIE_NEWS })
        )
        binding.rvNews.adapter = customAdapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun indianMovies(viewModel: MoviesDataBase) {

        val customAdapter = CustomAdapter(
            requireActivity(),
            ArrayList(viewModel.moviesList.filter { it.category == Category.INDIAN_MOVIES })
        )
        binding.rvIndianMovies.adapter = customAdapter
        binding.rvIndianMovies.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


}