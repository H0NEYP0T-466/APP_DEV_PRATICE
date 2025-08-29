# 🤝 Contributing to APP_DEV_PRATICE

Thank you for your interest in contributing to APP_DEV_PRATICE! This document provides guidelines and instructions for contributing to this mobile application development practice repository.

## 📋 Table of Contents

- [Code of Conduct](#-code-of-conduct)
- [Getting Started](#-getting-started)
- [How to Contribute](#-how-to-contribute)
- [Development Setup](#-development-setup)
- [Code Style Guidelines](#-code-style-guidelines)
- [Testing Guidelines](#-testing-guidelines)
- [Submitting Changes](#-submitting-changes)
- [Bug Reports](#-bug-reports)
- [Feature Requests](#-feature-requests)
- [Documentation Updates](#-documentation-updates)

## 📜 Code of Conduct

This project adheres to a code of conduct that we expect all contributors to follow. Please be respectful, inclusive, and constructive in all interactions.

### Our Standards

- Use welcoming and inclusive language
- Be respectful of differing viewpoints and experiences
- Gracefully accept constructive criticism
- Focus on what is best for the community
- Show empathy towards other community members

## 🚀 Getting Started

### Prerequisites

Before contributing, ensure you have the following installed:

#### For Flutter Development:
- Flutter SDK (>=3.8.1)
- Dart SDK (included with Flutter)
- Android Studio with Android SDK
- Xcode (for iOS development - macOS only)

#### For Android Development:
- Android Studio
- Android SDK (API level 21+)
- JDK 8+

### Fork and Clone

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/APP_DEV_PRATICE.git
   cd APP_DEV_PRATICE
   ```
3. **Add the original repository** as upstream:
   ```bash
   git remote add upstream https://github.com/H0NEYP0T-466/APP_DEV_PRATICE.git
   ```

## 🔄 How to Contribute

### Types of Contributions

We welcome several types of contributions:

1. **🐛 Bug fixes**
2. **✨ New features**
3. **📚 Documentation improvements**
4. **🧪 Test coverage improvements**
5. **🎨 UI/UX enhancements**
6. **⚡ Performance optimizations**
7. **🔧 Code refactoring**

### Contribution Process

1. **Check existing issues** to see if your contribution is already being worked on
2. **Create an issue** if one doesn't exist for your contribution
3. **Discuss your approach** in the issue before starting work
4. **Create a feature branch** from `main`
5. **Make your changes** following our guidelines
6. **Test thoroughly** on multiple platforms when applicable
7. **Submit a pull request** with a clear description

## ⚙️ Development Setup

### Flutter Project Setup

```bash
cd Pratice_Flutter
flutter pub get
flutter doctor -v  # Verify your setup
flutter run -d android  # Test on Android
flutter run -d ios      # Test on iOS (macOS only)
```

### Android Project Setup

```bash
# For any Android project
cd Simple_todo_List  # or any other Android project
./gradlew build
./gradlew test
```

### Running Tests

```bash
# Flutter tests
cd Pratice_Flutter
flutter test

# Android tests
cd Simple_todo_List
./gradlew test
./gradlew connectedAndroidTest  # For instrumented tests
```

## 🎨 Code Style Guidelines

### Flutter/Dart Code Style

- Follow the [Dart Style Guide](https://dart.dev/guides/language/effective-dart/style)
- Use `dart format` to format your code
- Use meaningful variable and function names
- Add documentation comments for public APIs
- Prefer `const` constructors when possible

```dart
// Good
class UserProfile extends StatelessWidget {
  const UserProfile({
    super.key,
    required this.user,
  });

  final User user;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        title: Text(user.name),
        subtitle: Text(user.email),
      ),
    );
  }
}
```

### Kotlin Code Style

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use Android Studio's built-in formatter
- Use meaningful names for classes, functions, and variables
- Add KDoc comments for public APIs
- Prefer `val` over `var` when possible

```kotlin
// Good
class TodoItem(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    /**
     * Marks this todo item as completed
     */
    fun markAsCompleted(): TodoItem {
        return copy(isCompleted = true)
    }
}
```

### General Guidelines

- **Consistent indentation**: Use 2 spaces for Dart, 4 spaces for Kotlin
- **Line length**: Maximum 80 characters for Dart, 120 for Kotlin
- **Import organization**: Group and sort imports
- **Comments**: Write clear, concise comments explaining "why" not "what"
- **Error handling**: Properly handle errors and edge cases

## 🧪 Testing Guidelines

### Testing Requirements

- **Unit tests** for business logic
- **Widget tests** for Flutter UI components
- **Integration tests** for complete user flows
- **Code coverage** should not decrease with new changes

### Writing Tests

#### Flutter Tests

```dart
// Widget test example
testWidgets('Counter increments smoke test', (WidgetTester tester) async {
  await tester.pumpWidget(const MyApp());
  
  expect(find.text('0'), findsOneWidget);
  expect(find.text('1'), findsNothing);
  
  await tester.tap(find.byIcon(Icons.add));
  await tester.pump();
  
  expect(find.text('0'), findsNothing);
  expect(find.text('1'), findsOneWidget);
});
```

#### Android Tests

```kotlin
// Unit test example
@Test
fun `should calculate tip correctly`() {
    val calculator = TipCalculator()
    val result = calculator.calculateTip(amount = 100.0, tipPercentage = 15)
    
    assertEquals(15.0, result.tipAmount, 0.01)
    assertEquals(115.0, result.totalAmount, 0.01)
}
```

### Running Tests

```bash
# Flutter
flutter test                    # Run all tests
flutter test test/widget_test.dart  # Run specific test

# Android
./gradlew test                  # Unit tests
./gradlew connectedAndroidTest  # Instrumented tests
```

## 📝 Submitting Changes

### Pull Request Process

1. **Create a feature branch**:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make your changes** and commit them:
   ```bash
   git add .
   git commit -m "feat: add new feature description"
   ```

3. **Push to your fork**:
   ```bash
   git push origin feature/your-feature-name
   ```

4. **Create a Pull Request** on GitHub

### Commit Message Format

Use [Conventional Commits](https://www.conventionalcommits.org/) format:

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

Examples:
```
feat(flutter): add user authentication
fix(android): resolve crash on empty todo list
docs: update installation instructions
test(tip-calculator): add unit tests for calculation logic
```

### Pull Request Template

When creating a pull request, please include:

- **Description**: Clear description of changes
- **Type**: Bug fix, feature, documentation, etc.
- **Testing**: How you tested your changes
- **Screenshots**: For UI changes
- **Breaking Changes**: If any
- **Related Issues**: Link to related issues

## 🐛 Bug Reports

When reporting bugs, please include:

### Bug Report Template

```markdown
**Bug Description**
A clear description of what the bug is.

**Steps to Reproduce**
1. Go to '...'
2. Click on '....'
3. Scroll down to '....'
4. See error

**Expected Behavior**
What you expected to happen.

**Actual Behavior**
What actually happened.

**Screenshots**
If applicable, add screenshots.

**Environment:**
 - OS: [e.g. Android 12, iOS 15]
 - Device: [e.g. Pixel 6, iPhone 13]
 - App Version: [e.g. 1.0.0]
 - Flutter Version: [if applicable]

**Additional Context**
Any other context about the problem.
```

## 💡 Feature Requests

When requesting features, please include:

### Feature Request Template

```markdown
**Feature Description**
A clear description of the feature you'd like to see.

**Problem Statement**
What problem does this feature solve?

**Proposed Solution**
How do you envision this feature working?

**Alternatives Considered**
Other solutions you've considered.

**Additional Context**
Any other context, mockups, or examples.
```

## 📚 Documentation Updates

### Documentation Guidelines

- Keep documentation up-to-date with code changes
- Use clear, concise language
- Include code examples where helpful
- Update README.md for significant changes
- Add inline code comments for complex logic

### Documentation Structure

- **README.md**: Project overview and quick start
- **CONTRIBUTING.md**: This file
- **API Documentation**: For public APIs
- **Inline Comments**: For complex code sections
- **Code Examples**: In documentation and comments

## 🔄 Keeping Your Fork Updated

Regularly sync your fork with the upstream repository:

```bash
git fetch upstream
git checkout main
git merge upstream/main
git push origin main
```

## ❓ Questions and Support

- **General Questions**: Open a [GitHub Discussion](https://github.com/H0NEYP0T-466/APP_DEV_PRATICE/discussions)
- **Bug Reports**: Create an [Issue](https://github.com/H0NEYP0T-466/APP_DEV_PRATICE/issues)
- **Feature Requests**: Create an [Issue](https://github.com/H0NEYP0T-466/APP_DEV_PRATICE/issues)

## 🎉 Recognition

Contributors will be recognized in:
- README.md acknowledgments
- Release notes for significant contributions
- GitHub's contributor graph

Thank you for contributing to APP_DEV_PRATICE! Your contributions help make mobile app development more accessible and educational for everyone.

---

**Happy Coding! 🚀**