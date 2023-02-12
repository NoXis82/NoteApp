package ru.umarsh.noteapp.feature_note.data.repository

import kotlinx.coroutines.flow.Flow
import ru.umarsh.noteapp.feature_note.data.data_source.NoteDao
import ru.umarsh.noteapp.feature_note.domain.model.Note
import ru.umarsh.noteapp.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Long): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}