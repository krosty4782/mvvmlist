package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.models.PostWithUser

class PostsModelConverter {

    fun convert(posts: List<PostWithUser>?): List<PostsModel>? {
        val postsModel = posts?.map {
            PostsModel(
                title = it.post.title,
                body = it.post.body,
                username = it.user.username,
                userId = it.user.id
            )
        }
        return postsModel
    }
}