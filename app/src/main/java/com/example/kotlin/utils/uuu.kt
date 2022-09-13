package com.example.kotlin.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class uuu {
    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("code")
    @Expose
    private var code: Int? = null

    @SerializedName("data")
    @Expose
    private var data: List<String?>? = null

    @SerializedName("paginate")
    @Expose
    private var paginate: String? = null

    fun getPaginate(): String? {
        return paginate
    }

    fun setPaginate(paginate: String?) {
        this.paginate = paginate
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }

    fun getData(): List<String?>? {
        return data
    }

    fun setData(data: List<String?>?) {
        this.data = data
    }

}