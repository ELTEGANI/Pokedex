package com.example.pokemon.repository

import com.example.pokemon.data.remote.PokemonApi
import com.example.pokemon.data.remote.response.PokeList
import com.example.pokemon.data.remote.response.Pokemon
import com.example.pokemon.utils.Resource
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi
){
    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokeList>{
        val response = try {
            pokemonApi.getPokemonList(limit,offset)
        }catch (e:Exception){
         return Resource.Error("An Error Occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemon:String):Resource<Pokemon>{
        val response = try {
            pokemonApi.getPokemonInfo(pokemon)
        }catch (e:Exception){
            return Resource.Error("An Error Occurred")
        }
        return Resource.Success(response)
    }

}