package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import martialcoder.surajsahani.turbocaretestassignment.Adapters.AdapterVehicleMakers
import martialcoder.surajsahani.turbocaretestassignment.ViewModel.VehiclesMvvm
import kotlinx.android.synthetic.main.fragment_vehicle_make.view.*
import kotlinx.android.synthetic.main.fragment_vehicle_make.view.img_back
import martialcoder.surajsahani.turbocaretestassignment.R


class VehicleMakeFragment : Fragment(), AdapterVehicleMakers.Select {

    private lateinit var view1: View
    private lateinit var list:ArrayList<String>
    private var veh_type = ""
    private var veh_number = ""
    private lateinit var vehiclesMvvm: VehiclesMvvm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_make, container, false)
        vehiclesMvvm = ViewModelProviders.of(this@VehicleMakeFragment).get(VehiclesMvvm::class.java)
        veh_type = arguments?.getString("veh_type").toString()
        veh_number = arguments?.getString("veh_number").toString()
        view1.img_back.setOnClickListener{requireActivity().onBackPressed()}
        getMakeVehicles()
        return view1
    }

    private fun getMakeVehicles() {
        vehiclesMvvm.vehicleMakeList(requireActivity(),veh_type).observe(requireActivity(), Observer {
            list = it
            view1.veh_maker_recycler.adapter = AdapterVehicleMakers(requireActivity(),list,this)
        })
    }

    override fun makeSelect(position: Int, make: String) {
        var bundle = Bundle()
        bundle.putString("veh_type",veh_type)
        bundle.putString("veh_number",veh_number)
        bundle.putString("veh_make",make)
        Navigation.findNavController(view1).navigate(R.id.action_vehicleMakeFragment_to_vehicleModelFragment,bundle)
    }


}