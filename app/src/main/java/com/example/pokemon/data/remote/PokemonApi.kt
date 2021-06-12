package com.example.pokemon.data.remote

import com.example.pokemon.data.remote.response.PokeList
import com.example.pokemon.data.remote.response.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int
    ) : PokeList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name:String
    ) : Pokemon

}