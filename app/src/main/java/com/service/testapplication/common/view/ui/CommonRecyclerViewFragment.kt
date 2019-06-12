package com.service.testapplication.common.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.service.testapplication.R
import com.service.testapplication.common.model.CommonViewData
import com.service.testapplication.common.view.listeners.RecyclerItemClickListener
import com.service.testapplication.common.view.adapter.CommonViewAdapter

public open abstract class CommonRecyclerViewFragment<T>: Fragment() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mProgress:ProgressBar
    lateinit var emptyView:TextView
    lateinit var mRecyclerViewAdapter: CommonViewAdapter<T>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.common_recyclerview_layout, container,false)
        mRecyclerView = rootView.findViewById(R.id.mRecyclerView)
        mProgress = rootView.findViewById(R.id.mProgress)
        emptyView = rootView.findViewById(R.id.emptyView)
        initializeRecyclerView()
        return rootView
    }

    public fun getRecyclerViewTouchListener(): RecyclerView.OnItemTouchListener{
        return RecyclerItemClickListener(
            activity!!,
            mRecyclerView,
            object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    onRecyclerViewItemClick(view, position);
                }

                override fun onItemLongClick(view: View?, position: Int) {

                }

            });
    }
    // use this to type:String,cellCount:Int
    open protected fun initializeRecyclerView() {
        var layoutManager = GridLayoutManager(activity!!, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerViewAdapter = CommonViewAdapter(activity!!,null)
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        mRecyclerView.addOnItemTouchListener(getRecyclerViewTouchListener());
    }

    /**
     * Used to show progress while performing network requests on load more data
     */
    protected fun showProgressBar(show:Boolean) {
        if (!show && (mRecyclerViewAdapter == null || mRecyclerViewAdapter.getItemCount() == 0) && emptyView != null) {
            emptyView.setVisibility(View.VISIBLE);
        } else if(emptyView != null){
            emptyView.setVisibility(View.GONE);
        }
    }


    /**
     * Override this method in child to handle clicks
     * @param view
     * @param position
     */
    open protected fun onRecyclerViewItemClick( view:View, position:Int){

    }

    /**
     * call this method to refresh adapter data
     */
    open protected fun doRefresh(adapterData:List<T>){
        if (mRecyclerViewAdapter != null) {
             mRecyclerViewAdapter.setItem(adapterData)
        }
    }
}