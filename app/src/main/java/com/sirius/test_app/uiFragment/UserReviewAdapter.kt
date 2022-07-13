package com.sirius.test_app.uiFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirius.test_app.R
import com.sirius.test_app.data.ReviewModel

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

        private val userAvatar: ImageView = itemView.findViewById(R.id.ivUserAvatar)
        private val userName: TextView = itemView.findViewById(R.id.tvUserName)
        private val reviewDate: TextView = itemView.findViewById(R.id.tvReviewDate)
        private val reviewDescription: TextView = itemView.findViewById(R.id.tvReviewDescription)

        fun onBind(review: ReviewModel) {

            Glide.with(itemView.context)
                .load(review.userImage)
                .circleCrop()
                .into(userAvatar)

            userName.text = review.userName
            reviewDate.text = review.date
            reviewDescription.text = review.message
        }
    }
}