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

class HomePastPaperAdapter : RecyclerView.Adapter<HomePastPaperAdapter.ViewHolder>() {
    private val titles = arrayOf(
        "හැඳින්වීම",
        "සෑම විෂයකම පසුගිය විභාග පත්\u200Dර ",
        "පෙළපොත් ",
        "ගණිත සූත්\u200Dර ",
        "ජ්\u200Dයාමිතිය ප්\u200Dරමේයය 42 එක පොකුරට ",
        "01 කොටස - O/l ගණිත ගැටළු",
        "ගණිත ගැටලු විසදීමේ කෙටි ක්\u200Dරම",
        "එක් එක් පාඩමට අදාළව ගණිත ගැටලු සහ පිළිතුරු",
        "අනුමාන ප්\u200Dරශ්න පත්\u200Dර",
        "පසුගිය පළාත් ප්\u200Dරශ්න පත්\u200Dර"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_past_papers, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titles[position]

        holder.bind(title)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    when (position) {
                        0 -> openFragment(context, HomeIntroFragment())
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
        ) {
            itemTitle.text = title
        }
    }
}
