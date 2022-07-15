package com.sirius.test_app.uiFragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirius.test_app.R
import com.sirius.test_app.data.ReviewModel
import com.sirius.test_app.databinding.UserReviewItemBinding

class UserReviewAdapter(private val reviews: List<ReviewModel>) :
    RecyclerView.Adapter<UserReviewAdapter.UserReviewViewHolder>() {

    override fun getItemCount(): Int = reviews.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserReviewViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_review_item, parent, false)

        return UserReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserReviewViewHolder, position: Int) {
        holder.onBind(reviews[position])
    }

    inner class UserReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = UserReviewItemBinding.bind(itemView)

        fun onBind(review: ReviewModel) {

            Glide.with(itemView.context)
                .load(review.userImage)
                .circleCrop()
                .into(binding.ivUserAvatar)

            binding.tvUserName.text = review.userName
            binding.tvReviewDate.text = review.date
            binding.tvReviewDescription.text = review.message
        }
    }
}