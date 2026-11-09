package com.jezdevcode.hymnairelldm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jezdevcode.hymnairelldm.R
import com.jezdevcode.hymnairelldm.database.Hymn

class HymnAdapter(
    private val hymns: List<Hymn>
    private val onHymnClick: (Hymn) -> Unit
) : RecyclerView.Adapter<HymnAdapter.HymnViewHolder>(){

    class HymnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    
        val txtHymnNumber = itemView.findViewById<TextView>(R.id.txt_hymn_number)
        val txtHymnFrenchTitle = itemView.findViewById<TextView>(R.id.txt_hymn_french_title)
    }
    
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HymnViewHolder {
        
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_hymn_french_title,
            parent,
            false
        )
        return HymnViewHolder(view)
    }
    
    override fun onBindViewHolder(
        holder: HymnViewHolder,
        position: Int
    ) {
        val hymn = Hymns[position]
        
        holder.txtHymnNumber.text = hymn.hymnNumber.toString()
        
        holder.txtHymnFrenchTitle.text = hymn.hymnFrenchTitle
        
        holder.itemView.setOnClickListener {
            onHymnClick(hymn)
        }
    }
    
    override fun getItemCount(): Int {
        return hymns.size
    }

}