package com.example.todolistmvvmroom.data.local.entity
import androidx.lifecycle.LiveData
import com.example.todolistmvvmroom.data.local.entity.room.TodoDAO

class LocalDataSource private constructor(private val todoDAO: TodoDAO) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(todoDAO: TodoDAO): LocalDataSource =
            INSTANCE ?: LocalDataSource(todoDAO)
    }

    fun getAllTodos(): LiveData<List<Todo>> = todoDAO.loadTodos()

    fun getAllCompleted(): LiveData<List<Todo>> = todoDAO.loadCompleted()

    suspend fun insert(todo: Todo) = todoDAO.insertTodo(todo)

    suspend fun update(todo: Todo) = todoDAO.updateTodo(todo)

    suspend fun deleteSelectedTodos() = todoDAO.deleteSelectedTodos()

    suspend fun clearTodos() = todoDAO.clearTodos()
}