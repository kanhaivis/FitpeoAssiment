package kk.fitpeoassiment.photolist.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kk.models.PhotoResponseItem
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel() {

    val productsLiveData : MutableLiveData<List<PhotoResponseItem>?>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getPhoto()
        }
    }

}