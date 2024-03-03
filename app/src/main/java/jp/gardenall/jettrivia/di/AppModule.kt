package jp.gardenall.jettrivia.di

import androidx.compose.ui.unit.Constraints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.gardenall.jettrivia.network.QuestionApi
import jp.gardenall.jettrivia.repository.QuestionRepository
import jp.gardenall.jettrivia.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}