package ru.umarsh.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.umarsh.noteapp.ui.theme.*

@Entity
data class Note(
    @PrimaryKey val id: Long? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)