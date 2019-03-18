package com.example.app.data.mapper

import com.example.app.data.model.Inbound
import com.example.app.data.model.Outbound
import com.example.app.data.model.Voo
import com.example.app.data.model.VoosResponse

object VooMapper {

    fun parseInboundListToAdaptedList(voosResponse: VoosResponse) : List<Voo> {
       return voosResponse.inbound.map { it -> parseInboundVooToAdaptedVoo(it) }

    }

    fun parseOutboundListToAdaptedList(voosResponse: VoosResponse) : List<Voo> {
        return voosResponse.outbound.map { it -> parseOutboundVooToAdaptedVoo(it) }

    }

    fun parseInboundVooToAdaptedVoo(inboundVoo: Inbound): Voo {
        return Voo(
            stops = inboundVoo.stops,
            duration = inboundVoo.duration,
            from = inboundVoo.from,
            departureDate = inboundVoo.departureDate,
            arrivalDate = inboundVoo.arrivalDate,
            pricing = inboundVoo.pricing,
            direction = inboundVoo.direction,
            to = inboundVoo.to
        )
    }

    fun parseOutboundVooToAdaptedVoo(outboundVoo: Outbound): Voo {
        return Voo(
            stops = outboundVoo.stops,
            duration = outboundVoo.duration,
            from = outboundVoo.from,
            departureDate = outboundVoo.departureDate,
            arrivalDate = outboundVoo.arrivalDate,
            pricing = outboundVoo.pricing,
            direction = outboundVoo.direction,
            to = outboundVoo.to
        )

    }
}