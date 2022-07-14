package com.example.songlyricks.ui.songlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.songlyricks.data.repository.GeniusRepository
import com.example.songlyricks.data.utils.Response
import com.example.songlyricks.domain.Song
import com.example.songlyricks.domain.toSongList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongListViewModel @Inject constructor(
    private val geniusRepository: GeniusRepository
) : ViewModel() {

    val state = MutableStateFlow<SongListViewState>(SongListViewState.Loading)

    fun getSongs(query: String) {
        viewModelScope.launch {
            geniusRepository.getSongs(query).let {
                when (it) {
                    is Response.Loading -> state.value = SongListViewState.Loading
                    is Response.Success -> {
                        val songlist = it.data?.toSongList()
                        state.value = SongListViewState.Success(songlist)
                    }
                    is Response.Error -> state.value = SongListViewState.Error(it.message.orEmpty())
                }
            }
        }
    }


}


sealed class SongListViewState {
    object Loading : SongListViewState()

    data class Success(
        val data: List<Song>?
    ) : SongListViewState()

    data class Error(
        val message: String
    ) : SongListViewState()
}