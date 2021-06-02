package martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import martialcoder.surajsahani.turbocaretestassignment.Model.VehiclesListModelItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AppPrefrences {
    private static AppPrefrences appPreference;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefsEditor;

    private AppPrefrences(Context context, String DATABASE_NAME) {
        sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
    }

    public static AppPrefrences init(Context context, String DATABASE_NAME) {
        if (appPreference == null) {
            appPreference = new AppPrefrences(context, DATABASE_NAME);
        }
        return appPreference;
    }


    public void SaveVehicleList(Context context, List<VehiclesListModelItem> vehiclesListModelItems) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(vehiclesListModelItems);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("vehicles_list", jsonString);
        editor.apply();
    }

    public List<VehiclesListModelItem> GetVehiclesList(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = preferences.getString("vehicles_list","");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<VehiclesListModelItem>>(){}.getType();
        List<VehiclesListModelItem> list = gson.fromJson(jsonString,type);
        return list;
    }


    public void Logout() {
        sharedPreferences.edit().clear().apply();
    }

}
