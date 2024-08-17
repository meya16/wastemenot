package net.penguincoders.WasteMeNot.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityDetail2Binding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;
import net.penguincoders.WasteMeNot.helper.FavCount2;
import net.penguincoders.WasteMeNot.helper.ManagmentCart;

public class DetailActivity2 extends AppCompatActivity {
    private ActivityDetail2Binding binding;

    private FavCount2 favCount2;
    private final int numberOrder=2;
    private int number = 0;
    private ManagmentCart managmentCart;
    private boolean isFavoriteClicked = false;
    private PopularDemon object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetail2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getBundles();
        managmentCart=new ManagmentCart(this);
        favCount2=new FavCount2(this,binding);

        favCount2.readCursorData(object);
        binding.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favCount2.likeClick(object);
            }
        });
        // Set up the favorite button click listener


        binding.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFavoriteClicked) {
                    number++;
                    isFavoriteClicked = true;

                } else  if (isFavoriteClicked) {
                    number--;
                    isFavoriteClicked = false;


                }
                updateLikeCountText();
                updateLikeButtonState();
                favCount2.likeClick(object);

            }
        });
    }

    private void updateLikeCountText() {
        binding.textView12.setText(String.valueOf(number));
    }


    private void updateLikeButtonState() {
        if (isFavoriteClicked) {
            binding.favBtn.setBackgroundResource(R.drawable.favorite_); // Change text or icon to show the liked state
            // likeButton.setBackgroundResource(R.drawable.ic_liked); // If using an icon
        } else {
            binding.favBtn.setBackgroundResource(R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24__1_);// Change text or icon to show the unliked state
            // likeButton.setBackgroundResource(R.drawable.ic_like); // If using an icon
        }
    }


    private void getBundles() {
        object= (PopularDemon) getIntent().getSerializableExtra(("object"));
        int drawablesResourceId=this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawablesResourceId)
                .into(binding.imageView12);
        binding.textView20.setText(object.getTitle());
        binding.textView7.setText(object.getPrice()+"DA");
        binding.textView17.setText(object.getDescription());
        binding.textView19.setText(object.getTitle5());
        binding.textView6.setText(object.getTitle4());
        binding.textView4.setText(object.getTitle3());
        binding.textView36.setText(object.getTitle2());


        binding.imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}


