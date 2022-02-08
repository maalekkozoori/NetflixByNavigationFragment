package android.example.netflixbynavigationfragment

import CustomAdapter
import android.example.netflixbynavigationfragment.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    private val viewModel: MoviesDataBase by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        trendedMovies()
        netflixOriginal()
        popularMovies()
        boxOffice()
        tvSeries()
        indianMovies()
        netflixNews()

    }

    private fun trendedMovies() {
        val customAdapter = CustomAdapter(requireActivity(), viewModel.trendMoviesList)
        binding.rvTrend.adapter = customAdapter
        binding.rvTrend.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }


    private fun netflixOriginal() {
        val customAdapter = CustomAdapter(requireActivity(), viewModel.netflixOriginalsMoviesList)
        binding.rvNetflixOriginal.adapter = customAdapter
        binding.rvNetflixOriginal.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }


    fun popularMovies() {
        val customAdapter = CustomAdapter(requireActivity(), viewModel.popularMoviesList)
        binding.rvPopular.adapter = customAdapter
        binding.rvPopular.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun boxOffice() {

        val customAdapter = CustomAdapter(requireActivity(), viewModel.boxOfficeMoviesList)
        binding.rvBoxOffice.adapter = customAdapter
        binding.rvBoxOffice.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun tvSeries() {

        val customAdapter = CustomAdapter(requireActivity(), viewModel.tvSeriesMoviesList)
        binding.rvTvSeries.adapter = customAdapter
        binding.rvTvSeries.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun netflixNews() {

        val customAdapter = CustomAdapter(requireActivity(), viewModel.newsList)
        binding.rvNews.adapter = customAdapter
        binding.rvNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }


    fun indianMovies() {

        val customAdapter = CustomAdapter(requireActivity(), viewModel.indianMoviesList)
        binding.rvIndianMovies.adapter = customAdapter
        binding.rvIndianMovies.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun onListItemClick(position: Int) {
        Toast.makeText(requireContext(), viewModel.trendMoviesList[position].title, Toast.LENGTH_SHORT).show()
    }

}