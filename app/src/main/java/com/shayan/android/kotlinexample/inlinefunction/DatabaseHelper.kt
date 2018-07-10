package com.shayan.android.kotlinexample.inlinefunction

/**
 * This is just an abstract example of how we could use inline functions
 * Inspired by https://kotlinlang.org/docs/reference/inline-functions.html
 * and https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
 */
class DatabaseHelper
{
    val database = Database()

    fun saveNote(note: Note)
    {
        // Here is when we use the inline function.
        // Inline function won't create an instance of 'action' function,
        // it will wrap the content of the inlined function around the passed function
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