package com.enriquepalmadev.energiasolar_consumoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.enriquepalmadev.energiasolar_consumoapi.compose.ShowResult
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.ui.theme.EnergiaSolar_ConsumoAPITheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()
        

        lifecycleScope.launch {
            try {
//                val panels = service.popularMovieList("\$argon2id\$v=19\$m=1024,t=1,p=1\$xMlxQPaChY")
                val panels = service.dtoList()

                setContent {
                    EnergiaSolar_ConsumoAPITheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            ShowResult(panels = panels)
                        }
                    }
                }
            } catch (e: Exception) {
                println("Error fetching panel list: $e")
            }
        }
    }
}