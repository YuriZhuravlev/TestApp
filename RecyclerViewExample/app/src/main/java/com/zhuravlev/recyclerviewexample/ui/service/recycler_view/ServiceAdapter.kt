package com.zhuravlev.recyclerviewexample.ui.main.recycler_view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.recyclerviewexample.MainActivity
import com.zhuravlev.recyclerviewexample.R
import com.zhuravlev.recyclerviewexample.model.Service
import com.zhuravlev.recyclerviewexample.utils.setImage

class ServiceAdapter(list: List<Service>) : RecyclerView.Adapter<ServiceViewHolder>() {
    val mList = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        with(mList[position]) {
            holder.title.text = this.name
            holder.description.text = this.description
            setImage(holder.image, this.image)
            holder.view.setOnClickListener {
                try {
                    val str = "geo:${this.lat},${this.lon}?q=${this.lat},${this.lon},z=10"
                    val geoUri = Uri.parse(str)
                    val intent = Intent(Intent.ACTION_VIEW, geoUri)
                    if (intent.resolveActivity(MainActivity.instance!!.packageManager!!) != null) {
                        MainActivity.instance!!.startActivity(intent)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}