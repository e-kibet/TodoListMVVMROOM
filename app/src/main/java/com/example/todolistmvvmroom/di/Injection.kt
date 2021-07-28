package com.example.todolistmvvmroom.di

import android.content.Context
import com.example.todolistmvvmroom.data.local.entity.LocalDataSource
import com.example.todolistmvvmroom.data.local.entity.room.TodoDb
import com.example.todolistmvvmroom.repository.TodoRepository

object Injection {
    fun provideRepository(context: Context): TodoRepository {
        val database = TodoDb.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.todoDAO())

        return TodoRepository.getInstance(localDataSource)
    }
}