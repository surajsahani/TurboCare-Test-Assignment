package martialcoder.surajsahani.turbocaretestassignment.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.vehicles_list.view.*
import martialcoder.surajsahani.turbocaretestassignment.Model.VehiclesListModelItem
import martialcoder.surajsahani.turbocaretestassignment.R


class AdapterVehicles(var context: Context, var list: ArrayList<VehiclesListModelItem>, var select: Select) : RecyclerView.Adapter<AdapterVehicles.ViewHolder>() {
    interface Select{
        fun vehicle(position: Int)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vehicles_list,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_veh_number.text = list[position].vehicleNumber
        holder.itemView.txt_veh_model.text = list[position].vehicleMake+" "+list[position].vehicleModel
        holder.itemView.setOnClickListener {
            select.vehicle(position)
        }
    }
}