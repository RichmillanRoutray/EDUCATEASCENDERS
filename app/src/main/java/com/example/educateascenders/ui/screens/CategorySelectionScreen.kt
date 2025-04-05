package com.example.educateascenders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySelectionScreen(navController: NavController) {
    var selectedClass by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }

    val classes = listOf(
        "Class 1", "Class 2", "Class 3", "Class 4", "Class 5",
        "Class 6", "Class 7", "Class 8", "Class 9", "Class 10"
    )

    val subjects = listOf(
        "Mathematics",
        "Science",
        "English",
        "History",
        "Geography",
        "Computer Science",
        "Physics",
        "Chemistry",
        "Biology"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Select Category") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Text("←")
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
                text = "Select Class",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(classes) { className ->
                    Card(
                        onClick = { selectedClass = className },
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedClass == className)
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = className,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            if (selectedClass == className) Text("✓")
                        }
                    }
                }
            }

            if (selectedClass.isNotEmpty()) {
                Text(
                    text = "Select Subject",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(subjects) { subject ->
                        Card(
                            onClick = { selectedSubject = subject },
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = if (selectedSubject == subject)
                                    MaterialTheme.colorScheme.primaryContainer
                                else
                                    MaterialTheme.colorScheme.surface
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = subject,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                if (selectedSubject == subject) Text("✓")
                            }
                        }
                    }
                }

                if (selectedSubject.isNotEmpty()) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Search specific topic") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )

                    Button(
                        onClick = { navController.navigate("search_results") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Search")
                    }
                }
            }
        }
    }
}