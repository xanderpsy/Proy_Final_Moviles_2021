package com.example.proy_final_moviles_2021.fragmentPokedex

import android.content.Context
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proy_final_moviles_2021.PokemonViewModel
import com.example.proy_final_moviles_2021.R
import com.example.proy_final_moviles_2021.database.Pokemon
import com.example.proy_final_moviles_2021.databinding.FragmentPokedexBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class PokedexFragment : Fragment() {

    private lateinit var binding: FragmentPokedexBinding
    private lateinit var queue : RequestQueue
    private val pokemonViewModel: PokemonViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokedexBinding.inflate(inflater,container,false)
        //enviar Argumentos
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.llPokemonVer.isVisible = false
        queue = Volley.newRequestQueue(context)
        binding.rvPokemonEntries.layoutManager = LinearLayoutManager(view?.context)


        pokemonViewModel.getPokemones()
        pokemonViewModel.savedPokemon.observe(viewLifecycleOwner,{pokemonList->
            if(!pokemonList.isNullOrEmpty()){
                val adapter = PokedexAdapter(pokemonList)
                binding.rvPokemonEntries.adapter= adapter

            }else{
                context?.toast("No tienes pokemones atrapados")
            }
        })


        binding.btnSearch.setOnClickListener {
            getPokemon(binding.etPokemonToSearchFor2.text.toString())
            Log.d("JsonResponse",binding.etPokemonToSearchFor2.text.toString())
            binding.llPokemonVer.isVisible =true
        }
    }
    fun getPokemon(pokemonName:String){
        var url ="https://pokeapi.co/api/v2/pokemon/$pokemonName"
        val jsonRuquest= JsonObjectRequest(url, Response.Listener<JSONObject>{
            Log.d("JsonResponse",it.toString())
            val name = it.getString("name")
            //  Log.d("JsonResponse2",name)
            val id = it.getString("id")
            // Log.d("JsonResponse2",id)
            val tipo = it.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name")
            // Log.d("JsonResponse2",tipo)
            val hp = it.getJSONArray("stats").getJSONObject(0).getString("base_stat")
            ///  Log.d("JsonResponse2",hp)
            val velocidad = it.getJSONArray("stats").getJSONObject(2).getString("base_stat")
            //  Log.d("JsonResponse2",velocidad)
            val peso = it.getString("weight")
            //  Log.d("JsonResponse2",peso)
            val ataque = it.getJSONArray("stats").getJSONObject(1).getString("base_stat")
            // Log.d("JsonResponse2",ataque)
            val ataquemas = it.getJSONArray("stats").getJSONObject(3).getString("base_stat")
            //Log.d("JsonResponse2",ataquemas)
            val defensa = it.getJSONArray("stats").getJSONObject(2).getString("base_stat")
            //Log.d("JsonResponse2",defensa)
            val defensamas = it.getJSONArray("stats").getJSONObject(4).getString("base_stat")
            //Log.d("JsonResponse2",defensamas)
            val url = it.getJSONObject("sprites").getString("front_default")
            binding.tvNombrePokemon.setText(name)
            binding.tvIdPokemon.setText(id)
            binding.tvTipoPokemon.setText(tipo)
            if (tipo=="fire"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 240,80,48))
            }else if (tipo=="water"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 56,153,248))
            }else if (tipo=="grass"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 120,200,80))
            }else if (tipo=="bug"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 168,184,32))
            }else if (tipo=="psyche"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 248,112,160))
            }else if (tipo=="rock"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 184,160,88))
            }else if (tipo=="steel"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 168,168,192))
            }else if (tipo=="fightin"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 160,80,56))
            }else if (tipo=="electric"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 248,208,48))
            }else if (tipo=="ghost"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 96,96,176))
            }else if (tipo=="dragon"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 160,80,56))
            }else if (tipo=="dark"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 47,79,79))
            }else if (tipo=="normal"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 68,160,144))
            }else if (tipo=="poison"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 176,88,160))
            }else if (tipo=="ground"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 234,214,164))
            }else if (tipo=="fairy"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 231,159,231))
            }else if (tipo=="ice"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 88,200,224))
            }else if (tipo=="flying"){
                binding.llPokemonVer.setBackgroundColor(Color.argb(200, 152,168,240))
            }

            binding.tvHpPokemon.setText(hp)
            binding.tvPesoPokemon.setText(peso)
            binding.tvVelocidadPokemon.setText(velocidad)
            binding.tvAtaquePokemon.setText(ataque)
            binding.tvAtaquemasPokemon.setText(ataquemas)
            binding.tvDefensaPokemon.setText(defensa)
            binding.tvDefensamasPokemon.setText(defensamas)
            Picasso.get().load("${url}").resize(200, 200).into(binding.ivPokefoto);
            binding.btnAtrapar.setOnClickListener {
                pokemonViewModel.save(Pokemon(id.toString(),name,tipo,hp,velocidad,peso,ataque,ataquemas,defensa,defensamas,url))
                context?.toast("Pokemon Atrapado")
            }

        }, Response.ErrorListener {

        }
        )
        queue.add(jsonRuquest)
    }
    fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) = this?.let { Toast.makeText(it, text, duration).show() }
    fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) = this?.let { Toast.makeText(it, textId, duration).show() }
}