package com.example.turbocare.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.vechiles_type_list.view.*
import martialcoder.surajsahani.turbocaretestassignment.R


class AdapterVehiclesType(var context: Context,var select:Select): RecyclerView.Adapter<AdapterVehiclesType.ViewHolder>() {
    interface Select{
        fun type(position: Int)
    }
    private var index = -1
    var title_list = arrayOf("Two Wheeler","Four Wheeler")
    var img_list = arrayOf(R.drawable.ic_scooter,R.drawable.ic_car)
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vechiles_type_list,parent,false))
    }

    override fun getItemCount(): Int {
        return img_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_vehicle_title.text = title_list[position]
        holder.itemView.img_vehicle.setImageResource(img_list[position])

        holder.itemView.setOnClickListener {
            index = position
            select.type(position)
            notifyDataSetChanged()
        }

        if (position == 0 && index == -1) {
            holder.itemView.card_vehicles.setCardBackgroundColor(context.resources.getColor(R.color.light_purple))
        }
        if (index != -1) {
            if (index == position) {
                holder.itemView.card_vehicles.setCardBackgroundColor(context.resources.getColor(R.color.light_purple))
            } else {
                holder.itemView.card_vehicles.setCardBackgroundColor(context.resources.getColor(R.color.white))
            }
        }
    }
}