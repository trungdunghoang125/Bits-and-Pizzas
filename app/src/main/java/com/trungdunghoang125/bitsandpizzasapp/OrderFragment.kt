package com.trungdunghoang125.bitsandpizzasapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        // Display appbar name on Material Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        // FAB setOnClickListener
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // code to execute when fab is click
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
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
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                val chilli = view.findViewById<Chip>(R.id.chilli_oil)
                if (parmesan.isChecked) text += ", extra parmesan"
                if (chilli.isChecked) text += ", extra chilli oil"
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }
}