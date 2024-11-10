import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BankApp extends JFrame {
    private UncompletedSavingsAccount account;
    private JLabel messageLabel;  // Label to display messages in the frame

    public BankApp() {
        // Initialize account with default balance of 100$
        Person person = new Person("Amir", "123-456-7890", "1990-05-15");
        account = new UncompletedSavingsAccount("Amir", person);
        account.deposit(100); // Set default balance to 100

        // Setting up the main frame and panels
        setTitle("XYZ Bank Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(128, 0, 128));
        setLayout(new CardLayout());

        // Display welcome page
        showWelcomePage();
    }

    private void showWelcomePage() {
        setTitle("Welcome Page");
    
        // Create the main panel
        JPanel welcomePanel = createPanel("Developer: Student ID - 1237802119, Name - Raja Muhammad Ahsan");
    
        // Create the main label for "PEBB Bank"
        JLabel welcomeLabel = new JLabel("PEBB Bank");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
    
        // Create the smaller label for "Your Way To the Future"
        JLabel subLabel = new JLabel("Your Way To the Future");
        subLabel.setForeground(Color.WHITE);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 14));  // Smaller font size for the subtext
    
        // Button to enter the app
        JButton enterButton = new JButton("Enter");
    
        // Action listener for the Enter button
        enterButton.addActionListener(e -> showLoginPage());
    
        // Layout constraints for the welcome page
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        welcomePanel.add(welcomeLabel, gbc);  // Add the main label to the panel
    
        // Add subLabel below welcomeLabel
        gbc.gridy = 1;
        welcomePanel.add(subLabel, gbc);
    
        // Add the Enter button below the subLabel
        gbc.gridy = 2;
        welcomePanel.add(enterButton, gbc);
    
        // Add the welcomePanel to the frame and show it
        add(welcomePanel, "WelcomePage");
    
        // Show the Welcome Page
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "WelcomePage");
    }
    
    private JPanel createPanel(String developerInfo) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(128, 0, 128));

        JLabel developerLabel = new JLabel(developerInfo);
        developerLabel.setForeground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        gbc.insets = new Insets(100, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 4;

        panel.add(developerLabel, gbc);

        return panel;
    }

    private void showLoginPage() {
        setTitle("Login Page");
    
        // Create the login panel
        JPanel loginPanel = createPanel("Developer: Student ID - 1237802107, Name - Parvez Mosharraf");
    
        // Create the main label for "PEBB Bank"
        JLabel welcomeLabel = new JLabel("PEBB Bank");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
    
        // Create the username and password labels
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
    
        // Create text fields for username and password input
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
    
        // Login button
        JButton loginButton = new JButton("Login");
    
        // Error message label
        JLabel errorMessageLabel = new JLabel("");
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setVisible(false);
    
        // Action listener for login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
    
            if ("user".equals(username) && "password".equals(password)) {
                showMainMenu();  // Successfully login, show main menu
            } else {
                errorMessageLabel.setText("Invalid username or password.");
                errorMessageLabel.setVisible(true);  // Show error message
            }
        });
    
        // Layout constraints for the login page
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    
        // Add PEBB Bank title at the top
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(welcomeLabel, gbc);  // Add the PEBB Bank title
    
        // Add username and password fields
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);
    
        // Add login button
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(loginButton, gbc);
    
        // Add error message label if username or password is invalid
        gbc.gridx = 0;
        gbc.gridy = 4;
        loginPanel.add(errorMessageLabel, gbc);
    
        // Add the login panel to the frame and show it
        add(loginPanel, "LoginPage");
    
        // Show the Login Page
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "LoginPage");
    }
    

    private void showMainMenu() {
        setTitle("Main Menu Page");
        JPanel mainMenuPanel = createPanel("Developer: Student ID - 1237802120, Name - Anthony");
    
        // Create the JLabel with HTML for multi-line text
        JLabel mainMenuLabel = new JLabel("<html><div style='text-align:center;'>PEBB Bank<br>Main Menu</div></html>");
        mainMenuLabel.setForeground(Color.WHITE);
        mainMenuLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centers the text horizontally
        mainMenuLabel.setVerticalAlignment(SwingConstants.CENTER);   // Centers the text vertically
    
        // Buttons for Main Menu
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton userInfoButton = new JButton("User Information");
    
        depositButton.addActionListener(e -> showDepositPanel());
        withdrawButton.addActionListener(e -> showWithdrawPanel());
        userInfoButton.addActionListener(e -> showUserInfo());
    
        // Cancel button action to prompt logout confirmation
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to log out?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
    
            if (response == JOptionPane.YES_OPTION) {
                showLoginPage();  // Navigate back to the login page
            }
        });
    
        messageLabel = new JLabel("");  // Initialize message label
        messageLabel.setForeground(Color.WHITE);
    
        // Layout for Main Menu
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainMenuPanel.add(mainMenuLabel, gbc);  // Add the modified label
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainMenuPanel.add(depositButton, gbc);
    
        gbc.gridy = 2;
        mainMenuPanel.add(withdrawButton, gbc);
    
        gbc.gridy = 3;
        mainMenuPanel.add(userInfoButton, gbc);
    
        gbc.gridy = 4;
        mainMenuPanel.add(cancelButton, gbc);
    
        gbc.gridy = 5;
        mainMenuPanel.add(messageLabel, gbc);  // Add the message label
    
        add(mainMenuPanel, "MainMenu");
    
        // Switch to Main Menu page
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "MainMenu");
    }
    

    private void showDepositPanel() {
        setTitle("Deposit Amount Page");
        JPanel depositPanel = createPanel("Developer: Student ID - 1237802124, Name - Muhammad Hassaan Bokhari");

        JLabel depositLabel = new JLabel("Deposit Amount:");
        depositLabel.setForeground(Color.WHITE);
        JTextField depositField = new JTextField(15);
        JButton depositButton = new JButton("Deposit");

        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(depositField.getText());
                account.deposit(amount);
                JOptionPane.showMessageDialog(this, "Deposited: " + amount + ". New Balance: " + account.getBalance(), "Deposit", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> showMainMenu());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        depositPanel.add(depositLabel, gbc);
        gbc.gridx = 1;
        depositPanel.add(depositField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        depositPanel.add(depositButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        depositPanel.add(cancelButton, gbc);

        add(depositPanel, "DepositPanel");

        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "DepositPanel");
    }

    private void showWithdrawPanel() {
        setTitle("Withdraw Amount Page");
        JPanel withdrawPanel = createPanel("Developer: Student ID - 1237802125, Name - Solomon Mekonen");
    
        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        withdrawLabel.setForeground(Color.WHITE);
        JTextField withdrawField = new JTextField(15);
        JButton withdrawButton = new JButton("Withdraw");
    
        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(withdrawField.getText());
                account.withdraw(amount);
    
                // Display the current balance after withdrawal
                JOptionPane.showMessageDialog(this, "Withdrawn: " + amount + ". New Balance: " + account.getBalance(), "Withdrawal", JOptionPane.INFORMATION_MESSAGE);
    
                // If overdraft occurred, display the overdraft message
                if (account.getBalance() < 0) {
                    JOptionPane.showMessageDialog(this, "You have overdrafted your account. Contact your bank for more information about interest rates.", "Overdraft Alert", JOptionPane.WARNING_MESSAGE);
                }
    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> showMainMenu());
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    
        gbc.gridx = 0;
        gbc.gridy = 0;
        withdrawPanel.add(withdrawLabel, gbc);
        gbc.gridx = 1;
        withdrawPanel.add(withdrawField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        withdrawPanel.add(withdrawButton, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        withdrawPanel.add(cancelButton, gbc);
    
        add(withdrawPanel, "WithdrawPanel");
    
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "WithdrawPanel");
    }
    
    private void showUserInfo() {
        // Create a panel for displaying user information
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new BorderLayout());
        userInfoPanel.setBackground(new Color(128, 0, 128));  // Set the background color
    
        // Create a label for the title or developer info at the top
        JLabel titleLabel = new JLabel("Developer: Student ID - 1237802104, Name - Md Riffat Ahmmad Sagor", SwingConstants.CENTER);
        titleLabel.setForeground(Color.YELLOW);  // Changed to yellow for better visibility
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    
        // Add the title label to the top of the panel
        userInfoPanel.add(titleLabel, BorderLayout.NORTH);
    
        // Create the user info string
        String userInfo = "<html>";
        userInfo += "Name: " + account.getPerson().getName() + "<br>";
        userInfo += "Phone: " + account.getPerson().getTel() + "<br>";
        userInfo += "Date of Birth: " + account.getPerson().getDob() + "<br>";
        userInfo += "Balance: $" + account.getBalance() + "<br>";
        userInfo += "</html>";
    
        // Create a label for displaying the user information
        JLabel userInfoLabel = new JLabel(userInfo);
        userInfoLabel.setForeground(Color.BLACK);  // Set font color to black for better contrast
        userInfoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
    
        // Create a scroll pane in case the text is too long for the screen
        JScrollPane scrollPane = new JScrollPane(userInfoLabel);
        scrollPane.setPreferredSize(new Dimension(600, 400));  // Set the size of the scrollable area
    
        // Add the scrollable text area to the center of the panel
        userInfoPanel.add(scrollPane, BorderLayout.CENTER);
    
        // Create a footer with a back button
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(128, 0, 128));  // Footer background color
    
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(e -> {
            // Close the user info frame and go back to the main menu
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
            topFrame.dispose();  // Close the current window
            showMainMenu();  // Show the main menu
        });
    
        footerPanel.add(backButton);
    
        // Add the footer panel to the bottom of the main panel
        userInfoPanel.add(footerPanel, BorderLayout.SOUTH);
    
        // Display the user information screen
        JFrame userInfoFrame = new JFrame("User Information");
        userInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userInfoFrame.setSize(800, 600);  // Set size for the new frame
        userInfoFrame.setLocationRelativeTo(null);  // Center the window
        userInfoFrame.setContentPane(userInfoPanel);  // Set the content of the frame
        userInfoFrame.setVisible(true);  // Show the new frame
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankApp().setVisible(true);
        });
    }
}
