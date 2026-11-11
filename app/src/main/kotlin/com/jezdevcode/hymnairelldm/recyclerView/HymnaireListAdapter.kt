package com.jezdevcode.hymnairelldm.recyclerView

import android.content.Context
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import android.view.View
import android.view.LayoutInflater
import com.jezdevcode.hymnairelldm.R
import android.widget.TextView
import androidx.core.text.HtmlCompat

class HymnaireListAdapter(private val context: Context,
                          private val numbers: List<String>,
                          private val titles: List<String>
                         ) : RecyclerView.Adapter<HymnaireListAdapter.HymnaireListViewHolder>() {
    
    //Representa una tarjeta individual del RecyclerView                     
    class HymnaireListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val cvListItem: CardView = itemView.findViewById(R.id.cv_hymnaire_list_activity)
        val tvHymnTitle: TextView = itemView.findViewById(R.id.tv_hymn_title)
    }
    
    //se ejecuta cuando un RecyclerView necesita crearuna tarjeta nueva
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HymnaireListViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_rv_hymnaire_list_activity, parent, false)
        
        return HymnaireListViewHolder(view)
    }
    
    //Se ejecuta para colocar los datos dentro de una tarjeta
    override fun onBindViewHolder(holder: HymnaireListViewHolder, position: Int){
        val number = HtmlCompat.fromHtml(numbers[position], HtmlCompat.FROM_HTML_MODE_LEGACY)
        val title = HtmlCompat.fromHtml(titles[position], HtmlCompat.FROM_HTML_MODE_LEGACY)
        
        // En onBindViewHolder del adapter:
        holder.tvHymnTitle.text = "$number. $title"
        
        //holder.tvHymnTitle.text = title
        
        holder.cvListItem.setOnClickListener{
        }
    }
    
    override fun getItemCount(): Int {
        return titles.size
    }
}
