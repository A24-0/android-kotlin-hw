package com.example.myapplication

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import com.example.myapplication.databinding.FirstFragmentBinding
import java.util.Date

class FirstFragment : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    private lateinit var timer: CountDownTimer
    private var tm: Int = 0

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FirstFragmentBinding.inflate(inflater, container, false)
        timer = object: CountDownTimer(20000, 1000) {
            @SuppressLint("SimpleDateFormat")
            override fun onTick(millisUntilFinished: Long) {
                val sdf = SimpleDateFormat("\nyyyy-M-dd'T'hh:mm:ss'Z'\n".plus(tm.toString()))
                val currentDate = sdf.format(Date())
                addText(binding.textviewFirst, currentDate)
            }

            override fun onFinish() {
                addText(binding.textviewFirst,"Ura")
            }
        }
        return binding.root

    }

    private fun addText(cmpnnt: TextView, txt: String) {
        cmpnnt.text = cmpnnt.text.toString().plus(txt)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.buttonFirst.setOnClickListener {
            addText(binding.textviewFirst,"\nStart\n")
            timer.start()
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}