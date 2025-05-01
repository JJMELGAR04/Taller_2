package com.pdmtaller2.a00073923_juanmelgar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.a00073923_juanmelgar.Navigation.AppNavigation
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2.a00073923_juanmelgar.ui.theme._00073923_JuanMelgarTheme



class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _00073923_JuanMelgarTheme {
                val navController = rememberNavController()
                val cartViewModel: CartViewModel = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(navController ,modifier = Modifier.padding(innerPadding), cartViewModel)
                }
            }

        }
    }
}

