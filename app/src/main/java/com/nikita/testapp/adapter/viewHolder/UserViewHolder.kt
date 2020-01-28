package com.nikita.testapp.adapter.viewHolder

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikita.testapp.R
import com.nikita.testapp.db.model.UserModel.UserModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        val layout_id = R.layout.item_user
    }

    private val fullNameTxt: TextView = itemView.findViewById(
        R.id.user_name
    )
    private val avatarImage: CircleImageView = itemView.findViewById(
        R.id.user_image
    )

    @SuppressLint("SetTextI18n")
    fun setData(userModel: UserModel) {
        fullNameTxt.text = "${userModel.name.first} ${userModel.name.last}"

        Picasso.get()
            .load(userModel.picture.medium)
            .into(avatarImage)
    }
}