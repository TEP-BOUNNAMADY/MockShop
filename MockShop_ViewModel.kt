package com.example.myassigement_async.MockShop_Module

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class MockShopProductViewModel : ViewModel() {
    private val _MockShopProductList = mutableStateListOf<Records>()
    var errorMessage: String by mutableStateOf("")
    var isLoading: Boolean by mutableStateOf(false)
    val MockShopProductList: List<Records>
        get() = _MockShopProductList

    fun getMockShopProductList() {
        viewModelScope.launch {
            isLoading = true
            val apiService = MockShopService.getInstance()
            try {
                _MockShopProductList.clear()
                _MockShopProductList.addAll(apiService.getMockShopProducts())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            } finally {
                isLoading = false
            }
        }
    }
}