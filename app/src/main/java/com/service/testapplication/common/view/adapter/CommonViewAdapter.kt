package com.service.testapplication.common.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.service.testapplication.R
import com.service.testapplication.common.model.CommonViewData

class CommonViewAdapter<T>(): RecyclerView.Adapter<CommonViewAdapter.CommonViewHolder>() {
    lateinit var context: Context
    var adapterData:List<T>? = null
    constructor(context: Context,adapterData:List<T>?):this(){
        this.context =context
        this.adapterData = adapterData?: ArrayList<T>()
    }

    override fun getItemCount(): Int {
        return adapterData!!.size
    }

    fun setItem(adapterData:List<T>){
        this.adapterData = adapterData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        var dataObject = adapterData?.get(position)
        if(dataObject is CommonViewData){
            var data = dataObject as CommonViewData
            holder.mTxtName.setText(data!!.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.common_item_layout, parent, false)
        return CommonViewHolder(view)
    }

    class CommonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
          lateinit var mImageView:ImageView
          lateinit var mTxtName:TextView
        init {
            mTxtName = itemView.findViewById(R.id.mTxtName)
            mImageView = itemView.findViewById(R.id.mImageView)
        }
    }
}