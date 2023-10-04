package com.example.apikeypractice.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apikeypractice.R
import com.example.apikeypractice.databinding.UserItemBinding

class UserAdapter {
    private val pplData: ArrayList<>,
    private val pplData: ArrayList<>,

    ) : RecyclerView.Adapter<UserAdapter.AdapterVoewHolder>() {


        // Inner class representing a view holder for each item in the RecyclerView.
        inner class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            // Bind the XML layout for each item in the RecyclerView.
            val binding = UserItemBinding.bind(view)

            // Set up the UI for a specific item using the provided peopleData and position.
            fun setUpUI(peopleData: , position: Int) {

                // Set the first name and last name to the corresponding TextView.
                binding.firstName.text = "${peopleData.firstName} ${peopleData.lastName}"

                // Set the job title and email to the corresponding TextView.
                binding.email.text = "${peopleData.jobtitle}\n${peopleData.email}"

                // Get the avatar URL from the data.
                val imageUrl = peopleData.avatar

                // Load the avatar image using Glide and set it to the ImageView.
                Glide.with(itemView.context)
                    .load(avatarUrl)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .into(binding.personImage)
            }
        }

        // Override the onCreateViewHolder method to create a new PeopleViewHolder.

        // Override the onBindViewHolder method to bind data to a specific PeopleViewHolder.


            // Set up the UI for the current person using the holder's setUpUI method.


        // Override the getItemCount method to return the total number of items in pplData.
        override fun getItemCount() = pplData.size

        fun updatePeopleList(peopleDetails: java.util.ArrayList<PeopleInfoItemModel>) {
            pplData.addAll(peopleDetails)
            notifyDataSetChanged()

           }