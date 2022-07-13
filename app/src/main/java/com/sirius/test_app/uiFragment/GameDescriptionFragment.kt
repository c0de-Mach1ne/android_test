package com.sirius.test_app.uiFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sirius.test_app.data.DataModel
import com.sirius.test_app.databinding.FragmentGameDescriptionBinding

class GameDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentGameDescriptionBinding
    private val data = DataModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameDescriptionBinding.inflate(layoutInflater, container, false)

        binding.tvGameName.text = data.name
        binding.tvReviewCnt.text = data.gradeCnt
        binding.tvGameDescription.text = data.description
        binding.tvGameRating.text = data.rating.toString()


        return binding.root
    }

}