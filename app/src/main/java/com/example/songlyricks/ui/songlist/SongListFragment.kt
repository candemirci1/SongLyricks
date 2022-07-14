package com.example.songlyricks.ui.songlist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.songlyricks.databinding.FragmentSongListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SongListFragment : Fragment() {
    private val viewModel: SongListViewModel by viewModels()
    private var adapter: SongListAdapter? = null
    private var binding: FragmentSongListBinding? = null
    private val args: SongListFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSongListBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSongs(args.query)


        lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    is SongListViewState.Success -> {
                        binding?.loading?.isVisible = false
                        it.data?.let { songlist ->
                            if (songlist.isEmpty()) {
                                binding?.tvError?.isVisible = true
                            } else {
                                adapter = SongListAdapter(songlist) { url ->
                                    openSongOnWeb(url)
                                }
                                binding?.rvSongs?.adapter = adapter
                            }
                        }
                    }

                    is SongListViewState.Error -> {
                        binding?.loading?.isVisible = false
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }

                    is SongListViewState.Loading -> {
                        binding?.loading?.isVisible = true
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun openSongOnWeb(url: String) {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(i)

    }


}