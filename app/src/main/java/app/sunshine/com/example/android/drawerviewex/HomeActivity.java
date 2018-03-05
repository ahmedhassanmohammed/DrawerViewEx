package app.sunshine.com.example.android.drawerviewex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {
    // TODO 8 : 4wt el code da elly ana m4 fahmo XD
    private DrawerLayout myDrawerlayout;
    private ActionBarDrawerToggle myToggle;


    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        myToggle = new ActionBarDrawerToggle(this, myDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        myDrawerlayout.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InboxFragment inbox = new InboxFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, inbox, "").commit();



        navigationView = (NavigationView) findViewById(R.id.navDrawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();

                switch (title) {
                    case "Inbox":
                        InboxFragment inboxFragment = new InboxFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, inboxFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Sent":
                        SentFragment sentFragment = new SentFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, sentFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Favorites":
                        Favorites_fragment favorites_fragment = new Favorites_fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, favorites_fragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Trash":
                        TrashFragment trashFragment = new TrashFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, trashFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Logout":
                        // intent to login activity
                        break;
                    case "Profile":
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, profileFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
                    case "Settings":
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
