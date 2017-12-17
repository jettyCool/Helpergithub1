package com.example.admin.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class CustomAutocomlocat extends AppCompatActivity {

    AutoCompleteTextView autoCompleteCityTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_autocomlocat);

        autoCompleteCityTxt=(AutoCompleteTextView)findViewById(R.id.autocomplete);

        autoCompleteCityTxt.setAdapter(new PlacesAutoCompleteAdapter(CustomAutocomlocat.this, R.layout.custom_g));

    }
        //on create ends here

    public class PlaceAPI {

        private  final String TAG = PlaceAPI.class.getSimpleName();

        private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
        private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
        private static final String OUT_JSON = "/json";

        private static final String API_KEY = "AIzaSyBXi7xmJAS5lwiQZxrbTAX6dafM9ukjtes";

        public ArrayList<String> autocomplete (String input) {
            ArrayList<String> resultList = null;

            HttpURLConnection conn = null;
            StringBuilder jsonResults = new StringBuilder();

            try {
                StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE +
                        OUT_JSON);
                sb.append("?key=" + API_KEY);
                sb.append("&components=country:in");
                sb.append("&types=(cities)");
                sb.append("&input=" + URLEncoder.encode(input, "utf8"));

                URL url = new URL(sb.toString());
                conn = (HttpURLConnection) url.openConnection();
                InputStreamReader in = new InputStreamReader(conn.getInputStream());

                // Load the results into a StringBuilder
                int read;
                char[] buff = new char[1024];
                while ((read = in.read(buff)) != -1) {
                    jsonResults.append(buff, 0, read);
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "Error processing Places API URL", e);
                return resultList;
            } catch (IOException e) {
                Log.e(TAG, "Error connecting to Places API", e);
                return resultList;

            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }

            try {
                // Log.d(TAG, jsonResults.toString());

                // Create a JSON object hierarchy from the results
                JSONObject jsonObj = new JSONObject(jsonResults.toString());
                JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

                // Extract the Place descriptions from the results
                resultList = new ArrayList<String>(predsJsonArray.length());
                for (int i = 0; i < predsJsonArray.length(); i++) {
                    resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
                }
            } catch (JSONException e) {
                Log.e(TAG, "Cannot process JSON results", e);
            }

            return resultList;
        }
    }


    public class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements
            Filterable {
        public ArrayList<String> resultList;

        LayoutInflater mInflater;

        public PlaceAPI mPlaceAPI = new PlaceAPI();
        Context mContext;
        int mResource;

        public PlacesAutoCompleteAdapter(Context context, int resource) {
            super(context, resource);

            mContext = context;
            mResource = resource;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // Last item will be the footer
            return resultList.size();
        }

        @Override
        public String getItem(int position) {
            return resultList.get(position);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Holder holder = null;

            if (convertView == null) {
                holder = new Holder();
                convertView = mInflater.inflate(R.layout.custom_g, null);
                holder.lblPlace = (TextView) convertView.findViewById(R.id.customtextview);

                holder.ll=(LinearLayout)convertView.findViewById(R.id.ll);
                holder.lblPlace.setSelected(true);


                //                holder.imgGg = (ImageView) convertView
//                        .findViewById(R.id.img_gg_logo);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            final String strPlace = resultList.get(position);

            if (!strPlace.equals("") && strPlace != null) {
                holder.lblPlace.setText(resultList.get(position));


                if (position < resultList.size() - 1) {
                    //     holder.imgGg.setVisibility(View.GONE);
                } else {
                    //      holder.imgGg.setVisibility(View.VISIBLE);
                }

            }

            holder.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(),"HOLDER CLICK"+strPlace,Toast.LENGTH_LONG).show();

                    // put the String to pass back into an Intent and close this activity
                    Intent intent = new Intent();
                    intent.putExtra("keyName", strPlace);
                    setResult(RESULT_OK, intent);
                    finish();


                }
            });


            return convertView;

        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        resultList = mPlaceAPI.autocomplete(constraint.toString());

                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint,
                                              FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();


                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };

            return filter;
        }

        class Holder {
            TextView lblPlace;
            LinearLayout ll;
            //    ImageView imgGg;
        }

    }



}