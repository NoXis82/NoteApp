package ru.umarsh.noteapp.feature_note.domain.use_case

import ru.umarsh.noteapp.feature_note.domain.model.InvalidNoteException
import ru.umarsh.noteapp.feature_note.domain.model.Note
import ru.umarsh.noteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class AddNote @Inject constructor(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Заголовок не может быть пустым!")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Содержание не может быть пустым")
        }
        repository.insertNote(note)
    }
}