package com.trungdunghoang125.bitsandpizzasapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.trungdunghoang125.bitsandpizzasapp.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private var _binding:FragmentOrderBinding? = null;
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.toolbar.setTitleTextColor(Color.WHITE)
        // Display appbar name on Material Toolbar
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        // FAB setOnClickListener

        binding.fab.setOnClickListener {
            // code to execute when fab is click
            val pizzaGroup = binding.pizzaGroup
            val pizzaType = pizzaGroup.checkedRadioButtonId
            // No pizza was selected
            if (pizzaType == -1) {
                // Display a toast message to remind user to choose a type of pizza
                val text = "You need to choose a pizza type"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            }
            else {
                var text = when(pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                }
                val parmesan = binding.parmesan
                val chilli = binding.chilliOil
                if (parmesan.isChecked) text += ", extra parmesan"
                if (chilli.isChecked) text += ", extra chilli oil"
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    // set _binding = null after fragment no longer inflate layout
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}