package com.example.educateascenders.data.models

enum class ResourceType {
    VIDEO,
    ARTICLE,
    QUIZ,
    EXERCISE,
    DOCUMENT,
    WEBSITE
}

data class EducationalResource(
    val title: String,
    val description: String,
    val source: String,
    val url: String,
    val type: ResourceType
) 