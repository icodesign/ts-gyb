/*
 * Copyright (c) 2021.
 * Microsoft Corporation. All rights reserved.
 *
 *
 * This file is automatically generated
 * Please DO NOT modify
*/

package com.microsoft.office.outlook.rooster.web.bridge

import com.google.gson.Gson
import com.microsoft.office.outlook.rooster.Callback
import com.microsoft.office.outlook.rooster.web.JsBridge
import com.microsoft.office.outlook.rooster.web.WebEditor
import java.lang.reflect.Type
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.SerializedName

interface IHtmlApiBridge {
    fun setMentionClassNames(idToClassNames: Map<String, Array<String>>)
    fun getHeight(callback: Callback<Float>)
    fun getHeightWithBottomAnchor(sta: Array<String>, callback: Callback<Float>)
    fun getHTML(title: String, callback: Callback<String>)
    fun requestRenderingResult()
    fun getSize(callback: Callback<OverriddenFullSize>)
    fun getAliasSize(callback: Callback<JSBaseSize>)
    fun getName(callback: Callback<IHtmlApiGetNameReturnType>)
    fun getAge(gender: IHtmlApiGetAgeGender, callback: Callback<IHtmlApiGetAgeReturnType>)
    fun testDictionaryWithAnyKey(dict: Map<String, String>)
}

open class IHtmlApiBridge(editor: WebEditor, gson: Gson) : JsBridge(editor, gson, "htmlApi"), IHtmlApiBridge {

    override fun setMentionClassNames(idToClassNames: Map<String, Array<String>>) {
        executeJs("setMentionClassNames", mapOf(
            "idToClassNames" to idToClassNames
        ))
    }

    override fun getHeight(callback: Callback<Float>) {
        executeJsForResponse(Float::class.java, "getHeight", callback)
    }

    override fun getHeightWithBottomAnchor(sta: Array<String>, callback: Callback<Float>) {
        executeJsForResponse(Float::class.java, "getHeightWithBottomAnchor", callback, mapOf(
            "sta" to sta
        ))
    }

    override fun getHTML(title: String, callback: Callback<String>) {
        executeJsForResponse(String::class.java, "getHTML", callback, mapOf(
            "title" to title
        ))
    }

    override fun requestRenderingResult() {
        executeJs("requestRenderingResult")
    }

    override fun getSize(callback: Callback<OverriddenFullSize>) {
        executeJsForResponse(OverriddenFullSize::class.java, "getSize", callback)
    }

    override fun getAliasSize(callback: Callback<JSBaseSize>) {
        executeJsForResponse(JSBaseSize::class.java, "getAliasSize", callback)
    }

    override fun getName(callback: Callback<IHtmlApiGetNameReturnType>) {
        executeJsForResponse(IHtmlApiGetNameReturnType::class.java, "getName", callback)
    }

    override fun getAge(gender: IHtmlApiGetAgeGender, callback: Callback<IHtmlApiGetAgeReturnType>) {
        executeJsForResponse(IHtmlApiGetAgeReturnType::class.java, "getAge", callback, mapOf(
            "gender" to gender
        ))
    }

    override fun testDictionaryWithAnyKey(dict: Map<String, String>) {
        executeJs("testDictionaryWithAnyKey", mapOf(
            "dict" to dict
        ))
    }
}

data class JSBaseSize(
    @JvmField val width: Float,
    @JvmField val height: Float,
)

enum class IHtmlApiGetNameReturnType {
    @SerializedName("A2") A2,
    @SerializedName("B2") B2
}

enum class IHtmlApiGetAgeGender {
    @SerializedName("Male") MALE,
    @SerializedName("Female") FEMALE
}

enum class IHtmlApiGetAgeReturnType(val value: Int) {
    _21(21),
    _22(22);

    companion object {
        fun find(value: Int) = values().find { it.value == value }
    }
}

class IHtmlApiGetAgeReturnTypeTypeAdapter : JsonSerializer<IHtmlApiGetAgeReturnType>, JsonDeserializer<IHtmlApiGetAgeReturnType> {
    override fun serialize(obj: IHtmlApiGetAgeReturnType, type: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(obj.value)
    }

    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): IHtmlApiGetAgeReturnType? {
        return IHtmlApiGetAgeReturnType.find(json.asInt)
    }
}
