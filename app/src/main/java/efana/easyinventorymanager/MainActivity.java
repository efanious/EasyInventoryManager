package efana.easyinventorymanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import efana.easyinventorymanager.activities.AddProductActivity;
import efana.easyinventorymanager.fragments.InventoryFragment;
import efana.easyinventorymanager.fragments.SellersFragment;

public class MainActivity extends AppCompatActivity implements
        InventoryFragment.OnFragmentInteractionListener,
        SellersFragment.OnFragmentInteractionListener {


    private InventoryFragment mInventoryFragment;
    private SellersFragment mSellersFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_inventory:
                    transaction.replace(R.id.fragment_container, mInventoryFragment)
                            .commit();
                    return true;
                case R.id.navigation_sellers:
                    transaction.replace(R.id.fragment_container, mSellersFragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_product) {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
