package com.thomasceballos.sesionroom.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.thomasceballos.sesionroom.R
import com.thomasceballos.sesionroom.SesionROOM
import kotlinx.android.synthetic.main.fragment_delete.*
import kotlinx.android.synthetic.main.fragment_update.*

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_borrar.setOnClickListener {
            val nombre = et_nombre4.text.toString()

            val deudorDAO = SesionROOM.database.DeudorDAO()
            val deudor = deudorDAO.buscarDeudor(nombre)

            if(deudor != null){
                deudorDAO.borrarDeudor(deudor)
                et_nombre4.setText("")
            }else{
                Toast.makeText(context, "Deudor no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }

}