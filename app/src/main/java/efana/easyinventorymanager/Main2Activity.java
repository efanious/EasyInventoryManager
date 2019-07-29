package efana.easyinventorymanager;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.TextView;

import efana.easyinventorymanager.fragments.InventoryFragment;
import efana.easyinventorymanager.fragments.SellersFragment;

public class Main2Activity extends AppCompatActivity implements
        InventoryFragment.OnFragmentInteractionListener, 
        SellersFragment.OnFragmentInteractionListener {
    private TextView mTextMessage;
    private InventoryFragment mInventoryFragment;
    private SellersFragment mSellersFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();



            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, mInventoryFragment)
                            .commit();

                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, mSellersFragment)
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);

        mInventoryFragment = new InventoryFragment();
        mSellersFragment = new SellersFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, mInventoryFragment)
                .commit();


        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
