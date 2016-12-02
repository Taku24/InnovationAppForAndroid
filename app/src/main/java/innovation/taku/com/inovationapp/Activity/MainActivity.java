package innovation.taku.com.inovationapp.Activity;


import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import innovation.taku.com.inovationapp.Fragment.ContentListFragment;
import innovation.taku.com.inovationapp.Fragment.ContentMainFragment;
import innovation.taku.com.inovationapp.Fragment.ContentMyPageFragment;
import innovation.taku.com.inovationapp.Fragment.ContentSearchFragment;
import innovation.taku.com.inovationapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Fragment mFragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (mFragment == null) {
            mFragment = new ContentMainFragment(this);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_layout, mFragment);
            fragmentTransaction.commit();
            changeToolbarTitle((String) getText(R.string.home));
        }
        setSupportActionBar(mToolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                replaceFragment(new ContentMainFragment(this));
                changeToolbarTitle((String) getText(R.string.home));
                break;

            case R.id.nav_search:
                replaceFragment(new ContentSearchFragment());
                changeToolbarTitle((String) getText(R.string.search));
                break;

            case R.id.nav_list:
                replaceFragment(new ContentListFragment());
                changeToolbarTitle((String) getText(R.string.company));
                break;

            case R.id.nav_favorite:
                replaceFragment(new ContentListFragment());
                changeToolbarTitle((String) getText(R.string.favorite));
                break;

            case R.id.nav_my_page:
                replaceFragment(new ContentMyPageFragment());
                changeToolbarTitle((String) getText(R.string.my_page));

            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void changeToolbarTitle(String title){
        mToolbar.setTitle(title);
    }

}
