package Adapter_view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.Detail;
import com.example.asm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.buy;

public class Adapter_sp extends RecyclerView.Adapter<Adapter_sp.RecyclerViewHolder> {
    Context context;
    List<buy> data = new ArrayList<>();

    public Adapter_sp(Context context, List<buy> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_fashion, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        final buy buy = this.data.get(position);
        try {
            Picasso.with(context)
                    .load("http://192.168.1.9:8000/" + buy.getImage())
                    .into(holder.img);
        } catch (Exception e) {

        }
        holder.txt_name.setText(buy.getName());
        holder.txt_price.setText(buy.getPrice());
        //holder.txt_des.setText(buy.getDescribe());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("id", data.get(position).get_id());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt_name, txt_price, txt_des;
        CardView cardView;
        //Button btn_view;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_view);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_price = itemView.findViewById(R.id.txt_price);
            //txt_des = itemView.findViewById(R.id.txt_des);
            //btn_view=itemView.findViewById(R.id.btn_view);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
