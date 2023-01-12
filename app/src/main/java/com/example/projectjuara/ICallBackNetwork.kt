package com.example.projectjuara

import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem

interface ICallBackNetwork {

    fun onFinish(data :List<SearchItem>)
    fun onFinishDetail(data : OMDBDetailResponse)
    fun onFailed()
}