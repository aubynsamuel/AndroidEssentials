# 🧠 Jetpack Compose Typography Cheat Sheet

A quick reference for choosing the right `MaterialTheme.typography` style in Android apps built with
Jetpack Compose and Material 3.

---

## 🏠 App Structure

| UI Element                                   | Recommended Style                   | Notes                                                     |
|----------------------------------------------|-------------------------------------|-----------------------------------------------------------|
| App Name / Splash Title                      | `displayMedium` or `displayLarge`   | Use for large titles on the splash or onboarding screens. |
| Screen Title (e.g., Dashboard, Settings)     | `headlineSmall` or `headlineMedium` | Primary title at the top of a screen.                     |
| Section Header (e.g., "Recent Transactions") | `titleMedium`                       | Great for separating sections of content.                 |
| Card / Dialog Title                          | `titleSmall`                        | Short, clear labels for cards or popup titles.            |
| Bottom Sheet Title                           | `titleMedium`                       | Matches Material Design consistency for modal elements.   |

---

## 💬 Text Content

| UI Element                              | Recommended Style | Notes                                              |
|-----------------------------------------|-------------------|----------------------------------------------------|
| Main Paragraph / Body Text              | `bodyMedium`      | Default for readable, medium-weight text.          |
| Secondary / Supporting Text             | `bodySmall`       | Use for subtext, hints, or less important content. |
| Large Highlighted Number (e.g., totals) | `displaySmall`    | Good for numeric summaries or KPIs.                |
| Small Caption / Note                    | `labelSmall`      | Ideal for footnotes or helper text under inputs.   |

---

## 🔘 Buttons & Labels

| UI Element                    | Recommended Style | Notes                                           |
|-------------------------------|-------------------|-------------------------------------------------|
| Elevated / Filled Button Text | `labelLarge`      | Default for button labels (uppercase optional). |
| Outlined / Text Button Text   | `labelLarge`      | Keep consistent with other buttons.             |
| Chip / Tag Text               | `labelMedium`     | Compact, still readable.                        |
| Input Field Label             | `labelMedium`     | For `TextField` placeholders or headers.        |

---

## 📊 Lists & Cards

| UI Element         | Recommended Style           | Notes                                       |
|--------------------|-----------------------------|---------------------------------------------|
| List Item Title    | `bodyLarge` or `titleSmall` | Depends on visual importance.               |
| List Item Subtitle | `bodySmall`                 | Use for date, category, or supporting info. |
| Card Header        | `titleSmall`                | Bold and concise.                           |
| Card Body          | `bodySmall`                 | Light supporting text inside cards.         |

---

## 🎨 Theming Tip

If you set up a custom typography in your theme:

```kotlin
MaterialTheme(
    colorScheme = appColorScheme,
    typography = AppTypography
)
```
