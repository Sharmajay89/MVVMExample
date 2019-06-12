package com.service.testapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.service.testapplication.common.model.CommonViewData
import com.service.testapplication.common.view.ui.CommonRecyclerViewFragment

class MyViewFragment:CommonRecyclerViewFragment<CommonViewData>() {
    lateinit var dataList: ArrayList<CommonViewData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataList = ArrayList<CommonViewData>()
        dataList.add(CommonViewData("Ajaya","www.google.com",""))
        dataList.add(CommonViewData("Ajaya1","www.google.com",""))
        dataList.add(CommonViewData("Ajaya3","www.google.com",""))

        doRefresh(dataList)
    }

    override fun initializeRecyclerView() {
        super.initializeRecyclerView()
    }

    override fun doRefresh(adapterData: List<CommonViewData>) {
        super.doRefresh(adapterData)
    }
}