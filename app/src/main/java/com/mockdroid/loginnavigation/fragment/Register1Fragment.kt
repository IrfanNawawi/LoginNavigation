package com.mockdroid.loginnavigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mockdroid.loginnavigation.R
import kotlinx.android.synthetic.main.fragment_register1.*

class Register1Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_next.setOnClickListener(this)
        tv_back.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_next -> navController.navigate(R.id.action_register1Fragment_to_register2Fragment)
            R.id.tv_back -> activity?.onBackPressed()
        }
    }
}