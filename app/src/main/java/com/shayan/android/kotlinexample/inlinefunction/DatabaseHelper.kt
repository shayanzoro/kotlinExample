package com.shayan.android.kotlinexample.inlinefunction

/**
 * This is just an abstract example of how we could use inline functions
 */
class DatabaseHelper
{
    val database = Database()

    fun saveNote(note: Note)
    {
        doTransition {
            database.save(note)
        }
    }

    fun deleteNote(note: Note)
    {
        doTransition {
            database.delete(note)
        }
    }

    inline fun doTransition(action: () -> Unit)
    {
        database.beginTransaction()
        action.invoke()
        database.commitTransaction()
    }
}