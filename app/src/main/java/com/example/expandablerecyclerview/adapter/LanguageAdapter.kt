package com.example.expandablerecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.R
import com.example.expandablerecyclerview.model.LanguageData

class LanguageAdapter(private val languageList: List<LanguageData>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.titleTv)
        var logo: ImageView = itemView.findViewById(R.id.logoIv)
        var message: TextView = itemView.findViewById(R.id.messageTv)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expandableLayout: ConstraintLayout = itemView.findViewById(R.id.expandableLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val languageData = languageList[position]
        holder.title.text = languageData.title
        holder.logo.setImageResource(languageData.logo)
        holder.message.text = languageData.message

        val isExpandable = languageData.expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            isAnyItemExpanded(position)
            languageData.expandable = !languageData.expandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = languageList.indexOfFirst {
            it.expandable
        }
        if (temp >= 0 && temp != position) {
            languageList[temp].expandable = false
            notifyItemChanged(temp, 0)
        }
    }
}