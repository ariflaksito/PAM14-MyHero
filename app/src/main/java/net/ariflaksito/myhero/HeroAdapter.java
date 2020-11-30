package net.ariflaksito.myhero;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private List<Hero> heroes;
    private int rowLayout;
    private Context context;

    public HeroAdapter(List<Hero> heroes, int rowLayout, Context context) {
        this.heroes = heroes;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.heroName.setText(heroes.get(position).getName());
        holder.heroRealName.setText(heroes.get(position).getRealname());
        holder.heroBio.setText(heroes.get(position).getBio().trim());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));

        Glide.with(context)
                .load(heroes.get(position).getImageurl())
                .apply(requestOptions)
                .into(holder.heroImage);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {
        CardView heroesLayout;
        TextView heroName;
        TextView heroRealName;
        TextView heroBio;
        ImageView heroImage;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            heroesLayout = (CardView) itemView.findViewById(R.id.hero_layout);
            heroName = (TextView) itemView.findViewById(R.id.tv_name);
            heroRealName = (TextView) itemView.findViewById(R.id.tv_realname);
            heroBio = (TextView) itemView.findViewById(R.id.tv_bio);
            heroImage = (ImageView) itemView.findViewById(R.id.image_hero);
        }
    }
}
