package android.example.netflixbynavigationfragment

import ComingSoonAdapter
import android.example.netflixbynavigationfragment.databinding.FragmentComingsoonBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class ComingSoonFragment :Fragment(R.layout.fragment_comingsoon) {

    lateinit var binding: FragmentComingsoonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentComingsoonBinding.bind(view)


        comingSoonMovieList()

    }

    private fun comingSoonMovieList() {

        val sharedViewModel = ViewModelProvider(requireActivity()).get(MoviesDataBase::class.java)
        val customAdapter = ComingSoonAdapter(requireActivity(),  ArrayList(sharedViewModel.moviesList.filter { it.category == Category.COMING_SOON}))
        binding.rvComingSoon.adapter = customAdapter
        binding.rvComingSoon.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

}