package data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import data.repository.DataStoreKey.IS_FIRST_LOGIN_KEY

class DataStoreRepository(
    private val dataStore: DataStore<Preferences>
) {

    private val isFirstLoginKey = booleanPreferencesKey(IS_FIRST_LOGIN_KEY)

    suspend fun checkFirstLogin(): Boolean{
        var value = false

        dataStore.edit { preferences ->
            value = preferences[isFirstLoginKey] ?: false
        }
        return value
    }

    suspend fun setFirstLogin(){
        dataStore.edit { preferences ->
            preferences[isFirstLoginKey] = true
        }
    }
}

object DataStoreKey{
    const val IS_FIRST_LOGIN_KEY = "isFirstLoginKey"
}