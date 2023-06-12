package com.example.cryptoapp.di

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.network.CoinPaprikaApi
import com.example.cryptoapp.data.repoImp.CoinRepoImpl
import com.example.cryptoapp.domain.repo.CoinRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

//it informs Hilt how to provide instances of certain types.
@Module
//to tell Hilt which Android class
// each module will be used or installed in.
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
                //resource identifier(END Point)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi):CoinRepo{
        return CoinRepoImpl(api)
    }


}