package presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val dataStore: DataStoreRepository,
): ViewModel() {

    private val _isFirstLogin = MutableStateFlow(false)
    val isFirstLogin = _isFirstLogin.asStateFlow()

    fun checkFirstLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            _isFirstLogin.value = dataStore.checkFirstLogin()
        }
    }

    fun setUpFirstLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStore.setFirstLogin()
        }
    }

}