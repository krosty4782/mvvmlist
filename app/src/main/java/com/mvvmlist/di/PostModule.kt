package com.mvvmlist.di


import com.mvvmlist.data.datasource.FavouritesDataSource
import com.mvvmlist.data.datasource.PostDataSource
import com.mvvmlist.data.datasource.UsersDataSource
import com.mvvmlist.data.services.FavouritesService
import com.mvvmlist.data.services.FavouritesServiceImp
import com.mvvmlist.data.services.PostService
import com.mvvmlist.data.services.UsersService
import com.mvvmlist.domain.repositories.FavouritesRepository
import com.mvvmlist.domain.repositories.PostsRepository
import com.mvvmlist.domain.repositories.UsersRepository
import com.mvvmlist.domain.use_cases.DeleteFavouriteUseCase
import com.mvvmlist.domain.use_cases.GetPostsWithNameAndFavsUseCase
import com.mvvmlist.domain.use_cases.IsFavouriteUseCase
import com.mvvmlist.domain.use_cases.StoreFavouriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object PostModule {

    @Provides
    fun getUsersDataSource(usersService: UsersService): UsersDataSource =
        com.mvvmlist.repositories.UsersDataSource(usersService)

    @Provides
    fun getPostDataSource(postService: PostService): PostDataSource =
        com.mvvmlist.repositories.PostDataSource(postService)

    @Provides
    fun getUsersRepository(usersDataSource: UsersDataSource): UsersRepository =
        com.mvvmlist.data.repositories.UsersRepository(usersDataSource)

    @Provides
    fun getPostsRepository(dataSource: PostDataSource): PostsRepository =
        com.mvvmlist.data.repositories.PostsRepository(dataSource)

    @Provides
    fun getPostsWithNameUseCase(
        postRepository: PostsRepository,
        userRepository: UsersRepository,
        favouritesRepository: FavouritesRepository
    ) = GetPostsWithNameAndFavsUseCase(postRepository, userRepository, favouritesRepository)

    @Provides
    fun getFavouritesDataSource(favouritesService: FavouritesService) : FavouritesDataSource =
        com.mvvmlist.repositories.FavouritesDataSource(favouritesService)

    @Provides
    fun getFavouritesRepository(favouritesDataSource: FavouritesDataSource): FavouritesRepository =
        com.mvvmlist.data.repositories.FavouritesRepository(favouritesDataSource)

    @Provides
    fun getIsFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        IsFavouriteUseCase(favouritesRepository)

    @Provides
    fun getStoreFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        StoreFavouriteUseCase(favouritesRepository)

    @Provides
    fun getDeleteFavouriteUseCase(favouritesRepository: FavouritesRepository) =
        DeleteFavouriteUseCase(favouritesRepository)
}