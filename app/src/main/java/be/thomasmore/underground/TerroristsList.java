package be.thomasmore.underground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import be.thomasmore.underground.classes.Terrorist;

public class TerroristsList extends AppCompatActivity {

    List<Terrorist> terrorists;

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
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                List<Terrorist> terrorists = jsonHelper.getTerrorists(result);
                showTerrorists(terrorists);
            }
        });
        httpReader.execute("http://37.230.98.72/htf/api/terrorists");
    }

    private void showTerrorists(List<Terrorist> terrorists)
    {
        ArrayAdapter<Terrorist> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, terrorists);
        ListView listView = (ListView) findViewById(R.id.listViewTerrorists);
        listView.setAdapter(itemsAdapter);
    }
}
