package kk.fitpeoassiment.photolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kk.callback.RowItemDataInterface
import kk.fitpeoassiment.databinding.RowPhotoItemBinding
import kk.models.PhotoResponseItem

class PhotoAdapter(private val listener: RowItemDataInterface) : RecyclerView.Adapter<PhotoAdapter.MyHolder>() {

    private  var photoData : List<PhotoResponseItem>? = null

    fun setPhotoData(_photList : List<PhotoResponseItem>){
        this.photoData = _photList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        iRowItem = listener
        return MyHolder(RowPhotoItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.viewPhotoBinding.photo = photoData!![position]
        holder.itemView.setOnClickListener {
            iRowItem?.also {
                it.onPhotoItem(photoData!![position])
            }
        }
       // holder.bind(photoData!![position])
    }

    override fun getItemCount(): Int {
       return this.photoData?.size ?: 0
    }

    inner class MyHolder(val viewPhotoBinding: RowPhotoItemBinding) : RecyclerView.ViewHolder(viewPhotoBinding.root)

    companion object {
        var iRowItem: RowItemDataInterface? = null
    }
}


