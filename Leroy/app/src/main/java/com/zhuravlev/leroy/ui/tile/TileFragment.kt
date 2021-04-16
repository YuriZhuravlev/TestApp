package com.zhuravlev.leroy.ui.tile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zhuravlev.leroy.R
import com.zhuravlev.leroy.ui.simple.SimpleFragment
import com.zhuravlev.leroy.ui.tile.recycler.TileAdapter

class TileFragment : SimpleFragment() {
    private lateinit var tileViewModel: TileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tileViewModel = ViewModelProvider(this).get(TileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_catalogs, container, false)
        val catalogs: RecyclerView = root.findViewById(R.id.recycler_catalog_tile)
        tileViewModel.listCatalog.observe(viewLifecycleOwner, Observer {
            catalogs.adapter = TileAdapter(it)
        })
        return root
    }
}