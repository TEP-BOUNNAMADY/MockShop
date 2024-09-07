package com.example.myassigement_async.MockShop_Module

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivityMockShop : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsyncApp()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AsyncApp(){
    val vm = MockShopProductViewModel()
    MockShopProductScaffold(vm)
}