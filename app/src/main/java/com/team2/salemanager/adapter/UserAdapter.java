package com.team2.salemanager.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team2.salemanager.Model.User;
import com.team2.salemanager.R;
import com.team2.salemanager.dao.UserDAO;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class UserAdapter {
    List<User> arrUser;
    public Activity context;
    public LayoutInflater inflater;
    public UserDAO UserDAO;
    public UserAdapter(Activity context, List<User> arrayUser) {
        super();
        this.context = context;
        this.arrUser = arrayUser;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        UserDAO = new UserDAO(context);
    }

    @Override
    public int getCount() {
        return arrUser.size();
    }

    @Override
    public Object getItem(int position) { return arrUser.get(position);
    }

    @Override
    public long getItemId(int position) { return 0;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtPhone;
        ImageView imgDelete;
    }
    @SuppressLint("ResourceType")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) { ViewHolder holder;
        if(convertView==null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_nguoi_dung, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserDAO.deleteUserByID(arrUser.get(position).getUserName());
                    arrUser.remove(position);
                    notifyDataSetChanged();
                }
            });
            SharedPreferences pref = context.getSharedPreferences("USER_FILE",MODE_PRIVATE);
            String strUserName = pref.getString("USERNAME","");
            if(!strUserName.equalsIgnoreCase("admin")) {
                holder.imgDelete.setVisibility(View.INVISIBLE);
            }
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder)convertView.getTag();
        User entry = (User)arrUser.get(position);
        if (position % 3 ==0) {
            holder.img.setImageResource(R.drawable.emone);
        }else if (position % 3 == 1){
            holder.img.setImageResource(R.drawable.emtwo);
        }else {
            holder.img.setImageResource(R.drawable.emthree);
        }
        holder.txtName.setText("Họ Tên: " + entry.getHoTen());
        holder.txtPhone.setText("SĐT: " + entry.getPhone());
        return convertView;

    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<User> items){
        this.arrUser = items;
        notifyDataSetChanged();
    }
}
}
