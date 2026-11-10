package com.jezdevcode.hymnairelldm.recyclerView

import android.content.Context
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
class HymnaireListAdapter(private cal context: Context,
                          private val titles: List<String>
                         ) : RexyclerView.Adapter<HymnaireListAdapter.HymnaireListViewHolder>() {
    
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
        val title = titles[position]
        
        holder.tvHymnTitle.text = title
        
        holder.cvListItem.setOncClickListener{
        }
    }
    
    override fun getItemCount(): Int {
        return titles.size
    }
}
