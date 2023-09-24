package com.example.tugastiketpertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.tugastiketpertemuan6.R
import com.example.tugastiketpertemuan6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tiket = arrayOf(
            "First Class",
            "Business Class",
            "Economy Class"
        )

        val asal = arrayOf(
            "Yogyakarta",
            "Bali",
            "Jakarta",
            "Surabaya",
            "Bandung",
            "Batam",
            "Lombok"
        )

        val tujuan = arrayOf(
            "Jakarta",
            "Bandung",
            "Surabaya",
            "Singapore",
            "Surakarta",
            "Malaysia",
            "Yogyakarta"
        )

        with(binding){
            val jenistiketAdapter = ArrayAdapter(this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tiket)

            jenistiketAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            spinJenisTiket.adapter= jenistiketAdapter

            val asalAdapter = ArrayAdapter(this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,asal)

            asalAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            SpinText1.adapter= asalAdapter

            val tujuanAdapter = ArrayAdapter(this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tujuan)

            tujuanAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            SpinText2.adapter= tujuanAdapter

            var selectedDate = ""
            var selectedTime = ""

            datePick.init(datePick.year, datePick.month, datePick.dayOfMonth) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
            }

            timePicker.setOnTimeChangedListener { _, hourOfDay, minutes ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
            }

            val pesanButton = findViewById<Button>(R.id.button_pesan)

            pesanButton.setOnClickListener {
                val toastMessage =
                    "Tiket berhasil dipesan pada tanggal $selectedDate jam $selectedTime"
                Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT).show()
            }

        }

        }
    }
