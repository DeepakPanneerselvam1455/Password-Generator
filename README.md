# Password Generator - README

## Project Overview

The **Password Generator** is a Java-based application that allows users to generate secure and random passwords. The application ensures that the generated password contains a mix of lowercase letters, uppercase letters, digits, and special characters. The length of the password is customizable by the user.

This tool is designed to help users generate strong passwords that are difficult to guess or crack, ensuring better security for online accounts and sensitive information.

## Features
- **Customizable Password Length**: Users can specify the length of the generated password.
- **Random Password Generation**: Passwords are generated with random characters, including lowercase, uppercase, digits, and special characters.
- **Password Complexity**: The generated password always includes at least one lowercase letter, one uppercase letter, one digit, and one special character to ensure strength.
- **Randomness**: The use of `SecureRandom` ensures high-quality randomness for generating passwords.
- **Password Regeneration**: Users can choose to regenerate a new password after the first one is created.

## Technologies Used
- **Programming Language**: Java
- **Randomness**: `SecureRandom` for secure and unpredictable randomness.
- **User Interface**: Command-line interface (CLI)

## Installation

### Prerequisites
- Java 8 or later installed on your system.

### Steps to Set Up
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/DeepakPanneerselvam1455/PasswordGenerator.git
   ```

2. **Install Java**:
   - Download and install [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) if it's not already installed.

3. **Run the Application**:
   - Open the project folder in your IDE or run the program directly from the terminal.
   - To run the application via terminal:
     ```bash
     javac PasswordGenerator.java
     java PasswordGenerator
     ```

## Usage

### Sample Interaction:

```
Enter the desired length for your password: 
12
Generated Password: d3R!n8g@d7sA

Do you want to regenerate the password (yes/no)? 
no
Goodbye!
```

### Features Walkthrough:
1. **Enter Password Length**: The program prompts you to enter the desired length for your password.
2. **Password Generation**: The program generates a password containing at least one lowercase letter, one uppercase letter, one digit, and one special character.
3. **Regenerate Option**: After generating the password, you can choose whether to generate another password or exit the program.

## Code Structure

### Password Generation Method:

```java
public static String generatePassword(int length) {
    String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

    StringBuilder password = new StringBuilder();
    
    // Ensure that the password contains at least one lowercase, one uppercase, one digit, and one special character
    password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
    password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
    password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
    password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

    // Fill the remaining length of the password with random characters
    for (int i = password.length(); i < length; i++) {
        password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
    }

    // Shuffle the password to ensure randomness
    for (int i = 0; i < password.length(); i++) {
        int j = random.nextInt(password.length());
        char temp = password.charAt(i);
        password.setCharAt(i, password.charAt(j));
        password.setCharAt(j, temp);
    }

    return password.toString();
}
```

### Example of Main Program Execution:

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueGenerating = true;

    while (continueGenerating) {
        System.out.println("Enter the desired length for your password: ");
        int length = scanner.nextInt();

        // Ensure password length is positive
        if (length < 1) {
            System.out.println("Password length must be at least 1.");
            continue;
        }

        // Generate and display the password
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);

        System.out.print("Do you want to regenerate the password (yes/no)? ");
        String regenerateChoice = scanner.next().trim().toLowerCase();

        // Continue or stop based on user's input
        if (regenerateChoice.equals("no")) {
            continueGenerating = false;
            System.out.println("Goodbye!");
        }
    }

    scanner.close();
}
```

## Author

- **Author**: [Deepak P](https://github.com/DeepakPanneerselvam1455)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or contributions, feel free to open an issue or contact the project maintainer.

- **Contact**: [Deepak P](https://github.com/DeepakPanneerselvam1455)
