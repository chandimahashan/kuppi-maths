package com.example.cuppimaths

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class HomePastpapersClickCardAdapter : RecyclerView.Adapter<HomePastpapersClickCardAdapter.ViewHolder>() {
    private val titles = arrayOf(
        "හැඳින්වීම",
        "සෑම විෂයකම පසුගිය විභාග පත්\u200Dර "
    )
    private val details = arrayOf(
        "Intro",
        "All past papers"

    )

    private val images = intArrayOf(
        R.drawable.untitled_design__13_,
        R.drawable.untitled_design__14_

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titles[position]
        val detail = details[position]
        val image = images[position]

        holder.bind(title, detail, image)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        private val itemDetail: TextView = itemView.findViewById(R.id.item_detail)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    when (position) {
                        0 -> openFragment(context, HomePastPapersFragment() )
                        1 -> openFragment(context, HomePastPapersFragment())
                        // Add other cases for different positions if needed
                    }
                }
            }
        }



        private fun openFragment(context: Context, fragment: Fragment) {
            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }


        fun bind(
            title: String,
            detail: String,
            image: Int
        ) {
            itemTitle.text = title
            itemDetail.text = detail
            itemImage.setImageResource(image)
        }
    }
}
