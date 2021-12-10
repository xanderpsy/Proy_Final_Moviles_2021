package com.example.proy_final_moviles_2021.database

class Pokemon(id:String,nombre:String,tipo:String,hp:String,velocidad:String,peso:String,ataque:String,ataquemas:String,defensa:String,defensamas:String,pokeurl:String) {
    val id=id
    val nombre=nombre
    val tipo=tipo
    val hp=hp
    val velocidad=velocidad
    val peso=peso
    val ataque=ataque
    val ataquemas=ataquemas
    val defensa=defensa
    val defensamas = defensamas
    val pokeurl = pokeurl
}
fun Pokemon.toEntity() = PokemonEntity(
    id,nombre,tipo,hp,velocidad,peso,ataque,ataquemas,defensa,defensamas,pokeurl
)