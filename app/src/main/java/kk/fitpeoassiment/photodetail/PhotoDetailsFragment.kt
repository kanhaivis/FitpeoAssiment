package kk.fitpeoassiment.photodetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kk.fitpeoassiment.databinding.FragmentPhotoDetailsBinding
import kk.models.PhotoDetailItem

class PhotoDetailsFragment : Fragment() {

    private var _binding: FragmentPhotoDetailsBinding? = null
    val binding get() = _binding!!

    val safeArgs: PhotoDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = safeArgs.title
        val urls =safeArgs.imgUrl

        val photoItem = PhotoDetailItem(title,urls)
        binding.photoDetails = photoItem
    }
}