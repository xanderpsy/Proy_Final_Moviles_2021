package com.example.proy_final_moviles_2021.fragmentPokedex

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.proy_final_moviles_2021.database.Pokemon
import com.example.proy_final_moviles_2021.databinding.FragmentPokemonVistaBinding
import com.example.proy_final_moviles_2021.databinding.ItemPokemonBinding
import com.example.proy_final_moviles_2021.fragmentSearch.PokemonVistaFragmentArgs
import com.squareup.picasso.Picasso


class PokedexAdapter(private val pokemones: List<Pokemon> ): RecyclerView.Adapter<PokedexAdapter.PokedexHolder>() {
    var pokemonesFilterList = ArrayList<String>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexAdapter.PokedexHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return  PokedexHolder(binding)
    }

    override fun onBindViewHolder(holder: PokedexAdapter.PokedexHolder, position: Int) {
    holder.render(pokemones[position])
    }

    override fun getItemCount(): Int = pokemones.size
    class PokedexHolder(val binding: ItemPokemonBinding):RecyclerView.ViewHolder(binding.root){
        fun render(pokemon:Pokemon){
            val array = arrayOf(pokemon.id,pokemon.nombre,pokemon.tipo,pokemon.hp,pokemon.peso,pokemon.velocidad,pokemon.ataque,pokemon.ataquemas,
                pokemon.defensa,pokemon.defensamas
                )

            binding.tvNombrePokemon.setText(pokemon.nombre)
            binding.tvIdPokemon.setText(pokemon.id)
            binding.tvTipoPokemon.setText(pokemon.tipo)
            if (pokemon.tipo=="fire"){
                binding.raiz.setBackgroundColor(Color.argb(200, 240,80,48))
            }else if (pokemon.tipo=="water"){
                binding.raiz.setBackgroundColor(Color.argb(200, 56,153,248))
            }else if (pokemon.tipo=="grass"){
                binding.raiz.setBackgroundColor(Color.argb(200, 120,200,80))
            }else if (pokemon.tipo=="bug"){
                binding.raiz.setBackgroundColor(Color.argb(200, 168,184,32))
            }else if (pokemon.tipo=="psyche"){
                binding.raiz.setBackgroundColor(Color.argb(200, 248,112,160))
            }else if (pokemon.tipo=="rock"){
                binding.raiz.setBackgroundColor(Color.argb(200, 184,160,88))
            }else if (pokemon.tipo=="steel"){
                binding.raiz.setBackgroundColor(Color.argb(200, 168,168,192))
            }else if (pokemon.tipo=="fightin"){
                binding.raiz.setBackgroundColor(Color.argb(200, 160,80,56))
            }else if (pokemon.tipo=="electric"){
                binding.raiz.setBackgroundColor(Color.argb(200, 248,208,48))
            }else if (pokemon.tipo=="ghost"){
                binding.raiz.setBackgroundColor(Color.argb(200, 96,96,176))
            }else if (pokemon.tipo=="dragon"){
                binding.raiz.setBackgroundColor(Color.argb(200, 160,80,56))
            }else if (pokemon.tipo=="dark"){
                binding.raiz.setBackgroundColor(Color.argb(200, 47,79,79))
            }else if (pokemon.tipo=="normal"){
                binding.raiz.setBackgroundColor(Color.argb(200, 68,160,144))
            }else if (pokemon.tipo=="poison"){
                binding.raiz.setBackgroundColor(Color.argb(200, 176,88,160))
            }else if (pokemon.tipo=="ground"){
                binding.raiz.setBackgroundColor(Color.argb(200, 234,214,164))
            }else if (pokemon.tipo=="fairy"){
                binding.raiz.setBackgroundColor(Color.argb(200, 231,159,231))
            }else if (pokemon.tipo=="ice"){
                binding.raiz.setBackgroundColor(Color.argb(200, 88,200,224))
            }else if (pokemon.tipo=="flying"){
                binding.raiz.setBackgroundColor(Color.argb(200, 152,168,240))
            }

            binding.tvHpPokemon.setText(pokemon.hp)
            binding.tvPesoPokemon.setText(pokemon.peso)
            binding.tvVelocidadPokemon.setText(pokemon.velocidad)
            binding.tvAtaquePokemon.setText(pokemon.ataque)
            binding.tvAtaquemasPokemon.setText(pokemon.ataquemas)
            binding.tvDefensaPokemon.setText(pokemon.defensa)
            binding.tvDefensamasPokemon.setText(pokemon.defensamas)
            Picasso.get().load("${pokemon.pokeurl}").resize(200, 200).into(binding.ivPokefoto);
            binding.raiz.setOnClickListener {
                

            }
        }

    }

}