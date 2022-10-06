package com.example.kotlin.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityMainBinding
import com.example.kotlin.view.activities.BaseActivity

class HawayatAdapter constructor(
    var root: View,
    activity: Activity,
    context: Context
) : RecyclerView.Adapter<HawayatAdapter.HawayatViewHolder>() {
    private val activity: BaseActivity = activity as BaseActivity
    private val context: Context = context
    private lateinit var binding: ActivityMainBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HawayatViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_hawayat, parent, false)
        return HawayatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HawayatViewHolder, position: Int) {
        setData(holder, position)
        setActions(holder, position)

    }

    private fun setActions(holder: HawayatViewHolder, position: Int) {


    }

    private fun setData(holder: HawayatViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class HawayatViewHolder : RecyclerView.ViewHolder {

        @BindView(R.id.card_parent)
        private var view: View? = null

        constructor(itemView: View) : super(itemView) {
            view = itemView
            ButterKnife.bind(this, view!!)
        }
    }

}