package com.example.android.obesityuae;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.obesityuae.services.MessageServices;
import com.example.android.obesityuae.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shaheen on 10/16/2018.
 */
public class NewsFeed extends Activity{

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        listView = (ListView)findViewById(R.id.feedsListView);

        MessageServices taskService = ServiceBuilder.buildService(MessageServices.class);
        Call<List<String>> createRequest = taskService.retrieveNewsFeed();
        createRequest.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                //response.code();
                final ArrayList<String> workersList = new ArrayList<String>(response.body());
                final ArrayAdapter<String> feeed = new ArrayAdapter<String>(NewsFeed.this,
                        android.R.layout.simple_list_item_1, workersList);

                listView.setAdapter(feeed);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("retrofit", "didnt work");
                //Toast.makeText(NewsFeed.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
