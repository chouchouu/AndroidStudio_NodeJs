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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.Catagory;
import com.example.asm.Detail;
import com.example.asm.Fragment_Main;
import com.example.asm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.buy;
import model.catagory;

public class adapter_catagory extends RecyclerView.Adapter<adapter_catagory.RecyclerViewHolder> {
    Context context;
    List<catagory> catagories = new ArrayList<>();

    public adapter_catagory(Context context, List<catagory> catagories) {
        this.context = context;
        this.catagories = catagories;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.catagory_item, parent, false);
        return new adapter_catagory.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final catagory catagory = this.catagories.get(position);
//        try {
//            Picasso.with(context)
//                    .load("http://192.168.1.4:8000/" + catagory.getPicture())
//                    .into(holder.img);
//        } catch (Exception e) {
//
//        }
        holder.tv.setText(catagory.getLoaitype());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Catagory.class);
                intent.putExtra("loaiId",catagory.get_id());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return catagories.size();
    }

    public void addFragment(Fragment_Main pageFragment, String s) {

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        //ImageView img;
        CardView cardView;
        TextView tv;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            //img=itemView.findViewById(R.id.img_catagory);
            tv=itemView.findViewById(R.id.tv_catagory);
            cardView=itemView.findViewById(R.id.cart_view_catagory);
        }
    }
}
