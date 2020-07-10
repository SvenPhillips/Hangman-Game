import java.util.Scanner;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    while(running == true){
      int lives = 8;
      boolean game_status = true;
      String word = words.wordlists();
      char[] output = make_output(word);
      char[] wordcharacters = make_wordcharacters(word);
      while(game_status && lives > 0){
        System.out.println(output);
        System.out.println("lives: " + lives);
        char guess;
        System.out.println("guess a letter");
        String guess_word = sc.nextLine();
        if (guess_word.equals(word)) {
          System.out.println("you win!");
          game_status = false;
        }
        guess = guess_word.charAt(0);
        boolean correct_guess = false;
        for(int i = 0; i < wordcharacters.length; i++) {
          if (guess == wordcharacters[i]) {
            correct_guess = true;
            output[i] = wordcharacters[i];
          }
        }
        if(correct_guess == false){
          lives = lives - 1;
        }
        if (Arrays.equals(wordcharacters, output)){
          System.out.println("You win!");
          game_status = false;
        }
      }
      if(lives == 0){
        System.out.println("You lose!");
        System.out.println("The word was " + word);
      }
      System.out.println("Do you want to play again?");
      String playagain = sc.nextLine();
      if(playagain.equals("yes")){
        running = true;
      }
      else{
        running = false;
      }
    }
  }
  public static char[] make_output(String word) {
    char[] result = new char[word.length()];
    for (int i = 0; i < word.length(); i++){
      result[i] = '_';
    }
    return result;
  }
  public static char[] make_wordcharacters(String word){
    char[] result = new char[word.length()];
    for(int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      result[i] = c;
    }
    return result;  
  }
}