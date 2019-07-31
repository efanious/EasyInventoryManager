package efana.easyinventorymanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

import efana.easyinventorymanager.R;
import efana.easyinventorymanager.models.Product;

public class AddProductActivity extends AppCompatActivity {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        Button mTestButton = (Button) findViewById(R.id.button);

        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDocument();
            }
        });
    }

    private void addDocument() {
        Product product = new Product("1","Nike Shoes", "20", "$12", "");
        db.collection("products").add(product);
//                .document("Shoe").set(product);

//        City city = new City("Los Angeles", "CA", "USA",
//                false, 5000000L, Arrays.asList("west_coast", "sorcal"));
//        db.collection("cities").document("LA").set(city);

    }
}
