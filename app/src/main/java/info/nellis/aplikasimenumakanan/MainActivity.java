package info.nellis.aplikasimenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    productAdapter adapter;

    List<product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(
                new product(
                        1,
                        "Gudeg",
                        "25000",
                        R.drawable.gudeg,"Gudeg khas Yogyakarta"));
        productList.add(
                new product(
                        1,
                        "Kwetiau",
                        "25000",
                        R.drawable.kwetiau,"Kwetiau dengan topping udang, bakso dan telur"));
        productList.add(
                new product(
                        1,
                        "Mendoan",
                        "5000",
                        R.drawable.mendoan,"Tempe goreng tepung isi 30pcs"));
        productList.add(
                new product(
                        1,
                        "mie",
                        "25000",
                        R.drawable.mie,"Indomie dengan berbagai topping pilihan"));
        productList.add(
                new product(
                        1,
                        "Nasi",
                        "25000",
                        R.drawable.nasi,"Dari beras pilihan"));
        productList.add(
                new product(
                        1,
                        "rawon",
                        "25000",
                        R.drawable.rawon,"Rawon sapi dengan kuah segar"));

        adapter = new productAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
    public void pindah(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}