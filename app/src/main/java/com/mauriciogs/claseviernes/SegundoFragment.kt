package com.mauriciogs.claseviernes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mauriciogs.claseviernes.databinding.FragmentSegundoBinding
import com.mauriciogs.claseviernes.databinding.PrimerFragmentoBinding
import java.text.FieldPosition

class SegundoFragment : Fragment() {

    private var _binding : FragmentSegundoBinding? = null
    private val binding get() = _binding!!

    private val listaPaises = listOf<String>(
        "Mexico",
        "Argentina",
        "España",
        "Colombia",
        "Canada",
        "Venezuela",
        "Brasil"
    )

    data class Usuarios(
        val username : String,
        val pawssword : String
    )

    private val listaUsuarios = listOf<Usuarios>(
        Usuarios("Mauricio","123"),
        Usuarios("Fernando","123")

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSegundoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciliza()
    }

    private fun iniciliza() {
        binding.btnFrag2.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Mi primer dialogo")
                .setMessage("Este es un mensaje a pantalla mediante un Dialog con MD3")
                .setNegativeButton("Cancelar"){ dialog, which ->

                }
                .setNeutralButton("Rechazar"){ dialog, which ->

                }
                .setPositiveButton("Aceptar"){ dialog, which ->

                }
                .show()
        }

        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaPaises)
        binding.spinner.adapter = adaptador

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvFrag2.text = listaPaises[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

}