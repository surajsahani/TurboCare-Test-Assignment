package martialcoder.surajsahani.turbocaretestassignment.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_vehicle_number.*
import kotlinx.android.synthetic.main.fragment_vehicle_number.view.*
import martialcoder.surajsahani.turbocaretestassignment.R


class VehicleNumberFragment : Fragment() {

    private lateinit var view1: View
    private var veh_type = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_vehicle_number, container, false)
        veh_type = arguments?.getString("veh_type").toString()
        init()
        return view1
    }

    private fun init() {
        view1.img_back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        view1.fab_next.setOnClickListener {
            var veh_number = view1.ed_vehicle_number.text.toString()
            var bundle = Bundle()
            bundle.putString("veh_type",veh_type)
            bundle.putString("veh_number",veh_number)
            Navigation.findNavController(view1).navigate(R.id.action_vehicleNumberFragment_to_vehicleMakeFragment,bundle)

        }

        view1.ed_vehicle_number.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0){
                    view1.fab_next.visibility = View.VISIBLE
                }
                else{
                    view1.fab_next.visibility = View.GONE
                }
            }

        })
    }

}