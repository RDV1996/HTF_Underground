package be.thomasmore.underground;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReader extends AsyncTask<String, Void, String> {

    public interface OnResultReadyListener {
        void resultReady(String result);
    }

    private OnResultReadyListener onResultReadyListener;

    public void setOnResultReadyListener(OnResultReadyListener listener) {
        onResultReadyListener = listener;
    }

    private Exception exception;

    protected String doInBackground(String... urls) {
        String text = null;

        String accesstoken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTIwNDcwMTUsImRhdGEiOnsidXNlciI6eyJpZCI6IjVhMTk4YTMyODBhZTM5NWYzMDRjZGJmZiIsInJvbGUiOjB9fSwiaWF0IjoxNTEyMDQ1MjE1fQ.H7sVMpgd8Gr8He3hCcFYn9zQtHEcg86iVikr6tFkb2I";

        try {
            URL url= new URL(urls[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty ("Authorization", "Bearer " + accesstoken);
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                text = convertStreamToString(in);
                int i = 0;
            }
            finally {
                urlConnection.disconnect();
            }
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        }
        return text;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    protected void onPostExecute(String result) {
        onResultReadyListener.resultReady(result);
    }

}
