package quize;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Score extends JFrame implements ActionListener {

    private String name;
    private int score;

    Score(String name, int score) {
        this.name = name;
        this.score = score;

        setBounds(400, 150, 750, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Thank you, " + name + ", for playing Simple Minds!");
        heading.setBounds(100, 50, 500, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel scoreLabel = new JLabel("Your Score: " + score);
        scoreLabel.setBounds(240, 150, 300, 50);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(scoreLabel);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(190, 300, 150, 45);
        playAgainButton.setBackground(new Color(30, 144, 255));
        playAgainButton.setFont(new Font("Tahoma", Font.BOLD, 19));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.addActionListener(this);
        add(playAgainButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 300, 150, 45);
        exitButton.setBackground(new Color(255, 69, 0)); // Red color for exit button
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 19));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveScoreToDatabase();
                System.exit(0);
            }
        });
        add(exitButton);

        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        setLocation(330, 80);
        setVisible(true);
    }

    private void saveScoreToDatabase() {
        Connection conn = new Connection(); // Use uppercase "C" for Connection

        // Get the current date and time
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());

        // Execute the SQL query to insert the name, score, and timestamp
        String query = "INSERT INTO quiz (name, score, timestamp) VALUES ('" + name + "', " + score + ", '" + timestamp + "')";
        try {
            conn.s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        saveScoreToDatabase();
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
