package com.example.myassigement_async.MockShop_Module

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockShopProductScaffold(vm: MockShopProductViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Fake Product") },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            Icons.Default.ArrowDownward,
                            contentDescription = "Down",
                        )
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "Refresh",
                        )
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            MockShopProductUI(vm)
        }
    }
}

@Composable
fun MockShopProductUI(vm: MockShopProductViewModel) {
    LaunchedEffect(Unit) {
        vm.getMockShopProductList()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (vm.isLoading) {
            CircularProgressIndicator()
        } else if (vm.errorMessage.isNotEmpty()) {
            Text("Error: ${vm.errorMessage}")
        } else {
            LazyColumn() {
                items(vm.MockShopProductList.size) {

                    val element = vm.MockShopProductList[it]

                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Surface(
                            modifier = Modifier.size(120.dp),
                        ) {
                            AsyncImage(
                                model = element.image,
                                contentDescription = element.image.toString(),
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Column() {
                                Text(element.title)
                                Text("USD ${element.price}")
                                Text("amount: ${element.amount}")

                            }
                        }
                    }
                }
            }
        }
    }
}