package com.example.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import com.example.app.data.model.Voo
import kotlinx.android.synthetic.main.item_voos.view.*

class VoosAdapter(
    var list: List<Voo>
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<VoosAdapter.VoosViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoosViewHolder {
        context = parent.context
        return VoosViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_voos, parent, false)
        )

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VoosViewHolder, position: Int) {

        holder.vooDepartureLocal.text = list[position].from
        holder.vooArrivalLocal.text = list[position].to

        holder.vooDepartureHour.text = getHour(list[position].departureDate)
        holder.vooArrivalHour.text = getHour(list[position].arrivalDate)

        holder.vooSaleTotal.text = list[position].pricing.ota?.saleTotal.toString()

        holder.vooDuration.text = getDuration(list[position].duration)
        holder.vooStops.text = getStops(list[position].stops)

    }

    fun getHour (date: String): String {
        val dateTime = date.split("T")
        val time = dateTime[1].split(":")

        return time[0] + ":" + time[1]
    }

    fun getStops (stops: Int): String {
        if (stops == 1) {
            return "1 parada"
        } else {
            return "$stops paradas"
        }
    }

    fun getDuration (duration: Int): String {
        val hours: Int = duration / 60
        val minutes: Int = duration % 60

        return "$hours:$minutes"
    }

    class VoosViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var vooArrivalLocal = view.voo_arrival_local
        var vooDepartureLocal = view.voo_departure_local
        var vooArrivalHour = view.voo_arrival_hour
        var vooDepartureHour = view.voo_departure_hour
        var vooSaleTotal = view.voo_sale_total
        var vooDuration = view.voo_duration
        var vooStops = view.voo_stops

    }

}