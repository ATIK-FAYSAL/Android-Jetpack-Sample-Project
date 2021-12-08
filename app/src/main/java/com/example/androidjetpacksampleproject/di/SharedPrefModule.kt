package com.example.androidjetpacksampleproject.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefModule
{
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) = context
}