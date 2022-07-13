package com.sirius.test_app.uiFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.sirius.test_app.R
import com.sirius.test_app.data.DataModel
import com.sirius.test_app.databinding.FragmentGameDescriptionBinding

class GameDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentGameDescriptionBinding
    private lateinit var reviewAdapter: UserReviewAdapter
    private lateinit var tagAdapter: GameTagAdapter
    private val data = DataModel()

    @SuppressLint("SetTextI18n")
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
        binding.tvGameRatingCntReview.text = "${data.gradeCnt} Reviews"

        Glide.with(binding.tvGameName.context)
            .load(data.logo)
            .priority(Priority.HIGH)
            .into(binding.ivGameIcon)

        Glide.with(binding.tvGameName.context)
            .load(data.image)
            .priority(Priority.HIGH)
            .centerCrop()
            .into(binding.ivGamePoster)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerTag: RecyclerView = view.findViewById(R.id.recyclerViewGameTag)
        tagAdapter = GameTagAdapter(data.tags)
        recyclerTag.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerTag.adapter = tagAdapter

        val recyclerReview: RecyclerView = view.findViewById(R.id.recyclerViewUserReview)
        reviewAdapter = UserReviewAdapter(data.reviews)
        recyclerReview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerReview.adapter = reviewAdapter
    }
}