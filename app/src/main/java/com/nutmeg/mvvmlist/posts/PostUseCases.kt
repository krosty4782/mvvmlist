package com.nutmeg.mvvmlist.posts

import com.nutmeg.core.domain.use_cases.GetPostsWithNameAndFavsUseCase
import javax.inject.Inject

data class PostUseCases @Inject constructor(val getAllPostsWithNameAndFavUseCase: GetPostsWithNameAndFavsUseCase)