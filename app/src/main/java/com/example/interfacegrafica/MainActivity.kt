package com.example.interfacegrafica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import android.util.Log
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.ButtonColors
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.ui.graphics.Brush
//import com.example.interfacegrafica.ui.theme.InterfaceGraficaTheme

class MainActivity : ComponentActivity() {

    private lateinit var myViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this)[ViewModel::class.java]

        setContent {
            MainScreen(myViewModel)
        }
    }
}

@Composable
fun MainScreen(exmpViewModel: ViewModel){
    /*
        InterfaceGraficaTheme {
            Column(modifier = Modifier.fillMaxSize().background(color = Color(0xFF6650a4)) ) {
                MinhaSaudacao(
                    adjetivoDoNomeX = "frio",
                    nomeX = "Sabado",
                    modifier = Modifier
                            .border(
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(Color.Blue, Color.Red))),
                                shape = MaterialTheme.shapes.medium))
                    Greeting("Android")
            }
        }*/

    var contadorView by remember {
        mutableStateOf(0)
    }

    val contadorProvModelView by exmpViewModel.contadorView.collectAsState()

    Column {
        Button(onClick = {
            contadorView += 1 //isso é considerado algo amador
            exmpViewModel.incrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0, 10, 255, 180)
            )
        ){
            Text(text = "INCREMENTAR CONTADOR")
        }

        Button(onClick = {
            contadorView -= 1 //isso é considerado algo amador
            exmpViewModel.decrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 10, 10, 180)
            )
        ){
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Valor do Contador Controlado pela View = $contadorView")
        Text(text = "Valor do Contador Controlado pela ViewModel = $contadorProvModelView")

    }
}

/*
@Composable
fun MinhaSaudacao(
    nomeX: String = "World",
    adjetivoDoNomeX: String,
    modifier: Modifier/*? = null*/){
    Text(text = "Hello $nomeX $adjetivoDoNomeX", modifier = modifier)
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //MainScreen()
}