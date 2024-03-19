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

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
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
    private val details = arrayOf(
        "Intro",
        "All past papers",
        "Text books",
        "Maths formula",
        "Geometry all theorem",
        "Section 01 - O/l Math Problems",
        "Shortcuts",
        "maths questions and answers",
        "Guess Papers",
        "Previous Provincial Papers"
    )
    private val introDetails = arrayOf(
        "පළමුව හැඳින්වීම කියවන්න",
        "සිංහල මාධ්\u200Dයය",
        "සිංහල මාධ්\u200Dයය",
        "6-11 සියලු ගණිත සූත්\u200Dර ඇතුලත්වේ ",
        "සිංහල මාධ්\u200Dයය",
        "Quiz ප්\u200Dරශ්න පත්\u200Dර",
        "අඩු කාලයකින් ගණන නිම කිරීමට මෙය වැදගත් වේ",
        "සිංහල මාධ්\u200Dයය",
        "පිළිතුරු ද ඇතුළත් වේ",
        "සිංහල මාධ්\u200Dයය"
    )
    private val introSecondDetails = arrayOf(
        "",
        "English medium",
        "English medium",
        "",
        "English medium",
        "එවලේම පිළිතුරු",
        "",
        "",
        "",
        "English medium"
    )
    private val images = intArrayOf(
        R.drawable.untitled_design__13_,
        R.drawable.untitled_design__14_,
        R.drawable.untitled_design__15_,
        R.drawable.untitled_design__16_,
        R.drawable.untitled_design__17_,
        R.drawable.untitled_design__18_,
        R.drawable.untitled_design__19_,
        R.drawable.untitled_design__20_,
        R.drawable.untitled_design__21_,
        R.drawable.untitled_design__22_
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titles[position]
        val detail = details[position]
        val introDetail = introDetails[position]
        val introSecondDetail = introSecondDetails[position]
        val image = images[position]

        holder.bind(title, detail, introDetail, introSecondDetail, image)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        private val itemDetail: TextView = itemView.findViewById(R.id.item_detail)
        private val itemIntroDetail: TextView = itemView.findViewById(R.id.item_introDetail)
        private val itemIntroSecondDetail: TextView =
            itemView.findViewById(R.id.item_introSecondDetail)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    when (position) {
                        0 -> openFragment(context, HomeIntroFragment())
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
            introDetail: String,
            introSecondDetail: String,
            image: Int
        ) {
            itemTitle.text = title
            itemDetail.text = detail
            itemIntroDetail.text = introDetail
            itemIntroSecondDetail.text = introSecondDetail
            itemImage.setImageResource(image)
        }
    }
}
