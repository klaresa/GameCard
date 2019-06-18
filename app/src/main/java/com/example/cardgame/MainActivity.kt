package com.example.cardgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var morte: List<ImageView>
        lateinit var lifeCard: ImageView
        lateinit var sorteado: ImageView

        card1_imageView.setOnClickListener {


            lifeCard = retornar()

            // verificando se a carta vida eh a mesma que a imageView selecionada
            // if (lifeCard == card1_imageView)
            morte = comparar(lifeCard)
            sorteado = card1_imageView
        }

        card2_imageView.setOnClickListener {


            lifeCard = retornar()

            morte = comparar(lifeCard)
            sorteado = card2_imageView
        }

        card3_imageView.setOnClickListener {


            lifeCard = retornar()
            morte = comparar(lifeCard)
            sorteado = card3_imageView
        }

        confirm_button.setOnClickListener {

            if (lifeCard == sorteado) {

                sorteado.setImageResource(R.drawable.likeaboss)
                result_textView.setText(getString(R.string.you_win))
                result_textView.visibility = View.VISIBLE
                restart_button.visibility = View.VISIBLE

            } else {

                result_textView.setText(getString(R.string.you_lose))
                result_textView.visibility = View.VISIBLE
                restart_button.visibility = View.VISIBLE

                for (items in morte) {
                    items.setImageResource(R.drawable.death)
                }
            }
        }

        restart_button.setOnClickListener {
            result_textView.setText("")
            restart_button.visibility = View.INVISIBLE

            var listaCartas = mutableListOf(card1_imageView, card2_imageView, card3_imageView)
            for (items in listaCartas) {
                items.setImageResource(R.drawable.backcard)
            }
        }
    }

    fun retornar(): ImageView {
        var listaCartas = mutableListOf(card1_imageView, card2_imageView, card3_imageView)
        var sorteado = listaCartas.random()
        return sorteado
    }


    fun comparar(card: ImageView): List<ImageView> {
        var lista = mutableListOf<ImageView>(card1_imageView, card2_imageView, card3_imageView)
        lista.remove(card)

        return lista
    }
}