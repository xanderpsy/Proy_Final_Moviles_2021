package com.example.proy_final_moviles_2021.fragmentHome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proy_final_moviles_2021.databinding.FragmentHomefragmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.json.JSONObject


class Homefragment : Fragment() {
    private lateinit var binding: FragmentHomefragmentBinding
    private lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomefragmentBinding.inflate(inflater,container,false)
        //enviar Argumentos
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDB = FirebaseDatabase.getInstance()
        database = myDB.reference
        binding.btnSet.setOnClickListener {
            val random=(0..100).random()
            writeNewUser(binding.etId.text.toString(),binding.etNombre.text.toString(),binding.etNombreUsuario.text.toString(),random.toString(),"0")
        }
        binding.btnGet.setOnClickListener {
            val json =  getUser(binding.etNombredeUsuarioGet.text.toString())
        }
        //val pokemon=Pokemon(1,"Charmander","Fuego","100","50","60","llamarada","puño fuego","Escudo","ROca igniante")
        //database.child("users").child("id").child("pokemones").child("3").setValue(pokemon)
    }
    fun writeNewUser(id:String,nombre:String,nombreusuario:String,nivel:String,capturados:String){
        val user = User(id,nombre,nombreusuario,nivel,capturados)
        database.child("users").child(nombreusuario).setValue(user)
    }
    fun getUser(nombreusuario: String){
        database.child("users").child(nombreusuario).get().addOnSuccessListener { record ->
            val json = JSONObject(record.value.toString())
            Log.d("Valores","got vale ${json}")

            binding.tv.text = "El Id es:${json.getString("id")}\n" +
                    "Nombre:${json.getString("nombre")}\n" +
                    "Usuario:${json.getString("nombreusuario")}\n" +
                    "Nivel:${json.getString("nivel")}\n" +
                    "Pokemones atrapados:${json.getString("capturados")}\n"


        }
    }
}