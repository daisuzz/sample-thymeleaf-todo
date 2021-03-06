package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.todo.Todo
import com.daisuzz.samplethymeleaftodo.domain.todo.TodoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoCreateService(private val todoRepository: TodoRepository) {

    fun createTodo(form: TodoCreateDto) {
        requireNotNull(form.title)
        requireNotNull(form.detail)

        val id = UUID.randomUUID().mostSignificantBits.toString()

        val todo = Todo(id, form.title, form.detail)

        todoRepository.createTodo(todo)
    }
}
