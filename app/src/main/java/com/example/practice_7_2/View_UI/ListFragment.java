package com.example.practice_7_2.View_UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice_7_2.Data.Model.Item;
import com.example.practice_7_2.R;
import com.example.practice_7_2.ViewModel.AnimalViewModel;
import com.example.practice_7_2.ViewModel.AnimalsListViewModel;

import java.util.List;

public class ListFragment extends Fragment {
    public static class YourCustomRecyclerViewAdapter extends RecyclerView.Adapter<YourCustomRecyclerViewAdapter.ViewHolder> {
        private List<Item> dataList;
        private OnItemClicked onClick;
        public interface OnItemClicked {
            void onItemClick(int position);
        }

        public YourCustomRecyclerViewAdapter(List<Item> dataList) {
            this.dataList = dataList;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item = dataList.get(position);
            holder.imageView.setImageResource(item.getImageResId());
            holder.textView.setText(item.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onItemClick(holder.getAdapterPosition());
//                    Navigation.findNavController(v).navigate(R.id.action_FragmentList_to_CFragment);
                }
            });
        }
        @Override
        public int getItemCount() {
            return dataList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
        public void setOnClick(OnItemClicked onClick){
            this.onClick=onClick;
        }
    }

    public ListFragment() {
        super(R.layout.fragment_list);
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /*public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Item> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(new Item("Dog " + i, R.drawable.cat));
        }

        YourCustomRecyclerViewAdapter adapter = new YourCustomRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }*/
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        Button addNewCat_button = (Button) getActivity().findViewById(R.id.b_addNewCat);
        RecyclerView itemsList = getActivity().findViewById(R.id.recycler_view);

        AnimalsListViewModel animalsViewModel = new ViewModelProvider(getActivity()).get(AnimalsListViewModel.class);

        animalsViewModel.getUIState().observe(getViewLifecycleOwner(), uiState -> {
            List<Item> items = uiState.getAnimalsPositions();

            if (items == null || items.size() == 0) {
                itemsList.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "There is no animals", Toast.LENGTH_SHORT).show();
            } else {
                if (itemsList.getVisibility() == View.GONE)
                    itemsList.setVisibility(View.VISIBLE);

                YourCustomRecyclerViewAdapter adapter = new YourCustomRecyclerViewAdapter(items);

                //убрала конекст!!!!!!


                LinearLayoutManager layoutManager = new
                        LinearLayoutManager(this.getContext().getApplicationContext());
                itemsList.setLayoutManager(layoutManager);

                adapter.setOnClick(new YourCustomRecyclerViewAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {
                        if (animalsViewModel.getUIState().getValue() != null) {
                            Item item = (Item) animalsViewModel.getUIState().getValue().getAnimal(position);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("Item", item);
                            navController.navigate(R.id.action_FragmentList_to_CFragment, bundle);
                        }
                    }
                });

                itemsList.setAdapter(adapter);
            }
        });

        addNewCat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_FragmentList_to_AFragment);
            }
        });
    }
}