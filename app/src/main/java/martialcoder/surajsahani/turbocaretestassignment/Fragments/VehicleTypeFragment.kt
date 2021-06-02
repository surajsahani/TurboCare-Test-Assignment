package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.turbocare.Adapters.AdapterVehiclesType
import martialcoder.surajsahani.turbocaretestassignment.Model.VehiclesListModelItem
import kotlinx.android.synthetic.main.fragment_vehicle_type.view.*
import kotlinx.android.synthetic.main.fragment_vehicle_type.view.img_back
import martialcoder.surajsahani.turbocaretestassignment.R


class VehicleTypeFragment : Fragment(), AdapterVehiclesType.Select {

    private lateinit var view1: View
    private var veh_type = "2w"
    private lateinit var list: ArrayList<VehiclesListModelItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_type, container, false)
        init()
        return view1
    }

    private fun init() {
        view1.vehicles_type_recycler.adapter = AdapterVehiclesType(requireActivity(),this)
        view1.fab_next.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("veh_type",veh_type)
            Navigation.findNavController(view1).navigate(R.id.action_vehicleTypeFragment_to_vehicleNumberFragment,bundle)
        }
        view1.img_back.setOnClickListener{requireActivity().onBackPressed()}
    }

    override fun type(position: Int) {
        if (position == 0){
            veh_type = "2w"

        }
        else{
            veh_type = "4w"
        }
    }

}