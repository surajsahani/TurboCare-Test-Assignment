package martialcoder.surajsahani.turbocaretestassignment.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.veh_make_list.view.*
import martialcoder.surajsahani.turbocaretestassignment.R


class AdapterVehicleModels(var context: Context,var list: ArrayList<String>,var select: Select): RecyclerView.Adapter<AdapterVehicleModels.ViewHolder>() {
    interface Select{
        fun modelSelect(model:String)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.veh_make_list,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_brand.text = list[position]
        holder.itemView.setOnClickListener {
            select.modelSelect(list[position])
        }
    }
}