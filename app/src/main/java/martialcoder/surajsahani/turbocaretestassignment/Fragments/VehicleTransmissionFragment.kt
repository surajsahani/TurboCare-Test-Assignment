package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_vehicle_transmission.view.*
import kotlinx.android.synthetic.main.fragment_vehicle_transmission.view.img_back
import martialcoder.surajsahani.turbocaretestassignment.R

class VehicleTransmissionFragment : Fragment() {

    private lateinit var view1: View
    private var veh_number = ""
    private var veh_type = ""
    private var veh_make = ""
    private var veh_model = ""
    private var veh_transmission = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_transmission, container, false)
        veh_type = arguments?.getString("veh_type").toString()
        veh_make = arguments?.getString("veh_make").toString()
        veh_number = arguments?.getString("veh_number").toString()
        veh_model = arguments?.getString("veh_model").toString()
        init()
        view1.img_back.setOnClickListener{requireActivity().onBackPressed()}
        return view1
    }

    private fun init() {
        view1.rl_auto.setOnClickListener {
            veh_transmission = "Automatic"
            vehicleProfile(veh_transmission)
        }
        view1.rl_manual.setOnClickListener {
            veh_transmission = "Manual"
            vehicleProfile(veh_transmission)
        }

    }

    private fun vehicleProfile(transmission:String) {
        var bundle = Bundle()
        bundle.putString("veh_type",veh_type)
        bundle.putString("veh_make",veh_make)
        bundle.putString("veh_number",veh_number)
        bundle.putString("veh_model",veh_model)
        bundle.putString("veh_transmission",transmission)
        Navigation.findNavController(view1).navigate(R.id.action_vehicleTransmissionFragment_to_fuelTypeFragment,bundle)
    }


}