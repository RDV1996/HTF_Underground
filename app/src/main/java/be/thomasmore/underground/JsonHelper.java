package be.thomasmore.underground;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    public List<Terrorist> getTerrorists(String jsonTekst) {
        List<Terrorist> terrorists = new ArrayList<>();

        try {
            JSONObject jsonTerrorist = new JSONObject(jsonTekst);
            JSONArray jsonArrayTerrorists = new JSONArray("Terrorists");
            for (int i = 0; i < jsonArrayTerrorists.length(); i++) {
                JSONObject jsonObjectTerrorist = jsonArrayTerrorists.getJSONObject(i);

                Terrorist terrorist = new Terrorist();
                terrorist.setId(jsonObjectTerrorist.getString("id"));
                terrorist.setName(jsonObjectTerrorist.getString("name"));
                terrorist.setRiskLevel(jsonObjectTerrorist.getString("riskLevel"));
                terrorist.setRank(jsonObjectTerrorist.getInt("rank"));

                terrorists.add(terrorist);
            }
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return terrorists;
    }
}
