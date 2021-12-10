package com.example.proy_final_moviles_2021.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyAppDataSource(private val pokemonDao: PokemonDao) {
    suspend fun getUsers(): LiveData<List<Pokemon>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(pokemonDao.getPokemonFromDatabase().map {it.toPokemon()})
    }

    suspend fun getSingleUser(query: String): LiveData<Pokemon> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(pokemonDao.getPokemonBynomnre(query).toPokemon())
    }

    suspend fun delete(pokemon:Pokemon) = withContext(Dispatchers.IO){
        pokemonDao.delete(pokemon.toEntity())
    }

    suspend fun save(pokemon:Pokemon) =  withContext(Dispatchers.IO){
        pokemonDao.save(pokemon.toEntity())
    }

}