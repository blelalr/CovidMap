package com.esther.covidmap

import android.graphics.drawable.GradientDrawable
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.esther.data.MainViewModel
import com.esther.util.DebugLog
import com.google.android.libraries.maps.*
import com.google.android.libraries.maps.model.BitmapDescriptorFactory
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        val markerDrawable = context?.applicationContext?.let { ContextCompat.getDrawable(it, R.drawable.maps_marker) }
        val marker = (markerDrawable as GradientDrawable).toBitmap(markerDrawable.getIntrinsicWidth(), markerDrawable.getIntrinsicHeight())
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        viewModel.getCountries().observe(this.viewLifecycleOwner, Observer { response ->
            if (response.data == null) return@Observer
            for (data in response.data!!) {
                googleMap.addMarker(
                        MarkerOptions()
                                .position(LatLng(data.latitude!!, data.longitude!!))
                                .icon(BitmapDescriptorFactory.fromBitmap(marker)))
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MapFragment.newInstance(GoogleMapOptions().mapId(resources.getString(R.string.map_id)))
        (childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)?.getMapAsync(callback)

    }


}