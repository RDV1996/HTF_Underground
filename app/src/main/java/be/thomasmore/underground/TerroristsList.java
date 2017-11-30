package be.thomasmore.underground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import be.thomasmore.underground.classes.Terrorist;
import be.thomasmore.underground.rest.APIClient;
import be.thomasmore.underground.rest.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerroristsList extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrorists_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        String accesstoken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTIwNTUxNDUsImRhdGEiOnsidXNlciI6eyJpZCI6IjVhMTk4YTMyODBhZTM5NWYzMDRjZGJmZiIsInJvbGUiOjB9fSwiaWF0IjoxNTEyMDUzMzQ1fQ.gFtfmu5v5SHKicSVieqnF1doXCfn8lnQ-xFlJADYPKU";

        Call<List<Terrorist>> call = apiInterface.getTerrorists(accesstoken);
        call.enqueue(new Callback<List<Terrorist>>() {

            @Override
            public void onResponse(Call<List<Terrorist>> call, Response<List<Terrorist>> response) {

                List<Terrorist> terrorists = response.body();
                String terrorist = "";

                for (int i = 0; i < terrorists.size(); i++) {
                    terrorist += terrorists.get(i).getName();
                }

                responseText.setText(terrorist);
            }

            @Override
            public void onFailure(Call<List<Terrorist>> call, Throwable t) {
                call.cancel();
            }
        });
    }


    private void readTerrorists(String code)
    {
        /*HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                List<Terrorist> terrorists = jsonHelper.getTerrorists(result);
                String tekst = " - ";
                for (int i = 0; i < terrorists.size(); i++ ) {
                    tekst += terrorists.get(i).getName() + " - ";
                }
                toon(tekst);
            }
        });
        httpReader.execute("http://37.230.98.72/htf/api/terrorists");*/
    }

    private void toon(String text)
    {
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
    }

    /*
    private void showTerrorists(List<Terrorist> terrorists)
    {
        ArrayAdapter<Terrorist> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, terrorists);
        ListView listView = (ListView) findViewById(R.id.listViewTerrorists);
        listView.setAdapter(itemsAdapter);
    }
    */
}
