package com.mockdroid.loginnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mockdroid.loginnavigation.R
import kotlinx.android.synthetic.main.fragment_register2.*

class Register2Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_finish.setOnClickListener(this)
        tv_back.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_finish -> navController.navigate(R.id.action_register2Fragment_to_resultFragment)
            R.id.tv_back -> activity?.onBackPressed()
        }
    }
}