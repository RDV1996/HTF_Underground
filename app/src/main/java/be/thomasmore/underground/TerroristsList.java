package be.thomasmore.underground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import be.thomasmore.underground.classes.Terrorist;

public class TerroristsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrorists_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readTerrorists();
    }

    private void readTerrorists()
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
