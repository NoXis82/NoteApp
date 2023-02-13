package ru.umarsh.noteapp.feature_note.domain.use_case

import ru.umarsh.noteapp.feature_note.domain.model.Note
import ru.umarsh.noteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class GetNote @Inject constructor(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Long): Note? {
        return repository.getNoteById(id)
    }
}