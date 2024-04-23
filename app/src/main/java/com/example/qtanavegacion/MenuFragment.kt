package com.example.qtanavegacion
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.qtanavegacion.databinding.FragmentMenuBinding

class MenuFragment : Fragment(){
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false) // Se infla el binding
        return binding.root // Se retorna la raíz del binding)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        // Encuentra el NavController para el NavHostFragment interno
        val navController = findNavController()

        // Configura el BottomNavigationView para que funcione con el NavController
        binding.navView.setupWithNavController(navController)

        replaceFragment(DosPalabras())
        binding.navView.setOnItemSelectedListener {
            when(it.itemId){ //listener para cada vista con su id
                R.id.dosPalabras -> replaceFragment(DosPalabras())
                R.id.dosMitades-> replaceFragment(DosMitades())
                R.id.quitarFragmento -> replaceFragment(QuitarFragmento())

                else ->{}
            }
            true //devuelve la vista principal por defecto, en este caso Home
        }
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navigationHostFragment2,fragment)
        fragmentTransaction.commit()
    }

}
