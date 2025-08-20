## Android UI Essentials

This project is a collection of commonly used UI components in Android development, built with
Jetpack Compose. It serves as a practical guide and a quick reference for implementing various UI
elements.

### Features

The app showcases a variety of UI components, including:

* **Navigation:** Demonstrates basic navigation between screens using Jetpack Navigation Compose.
* **Top App Bar:** Implementation of a standard top app bar.
* **Pull to Refresh:** A screen that shows how to implement the pull-to-refresh gesture.
* **Search Bar:** A functional search bar component.
* **Animated Carousel:** An auto-playing, animated carousel.
* **Bottom Sheet:** Examples of both standard and scaffold-based bottom sheets.
* **Snack Bar:** Implementation of a snack bar for brief messages.
* **Gestures:** A screen demonstrating move gestures.
* **Progress Indicators:** Different types of progress indicators.
* **Buttons:** A collection of various button styles.
* **Shapes:** Examples of different shapes and their usage.
* **Floating Action Button (FAB):** A floating action button implementation.

### Project Structure

The project is organized into the following main packages:

* **`presentation.navigation`**: Contains all the navigation-related logic, including routes and the
  navigation graph.
* **`presentation.screens`**: Holds all the individual screens, each showcasing a specific UI
  component.
* **`presentation.theme`**: Defines the color scheme, typography, and overall theme of the
  application.

### How to Use

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical device.

The main screen provides a grid of buttons, each leading to a different UI component screen. You can
explore each screen to see the component in action and review the corresponding code in the
`presentation.screens` package.

### Dependencies

The project uses the following key libraries:

* Jetpack Compose for the UI toolkit.
* Jetpack Navigation Compose for navigation.
* Material 3 for Material Design components.
* Glance for AppWidgets support.

For a complete list of dependencies, please refer to the `app/build.gradle.kts` file.
