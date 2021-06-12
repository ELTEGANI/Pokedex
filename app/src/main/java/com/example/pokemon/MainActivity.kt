package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.pokemonlist.PokemonListScreen
import com.example.pokemon.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           JetpackComposePokedexTheme {
              val navController = rememberNavController()
               NavHost(
                   navController = navController,
                   startDestination = "pokemon_lists_screen"
               ){
                 composable("pokemon_lists_screen"){
                     PokemonListScreen(navController = navController)
                 }
                 composable("pokemon_detail_screen/{dominantColor}/{pokemonName}",
                  arguments = listOf(
                      navArgument("dominantColor"){
                         type = NavType.IntType
                      },
                      navArgument("pokemonName"){
                          type = NavType.StringType
                      }
                  )){
                   val dominantColor = remember{
                      val color = it.arguments?.getInt("dominantColor")
                      color?.let { Color(it) } ?: Color.White
                   }
                   val pokemonName = remember {
                       it.arguments?.getString("pokemonName")
                   }
                 }
               }
           }
        }
    }
}
