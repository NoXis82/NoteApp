package ru.umarsh.noteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.umarsh.noteapp.feature_note.domain.model.Note

@Database(
    version = 1,
    entities = [Note::class]
)
abstract class NoteDatabase : RoomDatabase() {
    
    abstract val noteDao: NoteDao
}