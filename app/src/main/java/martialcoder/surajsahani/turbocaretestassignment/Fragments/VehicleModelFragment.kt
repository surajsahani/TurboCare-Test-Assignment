package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import martialcoder.surajsahani.turbocaretestassignment.Adapters.AdapterVehicleModels
import martialcoder.surajsahani.turbocaretestassignment.ViewModel.VehiclesMvvm
import kotlinx.android.synthetic.main.fragment_vehicle_model.view.*
import kotlinx.android.synthetic.main.fragment_vehicle_model.view.img_back
import martialcoder.surajsahani.turbocaretestassignment.R


class VehicleModelFragment : Fragment(), AdapterVehicleModels.Select {

    private lateinit var view1: View
    private var veh_type = ""
    private var veh_make = ""
    private var veh_number = ""
    private lateinit var vehiclesMvvm: VehiclesMvvm
    private lateinit var model_list:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_model, container, false)
        vehiclesMvvm = ViewModelProviders.of(this@VehicleModelFragment).get(VehiclesMvvm::class.java)
        veh_type = arguments?.getString("veh_type").toString()
        veh_make = arguments?.getString("veh_make").toString()
        veh_number = arguments?.getString("veh_number").toString()
        view1.img_back.setOnClickListener{requireActivity().onBackPressed()}
        getVehicleModels()
        return view1
    }

    private fun getVehicleModels() {
        vehiclesMvvm.vehicleModelList(requireActivity(),veh_type,veh_make).observe(requireActivity(),
            Observer {
                model_list = it
                view1.veh_model_recycler.adapter = AdapterVehicleModels(requireActivity(),model_list,this)
            })
    }

    override fun modelSelect(model: String) {
        val bundle = Bundle()
        bundle.putString("veh_type",veh_type)
        bundle.putString("veh_make",veh_make)
        bundle.putString("veh_number",veh_number)
        bundle.putString("veh_model",model)
        Navigation.findNavController(view1).navigate(R.id.action_vehicleModelFragment_to_vehicleTransmissionFragment,bundle)
    }


}