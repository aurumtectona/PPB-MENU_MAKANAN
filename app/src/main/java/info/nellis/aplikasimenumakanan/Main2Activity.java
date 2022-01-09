package info.nellis.aplikasimenumakanan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    TextView name,price,des;
    String title,price2,des2;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        des = findViewById(R.id.deskripsi);
        imageView=findViewById(R.id.image);
        name=findViewById(R.id.title);
        price=findViewById(R.id.harga);
        title = getIntent().getStringExtra("name");
        price2= getIntent().getStringExtra("price");
        des2 = getIntent().getStringExtra("deskripsi");
        image = getIntent().getIntExtra("image", 0);
        name.setText(title);
        price.setText(price2);
        imageView.setImageResource(image);
        des.setText(des2);
    }
}
