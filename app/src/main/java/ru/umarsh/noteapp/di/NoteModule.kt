package ru.umarsh.noteapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.umarsh.noteapp.feature_note.data.data_source.NoteDatabase
import ru.umarsh.noteapp.feature_note.data.repository.NoteRepositoryImpl
import ru.umarsh.noteapp.feature_note.domain.repository.NoteRepository
import ru.umarsh.noteapp.feature_note.domain.use_case.AddNote
import ru.umarsh.noteapp.feature_note.domain.use_case.DeleteNote
import ru.umarsh.noteapp.feature_note.domain.use_case.GetNotes
import ru.umarsh.noteapp.feature_note.domain.use_case.NoteUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}