package info.nellis.aplikasimenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class productAdapter extends RecyclerView.Adapter<productAdapter.ProductViewHolder> {

    private Context Ctx;
    private List<product> productList;

    public productAdapter(Context ctx, List<product> productList) {
        Ctx = ctx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.menumakanan, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        final product product = productList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.imageView.setImageDrawable(Ctx.getResources().getDrawable(product.getImage()));
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ctx,Main2Activity.class);
                intent.putExtra("image", product.getImage());
                intent.putExtra("name", product.getTitle());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("deskripsi", product.getDes());
                Ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewPrice, textViewDes;
        RelativeLayout relative;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDes = itemView.findViewById(R.id.deskripsi);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            relative = itemView.findViewById(R.id.relative);
        }
    }
}
