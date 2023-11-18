package com.pazarama.moviepicker.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pazarama.moviepicker.R
import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.common.setMovieImage
import com.pazarama.moviepicker.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment @Inject constructor() : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getMovieDetails(args.id)

        observeUi()

    }

    private fun observeUi() {
        viewModel.movieDetails.observe(viewLifecycleOwner) { response ->
            when (response) {
                NetworkResponse.Loading -> {
                    loadingView()
                }

                is NetworkResponse.Error -> {
                    errorView()
                    val toast = Toast.makeText(requireContext(), "Server error!", Toast.LENGTH_LONG)
                    toast.show()
                }

                is NetworkResponse.Success -> {
                    binding.imageView.setMovieImage(response.data.poster)
                    binding.titleTextView.text = response.data.title
                    binding.yearTextView.text = response.data.year
                    binding.actorsTextView.text = response.data.actors
                    binding.countryTextView.text = response.data.country
                    binding.directorTextView.text = response.data.director
                    binding.imdbRatingTextView.text = response.data.imdbRating
                    successView()
                }
            }
        }
    }

    private fun successView() {
        binding.progressBar.visibility = View.GONE
        showHideTextViews(View.VISIBLE)
    }

    private fun loadingView() {
        binding.progressBar.visibility = View.VISIBLE
        showHideTextViews(View.GONE)
    }

    private fun errorView() {
        binding.progressBar.visibility = View.GONE
        showHideTextViews(View.GONE)
    }

    private fun showHideTextViews(visibility: Int) {
        binding.imageView.visibility = visibility
        binding.titleTextView.visibility = visibility
        binding.yearTextView.visibility = visibility
        binding.actorsTextView.visibility = visibility
        binding.countryTextView.visibility = visibility
        binding.directorTextView.visibility = visibility
        binding.imdbRatingTextView.visibility = visibility
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}