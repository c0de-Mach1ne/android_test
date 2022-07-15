package com.sirius.test_app.uiFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.sirius.test_app.data.DataModel
import com.sirius.test_app.databinding.FragmentGameDescriptionBinding
import com.sirius.test_app.uiFragment.adapters.GameTagAdapter
import com.sirius.test_app.uiFragment.adapters.StarsAdapter
import com.sirius.test_app.uiFragment.adapters.UserReviewAdapter
import kotlin.math.roundToInt

class GameDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentGameDescriptionBinding
    private val data = DataModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameDescriptionBinding.inflate(layoutInflater, container, false)

        initGameName()
        initNumOfReviews()
        initGameDescription()
        initGameRating()
        loadGamePoster()
        loadGameIcon()
        initStarsRecyclers()
        initTagsRecycler()
        initReviewRecycler()

        return binding.root
    }

    private fun initGameName() {
        binding.tvGameName.text = data.name
    }

    private fun initGameRating() {
        binding.tvGameRating.text = data.rating.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun initNumOfReviews() {
        binding.tvReviewCnt.text = data.gradeCnt
        binding.tvGameRatingCntReview.text = "${data.gradeCnt} Reviews"
    }

    private fun initGameDescription() {
        binding.tvGameDescription.text = data.description
    }

    private fun loadGameIcon() {
        Glide.with(binding.tvGameName.context)
            .load(data.logo)
            .priority(Priority.HIGH)
            .into(binding.ivGameIcon)
    }

    private fun loadGamePoster() {
        Glide.with(binding.tvGameName.context)
            .load(data.image)
            .priority(Priority.HIGH)
            .centerCrop()
            .into(binding.ivGamePoster)
    }

    private fun initStarsRecyclers() {
        with(binding.recyclerViewStarsReviewCnt) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = StarsAdapter(data.rating.roundToInt())
        }

        with(binding.recyclerViewStarsUserReview) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            adapter = StarsAdapter(data.rating.roundToInt())
        }
    }

    private fun initTagsRecycler() {
        with(binding.recyclerViewGameTag) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            adapter = GameTagAdapter(data.tags)
        }
    }

    private fun initReviewRecycler() {
        with(binding.recyclerViewUserReview) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = UserReviewAdapter(data.reviews)
        }
    }
}