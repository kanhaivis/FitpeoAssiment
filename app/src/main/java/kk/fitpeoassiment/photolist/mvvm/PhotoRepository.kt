package kk.fitpeoassiment.photolist.mvvm

import androidx.lifecycle.MutableLiveData
import kk.models.PhotoResponseItem
import kk.network.FitpeoServiceInstance
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val fitpeoAPI: FitpeoServiceInstance) {

    private val _photos = MutableLiveData<List<PhotoResponseItem>?>()
    val products: MutableLiveData<List<PhotoResponseItem>?>
        get() = _photos

    suspend fun getPhoto(){
        val result = fitpeoAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            _photos.postValue(result.body())
        } else {
            _photos.postValue(null)
        }
    }

}