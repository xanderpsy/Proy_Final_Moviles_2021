package com.example.proy_final_moviles_2021.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_POKEMONES)
data class PokemonEntity(
    @PrimaryKey val id:String,
    val nombre:String,
    val tipo:String,
    val hp:String,
    val velocidad:String,
    val peso:String,
    val ataque:String,
    val ataquemas:String,
    val defensa:String,
    val defensamas : String,
    val pokeurl:String
)

fun PokemonEntity.toPokemon() = Pokemon(
    id,nombre,tipo,hp,velocidad,peso,ataque,ataquemas,defensa,defensamas,pokeurl
)