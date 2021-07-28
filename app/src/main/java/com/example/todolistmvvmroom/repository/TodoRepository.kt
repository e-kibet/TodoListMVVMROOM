package com.example.todolistmvvmroom.repository

import androidx.lifecycle.LiveData
import com.example.todolistmvvmroom.data.local.LocalDataSource
import com.example.todolistmvvmroom.data.local.entity.Todo

class TodoRepository(private val localDataSource: LocalDataSource) : ITodoRepository {

    companion object {
        @Volatile
        private var instance: TodoRepository? = null

        fun getInstance(localData: LocalDataSource): TodoRepository =
            instance ?: synchronized(this) {
                instance ?: TodoRepository(localData)
            }
    }

    override fun getAllTodos(): LiveData<List<Todo>> {
        return localDataSource.getAllTodos()
    }

    override fun getAllCompleted(): LiveData<List<Todo>> {
        return localDataSource.getAllCompleted()
    }

    override suspend fun insert(todo: Todo) {
        localDataSource.insert(todo)
    }

    override suspend fun update(todo: Todo) {
        localDataSource.update(todo)
    }

    override suspend fun deleteSelectedTodos() {
        localDataSource.deleteSelectedTodos()
    }

    override suspend fun clearTodos() {
        localDataSource.clearTodos()
    }
}