package com.example.educateascenders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.educateascenders.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningScreen(subject: String, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(subject) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = getSubjectDescription(subject),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Text(
                text = "Topics",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(getTopicsForSubject(subject)) { topic ->
                    TopicCard(topic = topic, onVideoClick = { url ->
                        // TODO: Implement video playback
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopicCard(topic: Topic, onVideoClick: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onVideoClick(topic.videoUrl) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = topic.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = topic.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${topic.duration} minutes",
                    style = MaterialTheme.typography.bodySmall
                )
                IconButton(onClick = { onVideoClick(topic.videoUrl) }) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "Play")
                }
            }
        }
    }
}

private fun getSubjectDescription(subject: String): String {
    return when (subject) {
        "Mathematics" -> "Learn fundamental mathematical concepts and problem-solving techniques."
        "Science" -> "Explore scientific principles and conduct virtual experiments."
        "English" -> "Improve your language skills through interactive lessons and exercises."
        else -> "Explore various topics and enhance your knowledge."
    }
}

private fun getTopicsForSubject(subject: String): List<Topic> {
    return when (subject) {
        "Mathematics" -> listOf(
            Topic("Algebra Basics", "Introduction to algebraic expressions and equations", "15", "https://example.com/algebra"),
            Topic("Geometry Fundamentals", "Learn about shapes, angles, and spatial relationships", "20", "https://example.com/geometry"),
            Topic("Statistics", "Understanding data analysis and probability", "25", "https://example.com/statistics")
        )
        "Science" -> listOf(
            Topic("Physics Laws", "Newton's laws and basic physics principles", "18", "https://example.com/physics"),
            Topic("Chemistry Basics", "Introduction to atoms, molecules, and reactions", "22", "https://example.com/chemistry"),
            Topic("Biology Fundamentals", "Study of living organisms and their processes", "20", "https://example.com/biology")
        )
        "English" -> listOf(
            Topic("Grammar Essentials", "Master basic grammar rules and usage", "15", "https://example.com/grammar"),
            Topic("Writing Skills", "Learn effective writing techniques", "20", "https://example.com/writing"),
            Topic("Reading Comprehension", "Improve your reading and understanding skills", "18", "https://example.com/reading")
        )
        else -> emptyList()
    }
}

private data class Topic(
    val title: String,
    val description: String,
    val duration: String,
    val videoUrl: String
) 