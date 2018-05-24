package org.akshanshgusain.androidbottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout mainframe;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private SearchFragment searchFragment;
    private NotificationFragment notificationFragment;
    private PersonFragment personFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainframe=(FrameLayout)findViewById(R.id.mian_frame);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.main_nav);

        //To disable the default animation on Bottom Navigation bar
        BottomNavigationBarHelper.disableShiftMode(bottomNavigationView);

        homeFragment=new HomeFragment();
        categoryFragment=new CategoryFragment();
        searchFragment=new SearchFragment();
        notificationFragment=new NotificationFragment();
        personFragment=new PersonFragment();
        //Set default fragment
        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_category:bottomNavigationView.setItemBackgroundResource(R.color.colorExtra3);
                        setFragment(categoryFragment);
                        return true;

                    case R.id.nav_search:bottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                    setFragment(searchFragment);
                        return true;

                    case R.id.nav_notification:bottomNavigationView.setItemBackgroundResource(R.color.colorExtra2);
                        setFragment(notificationFragment);
                        return true;

                    case R.id.nav_person:bottomNavigationView.setItemBackgroundResource(R.color.colorExtra);
                       setFragment(personFragment);
                        return true;
                    default:return false;
                }


            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mian_frame,fragment);
        fragmentTransaction.commit();
    }


}
