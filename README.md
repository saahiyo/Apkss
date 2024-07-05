# APK Extractor

APKss is an Android application that allows users to list installed applications and extract their APK files to the local storage. It supports both user-installed apps and system apps.

## Features

- List all installed applications (user and system apps).
- Extract and save APK files of selected applications.
- Simple and user-friendly interface.
- Customizable and theme-based UI.

## Screenshots

![screenshot 1](https://github.com/saahiyo/Apkss/assets/81853097/10c9f223-212e-4115-b93f-79ee7c93145f)

![screenshot 2](https://github.com/saahiyo/Apkss/assets/81853097/129adcaf-5b0d-47c1-bab1-2f429272a035)


## Requirements

- Android SDK
- Minimum Android version: KitKat (API 19)

## Installation

1. Clone this repository:
    ```sh
    git clone https://github.com/saahiyo/apkss.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage

1. Launch the application.
2. Select "User Apps" to view all user-installed applications or "System Apps" to view all system applications.
3. Tap on an app to see its details.
4. Long press on an app to extract its APK file. The APK will be saved to `/storage/emulated/0/Apkss/`.

## Code Overview

### MainActivity.java

The `MainActivity` class handles the main functionality of the application, including:

- Initializing the UI components.
- Handling click events for menu and app selection.
- Listing installed applications.
- Extracting APK files of selected applications.

### Listview1Adapter.java

The `Listview1Adapter` class is a custom adapter for displaying app details in the `ListView`.

### Utility Methods

- `showMessage(String message)`: Displays a toast message.
- `extractApk(String packageName, String appName)`: Extracts the APK of the given package and saves it to the specified directory.
- `show_app(boolean isUserApp)`: Populates the list with either user apps or system apps based on the parameter.

## Customization

You can customize the look and feel of the application by modifying the following files:

- `res/layout/activity_main.xml`: Main layout of the application.
- `res/layout/list_item.xml`: Layout for individual app items in the list.
- `res/values/colors.xml`: Color definitions used in the application.
- `res/values/strings.xml`: String resources used in the application.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to contact me at [linkg518@gmail.com].

---
