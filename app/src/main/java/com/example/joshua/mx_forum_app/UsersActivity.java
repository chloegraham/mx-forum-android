package com.example.joshua.mx_forum_app;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private static final String USERS_URL = "http://10.0.2.2:3000/api/users/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        loadUsersFromAPI(USERS_URL);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        /** Query the API to get the data for users to be displayed
         *
         */
    }

    private void loadUsersFromAPI(String url) {
        GetUsersTask getUsersTask = new GetUsersTask(UsersActivity.this);
        getUsersTask.setMessageLoading("Loading tasks...");
        getUsersTask.execute(url);
    }

    private class GetUsersTask extends UrlJsonAsyncTask{
        public GetUsersTask(Context context) {
            super(context);
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            try {
                //JSONArray jsonNames = json.getJSONObject("data").getJSONArray("data");
                JSONObject obj = json.getJSONObject("data");
                JSONArray jsonNames = obj.getJSONArray("users");
                JSONObject first = jsonNames.getJSONObject(0);

                int length = jsonNames.length();
                List<String> usersFirstname = new ArrayList<String>(length);

                for (int i = 0; i < length; i++) {
                    //usersFirstname.add(jsonNames.getJSONObject(i).getString("user_first_name"));
                }

                //ListView usersListView = (ListView) findViewById (R.id.users_list_view);
//                if (usersListView != null) {
//                    usersListView.setAdapter(new ArrayAdapter<String>(UsersActivity.this,
//                            android.R.layout.simple_list_item_1, usersFirstname));
//                }
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(),
                        Toast.LENGTH_LONG).show();
            } finally {
                super.onPostExecute(json);
            }
        }
    }
}
