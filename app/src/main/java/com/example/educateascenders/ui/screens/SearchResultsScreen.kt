package com.example.educateascenders.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultsScreen(navController: NavController, context: Context) {
    val geminiUrl = "https://gemini.google.com/"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geminiUrl))
    context.startActivity(intent)

    // Sample data - In a real app, this would come from an API
    val resources = listOf(
        EducationalResource(
            title = "Introduction to Mathematics",
            description = "A comprehensive guide to basic mathematical concepts",
            source = "Khan Academy",
            url = "https://www.khanacademy.org/math",
            type = ResourceType.VIDEO
        ),
        EducationalResource(
            title = "Basic Science Concepts",
            description = "Learn fundamental scientific principles through interactive lessons",
            source = "Crash Course",
            url = "https://www.youtube.com/crashcourse",
            type = ResourceType.VIDEO
        ),
        EducationalResource(
            title = "English Grammar Guide",
            description = "Complete guide to English grammar rules and usage",
            source = "Grammarly",
            url = "https://www.grammarly.com/blog",
            type = ResourceType.ARTICLE
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search Results") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Text("←")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(resources) { resource ->
                ResourceCard(resource = resource)
            }
        }
    }
}

@Composable
fun ResourceCard(resource: EducationalResource) {
    var isBookmarked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = resource.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { isBookmarked = !isBookmarked }) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = if (isBookmarked) "Remove bookmark" else "Add bookmark"
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = resource.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = resource.source,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = resource.type.name,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Open resource URL */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Open Resource")
            }
        }
    }
}

data class EducationalResource(
    val title: String,
    val description: String,
    val source: String,
    val url: String,
    val type: ResourceType
)

enum class ResourceType {
    VIDEO,
    ARTICLE,
    WEBSITE,
    PDF
}