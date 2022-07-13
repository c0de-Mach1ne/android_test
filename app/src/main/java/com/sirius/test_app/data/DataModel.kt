package com.sirius.test_app.data

class DataModel(
    val image: String = "https://i.ibb.co/g3YVWD2/img-backgroun.png",
    val logo: String = "https://user-images.githubusercontent.com/47276603/178517025-133fcd0e-3173-4c0f-b71c-c4efe7b58e63.png",
    val name: String = "DoTa 2",
    val rating: Float = 4.9f,
    val gradeCnt: String = "70M",
    val tags: List<String> = listOf("MOBA", "MULTIPLAYER", "STRATEGY"),
    val videos: List<VideoModel> = listOf(
        VideoModel(id = "video_1", image = "https://ibb.co/q7dyBVH"),
        VideoModel(id = "video_2", image = "https://ibb.co/S3GymhJ")
    ),
    val description: String = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
    val reviews: List<ReviewModel> = listOf(
        ReviewModel(
            userImage = "https://ibb.co/WcJMjSw",
            userName = "Auguste Conte",
            date = "February 14, 2019",
            message = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
        ),
        ReviewModel(
            userImage = "https://ibb.co/p1q4QZr",
            userName = "Jang Marcelino",
            date = "February 14, 2019",
            message =
            "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
        )
    ),
    val action: ActionModel = ActionModel(
        name = "Install",
        action = "action_install"
    )

)

class ReviewModel(
    val userImage: String,
    val userName: String,
    val date: String,
    val message: String
)

class VideoModel(
    val id: String,
    val image: String
)

class ActionModel(
    val name: String,
    val action: String
)