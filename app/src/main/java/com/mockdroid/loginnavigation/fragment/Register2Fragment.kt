package com.mockdroid.loginnavigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mockdroid.loginnavigation.R
import kotlinx.android.synthetic.main.fragment_register2.*

class Register2Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    var get_name: String? = null
    var get_email: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        get_name = arguments?.getString("name")
        get_email = arguments?.getString("email")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_finish.setOnClickListener(this)
        tv_back.setOnClickListener(this)
        tv_hello.text = "Halo $get_name, untuk melanjutkan register silahkan isi password dibawah"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_finish -> {
                if (edt_password.text.toString().isEmpty()) {
                    edt_password.error = "Password tidak boleh kosong"
                } else if (edt_confirm_password.text.toString().isEmpty()) {
                    edt_confirm_password.error = "Confirmation Password tidak boleh kosong"
                } else {
                    if (edt_password.text.toString().equals(edt_confirm_password.text.toString())) {
                        val bundle = bundleOf(
                            "name" to get_name,
                            "email" to get_email
                        )
                        navController.navigate(
                            R.id.action_register2Fragment_to_resultFragment,
                            bundle
                        )
                    } else {
                        Toast.makeText(
                            context,
                            "Password tidak sama dengan confirmation password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            R.id.tv_back -> activity?.onBackPressed()
        }
    }
}