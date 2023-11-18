package com.pazarama.moviepicker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.pazarama.moviepicker.common.NetworkResponse
import com.pazarama.moviepicker.databinding.FragmentHomeBinding
import com.pazarama.moviepicker.ui.home.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment @Inject constructor() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { MoviesAdapter() }

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMovieData("batman")
        initUi()
        observeUi()

    }

    private fun initUi() {
        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager =
            GridLayoutManager(requireContext(), 2)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.getMovieData(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun observeUi() {
        viewModel.movieData.observe(viewLifecycleOwner) { response ->
            when (response) {

                is NetworkResponse.Success -> {
                    response.data.search?.let { data ->
                        adapter.updateCharacters(data)
                        adapter.setOnItemClickListener { id ->
                            val action =
                                HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
                            findNavController().navigate(action)
                        }
                    }
                }

                NetworkResponse.Loading -> {

                }

                is NetworkResponse.Error -> {
                    Toast.makeText(requireContext(), "Server error!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}