package com.math.geovoyager.di

import com.math.geovoyager.pages.home.viewmodels.HomeViewModel
import com.math.geovoyager.pages.practicequestionquiz.viewmodels.PracticeQuestionQuizViewModel
import com.math.geovoyager.pages.practicequestions.viewmodels.PracticeQuestionViewModel
import com.math.geovoyager.pages.quiz.viewmodels.QuizViewModel
import com.math.geovoyager.repositories.menu.MenuRepository
import com.math.geovoyager.repositories.menu.MenuRepositoryImpl
import com.math.geovoyager.repositories.practicequestion.PracticeQuestionRepository
import com.math.geovoyager.repositories.practicequestion.PracticeQuestionRepositoryImpl
import com.math.geovoyager.repositories.practicequestionquiz.PracticeQuestionQuizRepository
import com.math.geovoyager.repositories.practicequestionquiz.PracticeQuestionQuizRepositoryImpl
import com.math.geovoyager.repositories.quiz.QuizRepository
import com.math.geovoyager.repositories.quiz.QuizRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val menuRepository: MenuRepository = MenuRepositoryImpl()
    private val practiceQuestionRepository: PracticeQuestionRepository = PracticeQuestionRepositoryImpl()
    private val practiceQuestionQuizRepository: PracticeQuestionQuizRepository = PracticeQuestionQuizRepositoryImpl()
    private val quizRepository: QuizRepository = QuizRepositoryImpl()

    @Provides
    @Singleton
    fun provideHomeViewModel(): HomeViewModel {
        val homeViewModel: HomeViewModel by lazy {
            HomeViewModel(menuRepository)
        }

        return homeViewModel
    }

    @Provides
    @Singleton
    fun providePracticeQuestionViewModel(): PracticeQuestionViewModel {
        val practiceQuestionViewModel: PracticeQuestionViewModel by lazy {
            PracticeQuestionViewModel(practiceQuestionRepository)
        }

        return practiceQuestionViewModel
    }

    @Provides
    @Singleton
    fun providePracticeQuestionQuizViewModel(): PracticeQuestionQuizViewModel {
        val practiceQuestionQuizViewModel: PracticeQuestionQuizViewModel by lazy {
            PracticeQuestionQuizViewModel(practiceQuestionQuizRepository)
        }

        return practiceQuestionQuizViewModel
    }

    @Provides
    @Singleton
    fun provideQuizViewModel(): QuizViewModel {
        val quizViewModel: QuizViewModel by lazy {
            QuizViewModel(quizRepository)
        }

        return quizViewModel
    }
}