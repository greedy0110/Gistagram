package com.greedy0110.gistagram.ext

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

fun JsonElement.nullCheck(): JsonElement? {
    return if (this == JsonNull.INSTANCE) null else this
}

fun JsonObject.jsonNullSafeGet(key: String): JsonElement? {
    return get(key)?.nullCheck()
}