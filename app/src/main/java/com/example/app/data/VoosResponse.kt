package com.example.app.data

import com.google.gson.annotations.SerializedName

class VoosResponse (
    @SerializedName("outbound") val outbound : List<Outbound>,
    @SerializedName("inbound") val inbound : List<Inbound>
)