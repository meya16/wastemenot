package net.penguincoders.WasteMeNot.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import net.penguincoders.WasteMeNot.R;
import net.penguincoders.WasteMeNot.databinding.MybaracheteurBinding;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MybarActivity extends AppCompatActivity {
    MybaracheteurBinding binding;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= MybaracheteurBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.bottomNavigation.setOnItemSelectedListener(item ->  {


            switch (item.getItemId()){
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.navigation_shopping:
                    replaceFragment(new ShoppingFragment());
                    break;
                case R.id.navigation_order:
                    replaceFragment(new OrderFragment());
                    break;
                case R.id.navigation_profile:
                    List<Product> products = new List<Product>() {
                        @Override
                        public int size() {
                            return 0;
                        }

                        @Override
                        public boolean isEmpty() {
                            return false;
                        }

                        @Override
                        public boolean contains(@Nullable Object o) {
                            return false;
                        }

                        @NonNull
                        @Override
                        public Iterator<Product> iterator() {
                            return null;
                        }

                        @NonNull
                        @Override
                        public Object[] toArray() {
                            return new Object[0];
                        }

                        @NonNull
                        @Override
                        public <T> T[] toArray(@NonNull T[] a) {
                            return null;
                        }

                        @Override
                        public boolean add(Product product) {
                            return false;
                        }

                        @Override
                        public boolean remove(@Nullable Object o) {
                            return false;
                        }

                        @Override
                        public boolean containsAll(@NonNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public boolean addAll(@NonNull Collection<? extends Product> c) {
                            return false;
                        }

                        @Override
                        public boolean addAll(int index, @NonNull Collection<? extends Product> c) {
                            return false;
                        }

                        @Override
                        public boolean removeAll(@NonNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public boolean retainAll(@NonNull Collection<?> c) {
                            return false;
                        }

                        @Override
                        public void clear() {

                        }

                        @Override
                        public Product get(int index) {
                            return null;
                        }

                        @Override
                        public Product set(int index, Product element) {
                            return null;
                        }

                        @Override
                        public void add(int index, Product element) {

                        }

                        @Override
                        public Product remove(int index) {
                            return null;
                        }

                        @Override
                        public int indexOf(@Nullable Object o) {
                            return 0;
                        }

                        @Override
                        public int lastIndexOf(@Nullable Object o) {
                            return 0;
                        }

                        @NonNull
                        @Override
                        public ListIterator<Product> listIterator() {
                            return null;
                        }

                        @NonNull
                        @Override
                        public ListIterator<Product> listIterator(int index) {
                            return null;
                        }

                        @NonNull
                        @Override
                        public List<Product> subList(int fromIndex, int toIndex) {
                            return null;
                        }
                    };
                            replaceFragment(new ProfilSellerFragment(products));
                    break;
                case R.id.navigation_add:
                    replaceFragment(new AddProductFragment());

                    break;
            }



            return  true;


        });



    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

}
