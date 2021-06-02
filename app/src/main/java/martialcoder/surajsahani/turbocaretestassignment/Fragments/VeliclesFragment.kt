package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.Singleton
import martialcoder.surajsahani.turbocaretestassignment.Adapters.AdapterVehicles
import martialcoder.surajsahani.turbocaretestassignment.Model.VehiclesListModelItem
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.App
import kotlinx.android.synthetic.main.fragment_velicles.view.*
import martialcoder.surajsahani.turbocaretestassignment.R


class VeliclesFragment : Fragment(), AdapterVehicles.Select {

    private lateinit var view1: View
    companion object{
        public var vehicle_list:ArrayList<VehiclesListModelItem> = ArrayList()

    }
    private lateinit var adapterVehicles: AdapterVehicles

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_velicles, container, false)
        return view1
    }

    private fun init() {
        view1.vehicles_recycler.adapter = AdapterVehicles(requireActivity(), vehicle_list,this)
        view1.fab_add.setOnClickListener {
            Navigation.findNavController(view1).navigate(R.id.action_veliclesFragment_to_vehicleTypeFragment)
        }
        view1.txt_clear.setOnClickListener {
            vehicle_list.clear()
            App.appPreference1?.Logout()
            view1.vehicles_recycler.adapter?.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        if (App.appPreference1?.GetVehiclesList(requireActivity()) != null){
            vehicle_list = App.appPreference1?.GetVehiclesList(requireActivity()) as ArrayList<VehiclesListModelItem>
            view1.vehicles_recycler.adapter?.notifyDataSetChanged()
            Log.i(TAG, "onCreateView: $vehicle_list")
        }
        init()
    }

    override fun vehicle(position: Int) {
        Singleton.savedStatus = "1"
        Singleton.veh_number = vehicle_list[position].vehicleNumber
        Singleton.veh_make = vehicle_list[position].vehicleMake
        Singleton.veh_model = vehicle_list[position].vehicleModel
        Singleton.veh_transmission = vehicle_list[position].vehicleTransmission
        Singleton.fuel_type = vehicle_list[position].vehFuelType
        Singleton.veh_type = vehicle_list[position].veh_type
        Navigation.findNavController(view1).navigate(R.id.action_veliclesFragment_to_vehicleProfileFragment)
    }

}