package com.example.pushtestapplication.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultDataStore @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_TEST)


    suspend fun setFCMToken(token: String) {
        context.datastore.setValue(stringPreferencesKey(FCM_TOKEN), token)
    }

    fun getFCMToken(defaultValue: String = ""): Flow<String> =
        context.datastore.getValueAsFlow(stringPreferencesKey(FCM_TOKEN), defaultValue)

    /***
     * handy function to save key-value pairs in Preference. Sets or updates the value in Preference
     * @param key used to identify the preference
     * @param value the value to be saved in the preference
     */
    private suspend fun <T> DataStore<Preferences>.setValue(
        key: Preferences.Key<T>,
        value: T
    ) {
        this.edit { preferences ->
            // save the value in prefs
            preferences[key] = value
        }
    }


    private fun <T> DataStore<Preferences>.getValueAsFlow(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> {
        return this.data.catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                // we try again to store the value in the map operator
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            // return the default value if it doesn't exist in the storage
            preferences[key] ?: defaultValue
        }
    }

    companion object{
        const val DATA_STORE_TEST = "DATA_STORE_TEST"
        const val FCM_TOKEN = "FCM_TOKEN"
    }

}