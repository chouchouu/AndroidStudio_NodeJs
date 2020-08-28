package Adapter_view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.Detail;
import com.example.asm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.buy;
import model.catagory;

public class adapter_loaisp extends RecyclerView.Adapter<adapter_loaisp.RecyclerViewHolder> {
    Context context;
    List<buy> buyList = new ArrayList<>();

    public adapter_loaisp(Context context, List<buy> buyList) {
        this.context = context;
        this.buyList = buyList;
    }

    @NonNull
    @Override
    public adapter_loaisp.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_loaisanpham,parent,false);
        return new adapter_loaisp.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_loaisp.RecyclerViewHolder holder, final int position) {

        final buy buy = this.buyList.get(position);
        try {
            Picasso.with(context)
                    .load("http://192.168.1.9:8000/" + buy.getImage())
                    .into(holder.img_view_loai);
        } catch (Exception e) {

        }
        holder.txt_name_loai.setText(buy.getName());
        holder.txt_price_loai.setText(buy.getPrice());
        //holder.txt_des.setText(buy.getDescribe());
        holder.cardView_loai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("id", buyList.get(position).get_id());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return buyList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name_loai,txt_price_loai;
        ImageView img_view_loai;
        CardView cardView_loai;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name_loai=itemView.findViewById(R.id.txt_name_loai);
            txt_price_loai=itemView.findViewById(R.id.txt_price_loai);
            img_view_loai=itemView.findViewById(R.id.img_view_loai);
            cardView_loai=itemView.findViewById(R.id.card_view_loai);
        }
    }
}
