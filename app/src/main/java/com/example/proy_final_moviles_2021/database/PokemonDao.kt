package com.example.proy_final_moviles_2021.database

import androidx.room.*

@Dao
interface PokemonDao {


    @Query("SELECT * FROM $TABLE_POKEMONES")
    fun  getPokemonFromDatabase():List<PokemonEntity>

    @Query("SELECT * FROM $TABLE_POKEMONES WHERE nombre = :query")
    fun getPokemonBynomnre(query:String):PokemonEntity

    @Delete
    fun delete(pokemon: PokemonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(pokemon: PokemonEntity)
}