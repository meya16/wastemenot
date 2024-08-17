package net.penguincoders.WasteMeNot.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.ActivityDetail2Binding;
import net.penguincoders.WasteMeNot.databinding.ActivitydetailBinding;
import net.penguincoders.WasteMeNot.demon.PopularDemon;

public class FavCount {

    private Context context;
    private FavDB favDB;
    private ActivitydetailBinding binding;

    public FavCount(Context context, ActivitydetailBinding binding) {
        this.context = context;
        this.favDB = new FavDB(context);
        this.binding=binding;

        // Create the table and insert initial data on the first start
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart) {
            createTableOnFirstStart();
        }
    }

    // Create the table and insert initial data
    private void createTableOnFirstStart() {
        favDB.insertEmpty();
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    // Read favorite status from the database
    public void readCursorData(PopularDemon item) {
        Cursor cursor = favDB.read_all_data(item.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                item.setFavStatus(item_fav_status);

                if (item_fav_status != null && item_fav_status.equals("1")) {
                    binding.favBtn.setBackgroundResource(R.drawable.favorite_);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    binding.favBtn.setBackgroundResource(R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24__1_);
                }
            }
        } finally {
            if (cursor != null && !cursor.isClosed()) cursor.close();
            db.close();
        }
    }

    // Handle like button click
    public void likeClick(PopularDemon item) {
        if (item.getFavStatus().equals("0")) {
            item.setFavStatus("1");
            favDB.insertIntoTheDatabase(item.getTitle(), item.getImageResourse(), item.getKey_id(), item.getFavStatus());
            binding.favBtn.setBackgroundResource(R.drawable.favorite_);
            binding.favBtn.setSelected(true);
        } else if (item.getFavStatus().equals("1")) {
            item.setFavStatus("0");
            favDB.remove_fav(item.getKey_id());
            binding.favBtn.setBackgroundResource(R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24__1_);
            binding.favBtn.setSelected(false);
        }
    }
}