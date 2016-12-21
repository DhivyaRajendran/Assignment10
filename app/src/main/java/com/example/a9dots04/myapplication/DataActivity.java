package com.example.a9dots04.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class DataActivity extends AppCompatActivity {
    ArrayList<getdata> getdataArrayList = new ArrayList<>();
    TextView zipcode1;
    TextView address1;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        zipcode1 = (TextView) findViewById(R.id.zipcode);
        address1 = (TextView) findViewById(R.id.address);
        search=(Button) findViewById(R.id.Login_btn1);
        LinearLayout vendorlayout1=(LinearLayout)findViewById(R.id.vendorlayout);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String zipcode = pref.getString("zipcode", "");
        getforward(zipcode);

    }
    private void getforward(final String zipcode) {
        Log.e("no", "" + zipcode);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Root.URL)
                .build();
        getdataapi api = adapter.create(getdataapi.class);
        api.getforward(zipcode,
                new Callback<getdatalist>() {

                    public void success(getdatalist newlist, retrofit.client.Response response) {
                        Log.e("status",""+newlist.getStatus_code());
                        if (newlist.getStatus_code() == 100) {
                            for (int i = 0; i < newlist.getNewInstallationlist().size(); i++) {
                                Log.e("zip", "" + newlist.getNewInstallationlist().get(i).getZipcode());
                                Log.e("zip", "" + newlist.getNewInstallationlist().get(i).getAddress());
                                zipcode1.setText(newlist.getNewInstallationlist().get(i).getZipcode());
                                address1.setText(newlist.getNewInstallationlist().get(i).getAddress());
                                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putLong("Latitude", Double.doubleToLongBits(newlist.getNewInstallationlist().get(i).getLat()));
                                editor.putLong("Longitude", Double.doubleToLongBits(newlist.getNewInstallationlist().get(i).getLng()));
                                editor.commit();
                            }

//                        } else if (newlist.getStatus_code()!=100) {
//                            Toast.makeText(getApplicationContext(), "Absolutely nothing submitted", Toast.LENGTH_SHORT).show();
//                            zipcode1.setVisibility(View.GONE);
//                            address1.setVisibility(View.GONE);
//                            search.setVisibility(View.GONE);
                        }else if (newlist.getStatus_code()== 902) {
                            Toast.makeText(getApplicationContext(), "Absolutely nothing submitted", Toast.LENGTH_SHORT).show();
                            search.setVisibility(View.GONE);
                        }else if (newlist.getStatus_code()==900) {
                            Toast.makeText(getApplicationContext(), "Absolutely nothing submitted", Toast.LENGTH_SHORT).show();
                            search.setVisibility(View.GONE);
                        }
                    }
                    @Override
                    public void failure(RetrofitError error) {
                    }
                });
    }
}
