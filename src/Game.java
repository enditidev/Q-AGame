import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int point;
    private int question_num = 0;

    // Swing components
    private Container container;
    private JPanel questionPane, answerPane, nextChallengePane;
    private static JPanel FilePane;
    private JTextField answer;
    private JLabel checker, question, score;
    private BufferedReader reader_Ans;
    private BufferedReader reader_Ques;
    private File questionFile, answerFile;
    private JMenuBar menuBar;
    final JFileChooser fileDialog = new JFileChooser();
    static ArrayList<String> ques = new ArrayList<String>();
    static ArrayList<String> ans = new ArrayList<String>();
    // Queue and Stack
    private Queue<File> queue = new LinkedList<> ();
    private Stack<File> stack = new Stack<File> ();
    private int isStack;

    public Game() throws IOException {
        super("Challenge Gameshow"); // use this instead of setTitle for JFrame
        init();
        try {
			Music music = new Music();
		} 
        catch (LineUnavailableException e) {} 
        catch (IOException e) {} 
        catch (UnsupportedAudioFileException e) {}
        
       
    }

    private void init() throws IOException {
        // readFile(); // add this line to fix bug

        this.point = 0;
        container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); // arrange vertialy

        renderFileChooser();
        // container.add(FilePane);

        renderQuestionPane();
        renderAnswerPane();
        renderNextChallengePane();
        container.add(questionPane);
        container.add(answerPane);
        container.add(nextChallengePane);

        menuBar = new Menu(FilePane);

        this.setJMenuBar(menuBar);
        renderWindow();
    }

    /**
     * Add this funciton to fix bug
     * 
     * @throws IOException
     */
    private void readFile() throws IOException {
        String question_name = questionFile.getName();
        
        answerFile = new File(questionFile.getParentFile().getAbsolutePath() + "\\" + question_name.substring(0, question_name.lastIndexOf("_")) + "_answer.txt");
        System.out.println(questionFile.getParentFile().getAbsolutePath() + "\\" + question_name.substring(0, question_name.lastIndexOf("_")) + "_answer.txt");
        InputStream inputStream_Ques = new FileInputStream(questionFile);
        
        InputStream inputStream_Ans = new FileInputStream(answerFile);
        InputStreamReader inputStreamReader_Ques = new InputStreamReader(inputStream_Ques);
        InputStreamReader inputStreamReader_Ans = new InputStreamReader(inputStream_Ans);
        
        reader_Ques = new BufferedReader(inputStreamReader_Ques);
        reader_Ans = new BufferedReader(inputStreamReader_Ans);

        // clear list
        ques.clear();
        ans.clear();
        String line_Ques = "";
        String line_Ans = "";
        while ((line_Ques = reader_Ques.readLine()) != null && (line_Ans = reader_Ans.readLine()) != null) {
            ques.add(line_Ques);
            ans.add(line_Ans);
        }

        // close stream
        inputStream_Ques.close();
        inputStreamReader_Ans.close();
    }

    private void renderWindow() {
        setSize(400, 250);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void renderFileChooser() {
        FilePane = new JPanel();
        FilePane.setPreferredSize(new Dimension(400, 100));

        // question
        JPanel questionFilePane = new JPanel(new FlowLayout(1, 10, 0));
        JButton ques_choose_file = new JButton("Choose File");
        JLabel ques_file_choosed = new JLabel("");

        // JFileChooser config
        fileDialog.setDialogTitle("File");
        fileDialog.setCurrentDirectory(new java.io.File(".")); // get current directory
        fileDialog.setMultiSelectionEnabled(true);

        ques_choose_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int res = fileDialog.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                	String[] options = {"Queue", "Stack"};
                	 isStack = JOptionPane.showOptionDialog(null, "Choose play type",
                             "Select play type",
                             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
             		File[] files = fileDialog.getSelectedFiles();
                	for (File file : files) { 
                		if (isStack == 0) { // Means choose queue
                			queue.add(file);
                		} else if (isStack == 1) { // Means choose stack
                			stack.add(file);
                		}	
                	}}
            }

        });

        questionFilePane.add(new JLabel("File: "));
        questionFilePane.add(ques_choose_file);
        questionFilePane.add(ques_file_choosed);

        // Confirm button
        JButton confirmBtn = new JButton("Let's go");
        confirmBtn.setPreferredSize(new Dimension(160, 30));
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // read file
                    if (isStack == 0) { // Means choose Queue	
                    	handleQueue();
                    } else if (isStack == 1) { // Means choose Stack
                    	handleStack();
                    }
                    makeNewGame();
                } catch (Exception ecep) {
                    JOptionPane.showMessageDialog(container, "Cannot Open file", "Error", JOptionPane.CANCEL_OPTION);
                }
            }
        });

        FilePane.add(questionFilePane);
        
        FilePane.add(confirmBtn);
    }
    
    private void handleQueue() throws IOException {
    	questionFile = queue.remove();
        readFile();
    }
    private void handleStack() throws IOException {
    	questionFile = stack.pop();
        readFile();
    }
    private void makeNewGame() {
        // config new game
        question_num = 0;
        point = 0;
        question.setText("Quesiton: " + ques.get(question_num));
        score.setText("Total: " + point);
        answer.setEnabled(true);
    }

    private void renderQuestionPane() {
        questionPane = new JPanel(new FlowLayout(1, 10, 10));

        question = new JLabel("Quesiton: ");

        questionPane.add(question);
    }

    private void renderAnswerPane() {
        answerPane = new JPanel(new FlowLayout(1, 5, 5));

        answer = new JTextField(20);
        answer.addActionListener(this); // add event listener
        checker = new JLabel("");
        score = new JLabel("Total: " + this.point);

        answer.setEnabled(false);

        answerPane.add(new JLabel("Your answer: "));
        answerPane.add(answer);
        answerPane.add(score);
        answerPane.add(checker);
    }
    
    private void renderNextChallengePane() {
    	nextChallengePane = new JPanel();
    	JButton next = new JButton("NEXT");
    	next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // read file
                    if (isStack == 0) { // Means choose Queue	
                    	handleQueue();
                    } else if (isStack == 1) { // Means choose Stack
                    	handleStack();
                    }
                    makeNewGame();
                } catch (Exception ecep) {
                    JOptionPane.showMessageDialog(container, "Cannot Open file", "Error", JOptionPane.CANCEL_OPTION);
                }
            }
        });
    	
    	nextChallengePane.add(next);
    }

    public static void main(String[] args) throws IOException {
        Game g = new Game();
    }

    // Catch event
    @Override
    public void actionPerformed(ActionEvent e) {
        String res = answer.getText();

        if (res.equalsIgnoreCase(ans.get(question_num))) {
        	try
        	{
				WinMusic wnMusic = new WinMusic();
				wnMusic.start();
			}
        	catch (LineUnavailableException e1) {}
        	catch (IOException e1) {} 
        	catch (UnsupportedAudioFileException e1) {} 
            question_num++;
            point++;
            checker.setText("");
            answer.setText("");
            score.setText("Score: " + point);

            // try and catch error when out of quesion ==> end game
            try {
                question.setText("Question: " + ques.get(question_num));
            } 
            catch (IndexOutOfBoundsException exception) {
                question.setText("You win!!!");              
                answer.setEnabled(false); // disable answer when game end               
            }
        } else {
        	try
        	{
				LoseMusic wnMusic = new LoseMusic();
				wnMusic.start();
			}
        	catch (LineUnavailableException e1) {}
        	catch (IOException e1) {} 
        	catch (UnsupportedAudioFileException e1) {} 
            checker.setText("Wrong aswer!!!");
            
        }
    }

}