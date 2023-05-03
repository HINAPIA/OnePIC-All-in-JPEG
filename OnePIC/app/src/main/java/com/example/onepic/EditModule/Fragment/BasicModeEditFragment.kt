package com.example.onepic.EditModule.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.onepic.ImageToolModule
import com.example.onepic.JpegViewModel
import com.example.onepic.PictureModule.Contents.Picture
import com.example.onepic.PictureModule.ImageContent
import com.example.onepic.R
import com.example.onepic.databinding.FragmentBasicModeEditBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasicModeEditFragment : Fragment() {
    private lateinit var binding: FragmentBasicModeEditBinding
    lateinit var fragment: Fragment
    private val jpegViewModel by activityViewModels<JpegViewModel>()
    private lateinit var imageContent : ImageContent

    private lateinit var mainPicture: Picture

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 뷰 바인딩 설정
        binding = FragmentBasicModeEditBinding.inflate(inflater, container, false)

        imageContent = jpegViewModel.jpegMCContainer.value?.imageContent!!

        mainPicture = imageContent.mainPicture

        CoroutineScope(Dispatchers.Default).launch {
            // 파일을 parsing해서 PictureContainer로 바꾸는 함수 호출
            // 메인 이미지 설정
            withContext(Dispatchers.Main) {
                Glide.with(binding.basicMainView)
                    .load(imageContent.getJpegBytes(mainPicture))
                    .into(binding.basicMainView)
            }
        }

        binding.basicSaveBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                ImageToolModule().showView(binding.progressBar, true)

                jpegViewModel.jpegMCContainer.value?.save()
                //Thread.sleep(10000)

                withContext(Dispatchers.Main) {
                    findNavController().navigate(R.id.action_basicModeEditFragment_to_cameraFragment)
                }
                ImageToolModule().showView(binding.progressBar, false)
            }
        }
        binding.basicCloseBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                withContext(Dispatchers.Main) {
                    findNavController().navigate(R.id.action_basicModeEditFragment_to_cameraFragment)
                }
            }
        }

        return binding.root
    }
}