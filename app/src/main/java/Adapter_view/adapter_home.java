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

import com.example.asm.Fragment_Main;
import com.example.asm.R;

import java.util.List;

import model.fashion_home;


public class adapter_home extends RecyclerView.Adapter<adapter_home.ViewHolder>{
    private List<fashion_home> flist;
    private Context context;

    public adapter_home(List<fashion_home> flist, Context context) {
        this.flist = flist;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_home.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recy_view_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_home.ViewHolder holder, final int position) {
        final fashion_home fashion_home =flist.get(position);
        holder.img.setImageResource(fashion_home.getImg());
        holder.tx_name.setText("$"+""+fashion_home.getTen());
//        holder.cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return flist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tx_name;
        CardView cart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_home);
            tx_name=itemView.findViewById(R.id.tv_home);
            cart=itemView.findViewById(R.id.cart);
        }
    }
}
