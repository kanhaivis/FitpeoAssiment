package kk.callback

import kk.models.PhotoResponseItem

interface RowItemDataInterface {
    fun onPhotoItem(photoModel: PhotoResponseItem)
}