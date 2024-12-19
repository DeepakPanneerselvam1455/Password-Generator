import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
    private static final SecureRandom random = new SecureRandom();
    public static String generatePassword(int length) {
        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;
        StringBuilder password = new StringBuilder();     
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        for (int i = password.length(); i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        for (int i = 0; i < password.length(); i++) {
            int j = random.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(j));
            password.setCharAt(j, temp);
        }
        return password.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueGenerating = true;
        while (continueGenerating) {
            System.out.println("Enter the desired length for your password: ");
            int length = scanner.nextInt();
            if (length < 1) {
                System.out.println("Password length must be at least 1.");
                continue;
            }
            String password = generatePassword(length);
            System.out.println("Generated Password: " + password);

            System.out.print("Do you want to regenerate the password (yes/no)? ");
            String regenerateChoice = scanner.next().trim().toLowerCase();
            if (regenerateChoice.equals("no")) {
                continueGenerating = false;
                System.out.println("Goodbye!");
            }
        }
        scanner.close();
    }
}
