package android.example.netflixbynavigationfragment

import ComingSoonAdapter
import android.example.netflixbynavigationfragment.databinding.FragmentComingsoonBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

class ComingSoonFragment :Fragment(R.layout.fragment_comingsoon) {

    lateinit var binding: FragmentComingsoonBinding
    private val viewModel: MoviesDataBase by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentComingsoonBinding.bind(view)


        comingSoonMovieList()

    }

    private fun comingSoonMovieList() {
        val customAdapter = ComingSoonAdapter(requireActivity(), viewModel.comingSoonMoviesList)
        binding.rvComingSoon.adapter = customAdapter
        binding.rvComingSoon.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

}