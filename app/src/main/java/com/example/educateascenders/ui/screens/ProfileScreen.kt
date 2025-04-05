package com.example.educateascenders.ui.screens

import androidx.compose.foundation.layout.*
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
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                actions = {
                    IconButton(onClick = { /* TODO: Implement settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
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
            // Profile Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp)
                )
                Column {
                    Text(
                        text = "John Doe",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "john.doe@example.com",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // Stats Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatCard(
                        icon = Icons.Default.Book,
                        title = "Courses",
                        value = "5",
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        icon = Icons.Default.Timer,
                        title = "Hours",
                        value = "25",
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        icon = Icons.Default.Star,
                        title = "Points",
                        value = "750",
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Settings Section
            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            SettingsCard(
                icon = Icons.Default.Notifications,
                title = "Notifications",
                subtitle = "Manage your notification preferences",
                onClick = { /* TODO: Navigate to notifications settings */ }
            )
            SettingsCard(
                icon = Icons.Default.Lock,
                title = "Privacy",
                subtitle = "Control your privacy settings",
                onClick = { /* TODO: Navigate to privacy settings */ }
            )
            SettingsCard(
                icon = Icons.Default.Help,
                title = "Help & Support",
                subtitle = "Get help and contact support",
                onClick = { /* TODO: Navigate to help center */ }
            )
            SettingsCard(
                icon = Icons.Default.Info,
                title = "About",
                subtitle = "App information and version",
                onClick = { /* TODO: Navigate to about screen */ }
            )
            SettingsCard(
                icon = Icons.Default.Logout,
                title = "Logout",
                subtitle = "Sign out of your account",
                onClick = { navController.navigate("welcome") }
            )
        }
    }
}

@Composable
private fun StatCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 16.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Navigate",
                modifier = Modifier.size(24.dp)
            )
        }
    }
} 