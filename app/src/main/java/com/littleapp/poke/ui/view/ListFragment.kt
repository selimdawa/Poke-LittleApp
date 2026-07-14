package com.littleapp.poke.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.littleapp.poke.R
import com.littleapp.poke.databinding.FragmentListPokeBinding
import com.littleapp.poke.ui.view.adapters.ItemAdapter
import com.littleapp.poke.ui.viewmodel.ApiStatus
import com.littleapp.poke.ui.viewmodel.PokeViewModel
import com.littleapp.poke.utils.DATA
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListPokeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PokeViewModel by hiltNavGraphViewModels(R.id.main_graph)
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListPokeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.nameSpace.text = DATA.POKE

        adapter = ItemAdapter()
        binding.recyclerViewPoke.adapter = adapter

        observeApiStatus()
        observeListPokemon()
        onClickItem()
    }

    private fun observeApiStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status) {
                ApiStatus.LOADING -> {
                    binding.statusOffline.visibility = View.GONE
                    binding.shimmerLoading.visibility = View.VISIBLE
                    binding.recyclerViewPoke.visibility = View.GONE
                }
                ApiStatus.ERROR -> {
                    binding.statusOffline.visibility = View.VISIBLE
                    binding.shimmerLoading.visibility = View.GONE
                    binding.recyclerViewPoke.visibility = View.GONE
                }
                ApiStatus.DONE -> {
                    binding.statusOffline.visibility = View.GONE
                    binding.shimmerLoading.visibility = View.GONE
                    binding.recyclerViewPoke.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun observeListPokemon() {
        viewModel.pokemonList.observe(viewLifecycleOwner) { adapter.submitList(it) }
    }

    private fun onClickItem() {
        adapter.onItemClickListener = { poke ->
            val bundle = bundleOf("id" to poke.id)
            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
