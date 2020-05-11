    package com.lista.listadetareas.riuz.calculadora.adaptadores;

    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentPagerAdapter;

    import java.sql.Array;
    import java.util.ArrayList;
    import java.util.List;

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public List<Fragment> array = new ArrayList<>();

            public ViewPagerAdapter(@NonNull FragmentManager fm) {
                super(fm);
            }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return array.get(position);
        }

        @Override
        public int getCount() {
            return array.size();
        }

        public void setFragment (Fragment fragment) {
                array.add(fragment);
        }

    }
