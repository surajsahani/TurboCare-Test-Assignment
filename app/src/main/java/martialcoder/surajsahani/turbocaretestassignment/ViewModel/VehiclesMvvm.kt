package martialcoder.surajsahani.turbocaretestassignment.ViewModel

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import martialcoder.surajsahani.turbocaretestassignment.Retrofit.ApiClient
import martialcoder.surajsahani.turbocaretestassignment.Retrofit.ApiInterface
import martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences.CommonUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehiclesMvvm : ViewModel() {

    private val api = ApiClient.getClient()?.create(ApiInterface::class.java)

    private lateinit var vehicleMakeModelMutable:MutableLiveData<ArrayList<String>>
    fun vehicleMakeList(activity: Activity,classes:String):LiveData<ArrayList<String>>{
        vehicleMakeModelMutable = MutableLiveData()
        when{
            CommonUtils.isNetworkConnected(activity)->{
                CommonUtils.showProgress(activity,"Loading...")
                api?.getMakers(classes)?.enqueue(object :Callback<ArrayList<String>>{
                    override fun onFailure(call: Call<ArrayList<String>>?, t: Throwable?) {
                        CommonUtils.dismissProgress()
                        Toast.makeText(activity,t?.message,Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ArrayList<String>>?,
                        response: Response<ArrayList<String>>?
                    ) {
                        CommonUtils.dismissProgress()
                        if (response?.body()!=null){
                            vehicleMakeModelMutable.value = response.body()
                        }
                        else{
                            Toast.makeText(activity,"Body Null",Toast.LENGTH_SHORT).show()
                        }
                    }

                })
            }
            else -> {
                Toast.makeText(activity, "Check your internet connection", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return vehicleMakeModelMutable
    }

    private lateinit var vehicleModelMutable:MutableLiveData<ArrayList<String>>
    fun vehicleModelList(activity: Activity,classes:String,make:String):LiveData<ArrayList<String>>{
        vehicleModelMutable = MutableLiveData()
        when{
            CommonUtils.isNetworkConnected(activity)->{
                CommonUtils.showProgress(activity,"Loading...")
                api?.getModels(classes,make)?.enqueue(object :Callback<ArrayList<String>>{
                    override fun onFailure(call: Call<ArrayList<String>>?, t: Throwable?) {
                        CommonUtils.dismissProgress()
                        Toast.makeText(activity,t?.message,Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ArrayList<String>>?,
                        response: Response<ArrayList<String>>?
                    ) {
                        CommonUtils.dismissProgress()
                        if (response?.body()!=null){
                            vehicleModelMutable.value = response.body()
                        }
                        else{
                            Toast.makeText(activity,"Body Null",Toast.LENGTH_SHORT).show()
                        }
                    }

                })
            }
            else -> {
                Toast.makeText(activity, "Check your internet connection", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return vehicleModelMutable
    }
}