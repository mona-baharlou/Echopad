package com.baharlou.echopad.viewmodel

import androidx.lifecycle.ViewModel
import com.baharlou.echopad.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoteViewModel : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    fun addNote(title: String, content: String) {
        val newNote = Note(
            id = (_notes.value.lastOrNull()?.id ?: 0) + 1,
            title = title,
            content = content
        )
        _notes.value += newNote
    }
}
