package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.Singleton
import martialcoder.surajsahani.turbocaretestassignment.Model.VehiclesListModelItem
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.App
import kotlinx.android.synthetic.main.fragment_vehicle_profile.view.*
import kotlinx.android.synthetic.main.vechiles_type_list.view.*
import martialcoder.surajsahani.turbocaretestassignment.R


class VehicleProfileFragment : Fragment() {

    private lateinit var view1: View
    private var veh_number = ""
    private var veh_type = ""
    private var veh_make = ""
    private var veh_model = ""
    private var veh_transmission = ""
    private var fuel_type = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_profile, container, false)
        if (Singleton.savedStatus=="1"){
            savedData()
        }
        else{
            realtimeData()
            addDataToList()
        }
        view1.img_back.setOnClickListener{requireActivity().onBackPressed()}
        view1.img_home.setOnClickListener { Navigation.findNavController(view1).navigate(R.id.action_vehicleProfileFragment_to_veliclesFragment) }
        setProfileData()
        return view1
    }

    private fun realtimeData() {
        veh_type = arguments?.getString("veh_type").toString()
        veh_make = arguments?.getString("veh_make").toString()
        veh_number = arguments?.getString("veh_number").toString()
        veh_model = arguments?.getString("veh_model").toString()
        veh_transmission = arguments?.getString("veh_transmission").toString()
        fuel_type = arguments?.getString("fuel_type").toString()
    }

    private fun savedData() {
        veh_type = Singleton.veh_type.toString()
        veh_make = Singleton.veh_make.toString()
        veh_number = Singleton.veh_number.toString()
        veh_model = Singleton.veh_model.toString()
        veh_transmission = Singleton.veh_transmission.toString()
        fuel_type = Singleton.fuel_type.toString()
    }

    private fun addDataToList() {
        var vehiclesListModelItem = VehiclesListModelItem(veh_number,veh_make,veh_model,veh_transmission,fuel_type,veh_type)
        VeliclesFragment.vehicle_list.add(vehiclesListModelItem)
        App.getAppPreference()?.SaveVehicleList(requireActivity(), VeliclesFragment.vehicle_list)

    }

    private fun setProfileData() {
        view1.pro_title.text = "$veh_model $fuel_type"
        view1.txt_number.text = veh_number
        view1.txt_make.text = veh_make
        view1.txt_model.text = veh_model
        view1.txt_fuel_type.text = fuel_type
        view1.txt_transmission.text = veh_transmission
    }


}

