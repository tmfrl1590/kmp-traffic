package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kmp.traffic.getContext
import utils.Constants.DATA_STORE_FILE_NAME
import java.io.File

actual fun dataStorePreferences(): DataStore<Preferences> {
    return createDataStoreWithDefaults(
        path = {
            File(getContext()!!.filesDir , "datastore/$DATA_STORE_FILE_NAME").path
        })
}