package com.example.myapplicationml.ui.avis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplicationml.R
import com.example.myapplicationml.databinding.FragmentAvisBinding
import com.example.myapplicationml.ui.AvisAdapter

class AvisFragment : Fragment() {

    private var _binding: FragmentAvisBinding? = null
    private val binding get() = _binding!!

    private lateinit var avis_list :List<AvisViewModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAvisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerview.id = R.id.recyclerview
        avisList()
        val adapter = AvisAdapter(avis_list)
        binding.recyclerview.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun avisList(){
        avis_list = listOf(
            AvisViewModel(5.00f,"Par Jérome Lepauvre", "Aspects positifs : Professionnalisme, Rapport qualité-prix, Réactivité"),
            AvisViewModel(5.00f,"Par kevin jullien", "Aspects positifs : Professionnalisme, Qualité, Réactivité"),
            AvisViewModel(5.00f,"Par Sylvie Crignon", "Très bon travail sur mesure d'une porte pour une vieille bâtisse."),
            AvisViewModel(5.00f,"Par Alain Sever", "Pro et disponible pour SAV"),
            AvisViewModel(5.00f,"Par Marie Christine Poirier","Mr Lemoine est une personne qui sait écouter les besoins de ses clients et qui vient au moindre problème je recommande vivement"),
            AvisViewModel(5.00f,"Par Sandrine Jeanne","Artisan à recommander, à l'écoute de ses clients et travail soigné."),
            AvisViewModel(5.00f,"Par des Vifs Embruns Elevage","Un professionnel impliqué et digne de confiance."),
            AvisViewModel(5.00f,"Virginie Monnier",""),
            AvisViewModel(5.00f,"Aurélie Lemoine","")
        )
    }

}