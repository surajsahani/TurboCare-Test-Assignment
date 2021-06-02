package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fuel_type.view.*
import martialcoder.surajsahani.turbocaretestassignment.R
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.Singleton



class FuelTypeFragment : Fragment() {

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
        view1 = inflater.inflate(R.layout.fragment_fuel_type, container, false)
        veh_type = arguments?.getString("veh_type").toString()
        veh_make = arguments?.getString("veh_make").toString()
        veh_number = arguments?.getString("veh_number").toString()
        veh_model = arguments?.getString("veh_model").toString()
        veh_transmission = arguments?.getString("veh_transmission").toString()
        init()
        return view1
    }

    private fun init() {
        view1.rl_petrol.setOnClickListener {
            fuel_type = "Petrol"
            vehicleProfile(fuel_type)
        }
        view1.rl_diesel.setOnClickListener {
            fuel_type = "Diesel"
            vehicleProfile(fuel_type)
        }

    }

    private fun vehicleProfile(fuelType:String) {
        Singleton.savedStatus = "0"
        var bundle = Bundle()
        bundle.putString("veh_type",veh_type)
        bundle.putString("veh_make",veh_make)
        bundle.putString("veh_number",veh_number)
        bundle.putString("veh_model",veh_model)
        bundle.putString("veh_transmission",veh_transmission)
        bundle.putString("fuel_type",fuelType)
        Navigation.findNavController(view1).navigate(R.id.action_fuelTypeFragment_to_vehicleProfileFragment,bundle)
    }

}