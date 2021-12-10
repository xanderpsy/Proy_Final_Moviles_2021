package com.example.proy_final_moviles_2021

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proy_final_moviles_2021.database.DatabaseManager
import com.example.proy_final_moviles_2021.database.MyAppDataSource
import com.example.proy_final_moviles_2021.database.Pokemon

import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    fun save(pokemon: Pokemon){
        viewModelScope.launch {

            val pokemonDao =DatabaseManager.instance.database.pokemonDao()
            MyAppDataSource(pokemonDao).save(pokemon)
        }
    }
    val savedPokemon = MutableLiveData<List<Pokemon>>()
    fun getPokemones(){
        viewModelScope.launch {
            val pokemonDao =DatabaseManager.instance.database.pokemonDao()
            savedPokemon.value =MyAppDataSource(pokemonDao).getUsers().value
        }
    }
}