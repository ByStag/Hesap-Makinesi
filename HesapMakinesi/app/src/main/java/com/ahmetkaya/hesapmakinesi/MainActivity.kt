package com.ahmetkaya.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ahmetkaya.hesapmakinesi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button0.setOnClickListener {
            binding.textViewGirilenSayilar.append("0")
        }
        binding.button1.setOnClickListener {
            binding.textViewGirilenSayilar.append("1")
        }
        binding.button2.setOnClickListener {
            binding.textViewGirilenSayilar.append("2")
        }
        binding.button3.setOnClickListener {
            binding.textViewGirilenSayilar.append("3")
        }
        binding.button4.setOnClickListener {
            binding.textViewGirilenSayilar.append("4")
        }
        binding.button5.setOnClickListener {
            binding.textViewGirilenSayilar.append("5")
        }
        binding.button6.setOnClickListener {
            binding.textViewGirilenSayilar.append("6")
        }
        binding.button7.setOnClickListener {
            binding.textViewGirilenSayilar.append("7")
        }
        binding.button8.setOnClickListener {
            binding.textViewGirilenSayilar.append("8")
        }
        binding.button9.setOnClickListener {
            binding.textViewGirilenSayilar.append("9")
        }
        binding.buttonToplama.setOnClickListener {
            binding.textViewGirilenSayilar.append("+")
        }

        binding.buttonAC.setOnClickListener {
            binding.textViewSonuc.text = ""
            binding.textViewGirilenSayilar.text = ""
        }

        binding.buttonSilme.setOnClickListener {
            val girilenSayilar = binding.textViewGirilenSayilar.text.toString()

            if (girilenSayilar.isNotEmpty()){
                val yeniGirilenSayilar = girilenSayilar.substring(0, girilenSayilar.length-1)
                binding.textViewGirilenSayilar.text = yeniGirilenSayilar
            }else{
                binding.textViewGirilenSayilar.text = ""
            }
        }

        binding.buttonEsittir.setOnClickListener {
            try {
                val ifade = binding.textViewGirilenSayilar.text.toString()//Girilen ifadeyi al
                val sayilar = ifade.split("+")//+ işaretine göre ifadeyi parçala ve bir zidiye ata
                var toplam = 0

                for (sayi in sayilar){
                    val num = sayi.trim()//Boşlukları kaldır ve sayıyı al
                    if (num.isNotEmpty()){
                        toplam += num.toInt()
                    }
                }
                binding.textViewSonuc.text = toplam.toString()
            }catch (e:Exception){
                Log.e("Sorun","Mesaj : ${e.message}")
            }
        }
    }
}