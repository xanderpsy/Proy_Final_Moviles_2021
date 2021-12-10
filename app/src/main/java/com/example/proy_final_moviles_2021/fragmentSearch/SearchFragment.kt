package com.example.proy_final_moviles_2021.fragmentSearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proy_final_moviles_2021.PokemonViewModel
import com.example.proy_final_moviles_2021.database.Pokemon
import com.example.proy_final_moviles_2021.databinding.FragmentSearchBinding
import com.example.proy_final_moviles_2021.fragmentPokedex.PokedexAdapter
import org.json.JSONObject
import java.net.URL

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var queue : RequestQueue

   private val pokemonViewModel: PokemonViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queue = Volley.newRequestQueue(context)
       // val apiRequest= URL("").readText()
        binding.btnSearch.setOnClickListener {
            getPokemon(binding.etPokemonToSearchFor.text.toString())

        }


    }
    fun getPokemon(pokemonName:String){
    var url ="https://pokeapi.co/api/v2/pokemon/?limit=1118&offset=0\""
        val jsonRuquest= JsonObjectRequest(url,Response.Listener<JSONObject>{
            //Log.d("JsonResponse",it.toString())
            val pokemonesarray = it.getJSONArray("results")
            val pokemones = mutableListOf<Pokemon>()//listOf()
            for (i in 0..pokemonesarray.length()-1){
               val jasonobjet = JSONObject(pokemonesarray[i].toString())
                //Log.d("JsonResponse",jasonobjet.get("url").toString())
              //  Log.d("JsonResponse",jasonobjet.get("name").toString())
                url ="${jasonobjet.get("url").toString()}"
                val jsonRuquest= JsonObjectRequest(url,Response.Listener<JSONObject>{
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
                    //Log.d("JsonResponse2",url)
                    binding.rvPokemonEntries2.layoutManager = LinearLayoutManager(view?.context)
                    val filtro = name.indexOf(pokemonName)
                    Log.d("JsonResponse2",filtro.toString())
                    Log.d("JsonResponse2",jasonobjet.get("url").toString())
                    if (filtro==0){
                    pokemones.add(Pokemon(id.toString(),name,tipo,hp,velocidad,peso,ataque,ataquemas,defensa,defensamas,url))
                    }


                },Response.ErrorListener {

                })
                queue.add(jsonRuquest)
        }

            val adapter = PokedexAdapter(pokemones)
            binding.rvPokemonEntries2.adapter= adapter
        },Response.ErrorListener {

        }
        )
        queue.add(jsonRuquest)
    }
    override fun onStop(){
        super.onStop()
        queue.cancelAll("stopped")
    }
    private fun OnPokemonClickListener(position: Int) {
        //Toast.makeText(this, mRepos[position].name, Toast.LENGTH_SHORT).show()
    }


}