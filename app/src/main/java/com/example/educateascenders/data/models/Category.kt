package com.example.educateascenders.data.models

data class Category(
    val id: String,
    val name: String,
    val description: String,
    val subCategories: List<SubCategory>
)

data class SubCategory(
    val id: String,
    val name: String,
    val description: String,
    val subjects: List<Subject>
)

data class Subject(
    val id: String,
    val name: String,
    val description: String,
    val topics: List<Topic>
)

data class Topic(
    val id: String,
    val name: String,
    val description: String,
    val resources: List<EducationalResource>
)

object Categories {
    val allCategories = listOf(
        Category(
            id = "school",
            name = "School Education",
            description = "Primary and Secondary Education",
            subCategories = listOf(
                SubCategory(
                    id = "primary",
                    name = "Primary School",
                    description = "Grades 1-5",
                    subjects = listOf(
                        Subject(
                            id = "primary_math",
                            name = "Mathematics",
                            description = "Basic Mathematics",
                            topics = listOf(
                                Topic(
                                    id = "addition",
                                    name = "Addition",
                                    description = "Basic addition operations",
                                    resources = listOf(
                                        EducationalResource(
                                            title = "Addition Basics",
                                            description = "Learn basic addition with examples",
                                            source = "Khan Academy",
                                            url = "https://www.khanacademy.org/math/arithmetic-home/addition-subtraction",
                                            type = ResourceType.VIDEO
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
                SubCategory(
                    id = "middle",
                    name = "Middle School",
                    description = "Grades 6-8",
                    subjects = listOf(
                        Subject(
                            id = "middle_science",
                            name = "Science",
                            description = "General Science",
                            topics = listOf(
                                Topic(
                                    id = "cells",
                                    name = "Cell Structure",
                                    description = "Understanding cell structure and function",
                                    resources = listOf(
                                        EducationalResource(
                                            title = "Cell Structure and Function",
                                            description = "Detailed explanation of cell components",
                                            source = "Crash Course",
                                            url = "https://www.youtube.com/watch?v=URUJD5NEXC8",
                                            type = ResourceType.VIDEO
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
                SubCategory(
                    id = "high",
                    name = "High School",
                    description = "Grades 9-10",
                    subjects = listOf(
                        Subject(
                            id = "high_physics",
                            name = "Physics",
                            description = "Basic Physics",
                            topics = listOf(
                                Topic(
                                    id = "motion",
                                    name = "Motion and Forces",
                                    description = "Understanding motion and forces",
                                    resources = listOf(
                                        EducationalResource(
                                            title = "Motion and Forces",
                                            description = "Comprehensive guide to motion and forces",
                                            source = "Physics Classroom",
                                            url = "https://www.physicsclassroom.com/class/newtlaws",
                                            type = ResourceType.ARTICLE
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ),
        Category(
            id = "higher_education",
            name = "Higher Education",
            description = "College and University Level",
            subCategories = listOf(
                SubCategory(
                    id = "engineering",
                    name = "Engineering",
                    description = "Engineering Courses",
                    subjects = listOf(
                        Subject(
                            id = "computer_science",
                            name = "Computer Science",
                            description = "Computer Science and Engineering",
                            topics = listOf(
                                Topic(
                                    id = "data_structures",
                                    name = "Data Structures",
                                    description = "Understanding data structures",
                                    resources = listOf(
                                        EducationalResource(
                                            title = "Data Structures and Algorithms",
                                            description = "Comprehensive guide to data structures",
                                            source = "GeeksforGeeks",
                                            url = "https://www.geeksforgeeks.org/data-structures/",
                                            type = ResourceType.ARTICLE
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    )
} 