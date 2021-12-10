package com.example.proy_final_moviles_2021.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_POKEMONES = "Pokemones"
const val DATABASE_NAME = "myappname.sqlite"
@Database(
    entities = [PokemonEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract  fun pokemonDao(): PokemonDao
}