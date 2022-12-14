package com.example.challengemodeloparcial.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.challengemodeloparcial.R
import com.example.challengemodeloparcial.activities.SettingsActivity
import com.example.challengemodeloparcial.entities.Product

class TerceraPantalla : Fragment() {

    private lateinit var v: View
    private lateinit var photoImg: ImageView
    private lateinit var nameMovie: TextView
    private lateinit var catMovie: TextView
    private lateinit var ageMovie: TextView
    private lateinit var priceMovie: TextView
    private lateinit var product: Product
    private lateinit var btbBack: Button
    private lateinit var btnImg: ImageButton
    //private lateinit var mListener: HomeListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        product = TerceraPantallaArgs.fromBundle(requireArguments()).product

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tercera_pantalla, container, false)

        btbBack = v.findViewById(R.id.id_btn_back_detail)
        photoImg = v.findViewById(R.id.id_photo_profile)
        nameMovie = v.findViewById(R.id.id_change_name_profile)
        catMovie = v.findViewById(R.id.id_change_cat_profile)
        ageMovie = v.findViewById(R.id.id_change_age_profile)
        priceMovie = v.findViewById(R.id.id_change_price_profile)
        btnImg = v.findViewById(R.id.id_btn_settings)

        return v
    }

    override fun onStart() {
        super.onStart()

        btbBack.setOnClickListener {
            var a = TerceraPantallaDirections.actionTerceraPantallaToListProductFragment()
            v.findNavController().navigate(a)
        }
        Glide.with(photoImg.context).load(product.urlImage).into(photoImg)
        nameMovie.text = product.nombre
        catMovie.text = product.categoria
        ageMovie.text = product.anio.toString()
        priceMovie.text = product.precio.toString()

        btnImg.setOnClickListener {
            //Cargo el metodo de la interface
            //mListener.sendData("Hola")
            startActivity(Intent(context, SettingsActivity::class.java))
        }
    }

}