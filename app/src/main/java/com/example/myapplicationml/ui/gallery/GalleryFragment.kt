package com.example.myapplicationml.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationml.R
import com.example.myapplicationml.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var image_list :List<GalleryViewModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val  images = CreerMesImages()

        binding.recyclerview2.id = R.id.recyclerview2
        binding.recyclerview2.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerview2.adapter
        val adapter = GalleryAdapter(images)
        binding.recyclerview2.adapter = adapter


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun CreerMesImages() :ArrayList<GalleryViewModel>
    {
        val images = ArrayList<GalleryViewModel>()
        images.add(GalleryViewModel(R.drawable.img1))
        images.add(GalleryViewModel(R.drawable.img2))
        images.add(GalleryViewModel(R.drawable.img3))
        images.add(GalleryViewModel(R.drawable.img4))
        images.add(GalleryViewModel(R.drawable.img5))
        images.add(GalleryViewModel(R.drawable.img6))
        images.add(GalleryViewModel(R.drawable.img7))
        images.add(GalleryViewModel(R.drawable.img8))
        images.add(GalleryViewModel(R.drawable.img9))
        images.add(GalleryViewModel(R.drawable.img10))
        images.add(GalleryViewModel(R.drawable.img11))
        images.add(GalleryViewModel(R.drawable.img12))
        images.add(GalleryViewModel(R.drawable.img13))
        images.add(GalleryViewModel(R.drawable.img14))
        images.add(GalleryViewModel(R.drawable.img15))
        images.add(GalleryViewModel(R.drawable.img16))
        images.add(GalleryViewModel(R.drawable.img17))
        images.add(GalleryViewModel(R.drawable.img18))
        images.add(GalleryViewModel(R.drawable.img19))
        images.add(GalleryViewModel(R.drawable.img20))
        images.add(GalleryViewModel(R.drawable.img21))
        images.add(GalleryViewModel(R.drawable.img22))
        images.add(GalleryViewModel(R.drawable.img23))
        images.add(GalleryViewModel(R.drawable.img24))
        images.add(GalleryViewModel(R.drawable.img25))
        images.add(GalleryViewModel(R.drawable.img26))
        images.add(GalleryViewModel(R.drawable.img27))
        images.add(GalleryViewModel(R.drawable.img28))
        images.add(GalleryViewModel(R.drawable.img29))
        images.add(GalleryViewModel(R.drawable.img30))
        images.add(GalleryViewModel(R.drawable.img31))
        images.add(GalleryViewModel(R.drawable.img32))
        images.add(GalleryViewModel(R.drawable.img33))
        images.add(GalleryViewModel(R.drawable.img34))
        images.add(GalleryViewModel(R.drawable.img35))
        return images
    }

}
