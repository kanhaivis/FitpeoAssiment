package kk.g.photolist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kk.fitpeoassiment.photolist.adapter.PhotoAdapter
import kk.callback.RowItemDataInterface
import kk.fitpeoassiment.photolist.mvvm.PhotoListViewModel
import kk.fitpeoassiment.databinding.FragmentPhotoListBinding
import kk.fitpeoassiment.photolist.PhotoListFragmentDirections
import kk.models.PhotoResponseItem


class PhotoListFragment : Fragment() , RowItemDataInterface {

    private var _binding: FragmentPhotoListBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel: PhotoListViewModel
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PhotoListViewModel::class.java)

        initRecyclerview()
        viewModel.productsLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { it1 -> photoAdapter.setPhotoData(it1) }
            photoAdapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerview(){
        photoAdapter = PhotoAdapter(this)
        binding.photoRecyclerview.apply {
            this.layoutManager = LinearLayoutManager(requireActivity())
            this.adapter = photoAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPhotoItem(photoModel: PhotoResponseItem) {
        val directions = PhotoListFragmentDirections.actionPhotoListFragmentToPhotoDetailsFragment(photoModel.url,photoModel.title)
        findNavController().navigate(directions)
    }

}