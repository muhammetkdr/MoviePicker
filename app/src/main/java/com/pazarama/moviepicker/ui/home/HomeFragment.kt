package com.pazarama.moviepicker.ui.home

import androidx.fragment.app.viewModels
import com.pazarama.moviepicker.base.BaseFragment
import com.pazarama.moviepicker.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment @Inject constructor() : BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModels<HomeViewModel>()




}