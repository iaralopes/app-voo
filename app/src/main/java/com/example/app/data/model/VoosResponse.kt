package com.example.app.data.model

import com.example.app.data.model.Inbound
import com.example.app.data.model.Outbound
import com.google.gson.annotations.SerializedName

class VoosResponse (
    @SerializedName("outbound") val outbound : List<Outbound>,
    @SerializedName("inbound") val inbound: List<Inbound>
)