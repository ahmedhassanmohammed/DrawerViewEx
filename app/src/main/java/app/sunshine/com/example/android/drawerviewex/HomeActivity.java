package app.sunshine.com.example.android.drawerviewex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    // TODO 8 : 4wt el code da elly ana m4 fahmo XD
    private DrawerLayout myDrawerlayout;
    private ActionBarDrawerToggle myToggle;

    ListView listView;
    MessageAdapter adapter;
    NavigationView navigationView;
    TextView UserName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        myToggle = new ActionBarDrawerToggle(this, myDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        myDrawerlayout.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.EmailsListView);
        adapter=new MessageAdapter(getApplicationContext());
        listView.setAdapter(adapter);
        navigationView = (NavigationView) findViewById(R.id.navDrawer);




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               String title= item.getTitle().toString();

                Intent intent ;

                switch (title) {
                    case "Inbox":
                        startActivity(new Intent(HomeActivity.this, InboxActivity.class));
                        break;
                    case "Sent":
                        startActivity(new Intent(HomeActivity.this, SentActivity.class));

                        break;
                    case "Favorites":
                        startActivity(new Intent(HomeActivity.this, FavoritesActivity.class));
                        break;
                    case "Trash":
                        startActivity(new Intent(HomeActivity.this, TrashActivity.class));
                        break;
                    case "Logout":
                        // intent to login activity
                        break;
                    case "Profile":
                        startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                        break;
                    case "Setting":
                        startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
