package com.example.apikeypractice.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apikeypractice.R
import com.example.apikeypractice.data.model.searchusers.SearchItemModel
import com.example.apikeypractice.databinding.FragmentSearchBinding
import com.example.apikeypractice.util.ResponseHandling
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        searchViewModel.searchData.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseHandling.Success<*> -> {
                    binding.recyclerViewsearch.apply {
                        layoutManager = LinearLayoutManager(context)
                        val result = it.result as SearchItemModel
                        adapter = SearchAdapter(result.items) {
                            findNavController().navigate(
                                R.id.action_navigation_search_to_navigation_profile,
                                bundleOf(
                                    "profileName" to it.login,
                                    "profileImage" to it.avatarUrl,

                                    )
                            )
                        }
                    }

                }

                is ResponseHandling.Failure -> {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()

                }

                else -> {
                    Toast.makeText(context, "Loading. . .", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return if (query != null) {
                    searchViewModel.setSearch(query)
                    true
                } else {
                    false
                }
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        searchAdapter = SearchAdapter(arrayListOf()) {
            findNavController().navigate(
                R.id.action_navigation_search_to_navigation_profile,
                bundleOf(
                    "profileName" to it.login,
                    "profileImage" to it.avatarUrl,

                    )
            )
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}