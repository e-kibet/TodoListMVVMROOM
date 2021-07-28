package com.example.todolistmvvmroom.repository

import androidx.lifecycle.LiveData
import com.example.todolistmvvmroom.data.local.entity.Todo

interface ITodoRepository {

    fun getAllTodos(): LiveData<List<Todo>>

    fun getAllCompleted(): LiveData<List<Todo>>

    suspend fun insert(todo: Todo)

    suspend fun update(todo: Todo)

    suspend fun deleteSelectedTodos()

    suspend fun clearTodos()
}