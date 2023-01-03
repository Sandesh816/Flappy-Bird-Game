import java.awt.*;

public class Game {
    private int[] arrayOfScores;
    private int counter;
    private int highScore;



    public Game() {
        this.arrayOfScores = new int[50];
        this.counter=0;
        this.highScore=0;
    }

    public void fillArrayOfScores() {
        for (int i = 0; i < arrayOfScores.length; i++) {
            arrayOfScores[i] = 0;
            // Initially filling all places with zero. It is not a required step as Java automatically does that for us.
        }
    }
    public void startGame() {
        StdDraw.setScale(0, 10);
        while (true) {
            StdDraw.setPenColor(Color.black);
            StdDraw.text(5, 8.5, "Hello :) ");
            StdDraw.text(5, 8, "Welcome to the Flappy Bird game");
            StdDraw.text(5, 7, "Please press the 'R' key on keyboard to learn the rules");
            StdDraw.text(5, 6.5, "Please press the 'space' key on keyboard to start the game");

            if (StdDraw.isKeyPressed(82)) {
                StdDraw.clear();
                StdDraw.setPenColor(Color.black);
                StdDraw.text(5, 9, "🪙 Here are some info you need to know about the game:");
                StdDraw.pause(100);
                StdDraw.setPenColor(Color.blue);
                StdDraw.text(4.5, 7.5, "⚫ A flappy bird will travel in both horizontal and vertical ");
                StdDraw.text(1.2, 7.1, "direction ");
                StdDraw.pause(100);
                StdDraw.text(4.85, 6.4, "⚫ Both horizontal and vertical speeds depend on the difficulty");
                StdDraw.text(1.7, 6, "level you choose. ");
                StdDraw.pause(100);
                StdDraw.text(4.95, 5.3, "⚫ The bird keeps falling down unless you press the 'space' key ");
                StdDraw.pause(100);
                StdDraw.text(4.75, 4.6, "⚫ The bird will move downwards if you press the 'down' key");
                StdDraw.pause(100);
                StdDraw.text(4.63, 3.9, "⚫ Your score will increase on each pillar you pass through");
                StdDraw.pause(100);
                StdDraw.setPenColor(Color.black);
                StdDraw.text(5, 3, " That is it. Enjoy the game. Good Luck 👍");
                StdDraw.pause(100);

                StdDraw.setPenColor(Color.red);
                StdDraw.text(5, 2, "Press the 'B' key on keyboard to go back to main menu.");
                while (true)
                    if (StdDraw.isKeyPressed(66)) {
                        StdDraw.clear();
                        startGame();
                        break;
                    }
                break;
            }

            if (StdDraw.isKeyPressed(32)) {
                StdDraw.clear();
                StdDraw.text(5, 8, "Please choose the Difficulty level you want to play.");
                StdDraw.setPenColor(Color.green);
                StdDraw.text(5, 6, "Press '1' for easy level difficulty");
                StdDraw.setPenColor(Color.black);
                StdDraw.text(5, 5, "Press '2' for medium level difficulty");
                StdDraw.setPenColor(Color.blue);
                StdDraw.text(5, 4, "Press '3' for hard level difficulty");
                StdDraw.setPenColor(Color.red);
                StdDraw.text(5,1, "Press the 'B' key to go back to main menu");

                while (true) {
                    if (StdDraw.isKeyPressed(49)) {
                        StdDraw.clear();
                        drawBars(1, 5);
                        break;
                    }
                    else if (StdDraw.isKeyPressed(50)) {
                        StdDraw.clear();
                        drawBars(2, 5);
                        break;
                    }
                    else if (StdDraw.isKeyPressed(51)) {
                        StdDraw.clear();
                        drawBars(3, 5);
                        break;
                    }
                    else if (StdDraw.isKeyPressed(66)){
                        StdDraw.clear();
                        startGame();
                        break;
                    }
                }
                break;
            }
            StdDraw.setPenColor(Color.red);
            StdDraw.text(5, 3, "Please press 'Q' to quit the game.");
            if (StdDraw.isKeyPressed(81)){
                StdDraw.clear();
                StdDraw.setPenColor(Color.black);
                StdDraw.text(5, 6, "Are you sure you want to quit the game?");
                StdDraw.setPenColor(Color.red);
                StdDraw.text(3, 5, "Press 'Y' for YES");
                StdDraw.setPenColor(Color.blue);
                StdDraw.text(7, 5, "Press 'N' for NO");
                while (true)
                    if (StdDraw.isKeyPressed(89)){System.exit(1);}
                    else if (StdDraw.isKeyPressed(78)){StdDraw.clear();startGame();break;}
            }
        }
    }
    public void drawBars ( int n, double yofbird){
        int score = 0;
        StdDraw.setScale(0, 10);
        double x = 10;
        double vx=0;
        double lowerHeight = 2 + Math.random() * 12, upperHeight = 2 + Math.random() * 12;

        if (upperHeight <= 2) {upperHeight += 3;}

        double yBird = yofbird;
        int upCounter = 0;
        int downCounter = 0;
        StdDraw.enableDoubleBuffering();
        while (true) {
            if (n==1){vx = 0.65;} else if (n==2){vx = 0.85;} else if (n==3){vx = 0.99;}
            if ((x - vx) <= 0) {
                x = 10;
                lowerHeight = 2 + Math.random() * 12;
                upperHeight = 2 + Math.random() * 12;
                if (upperHeight <= 2) {upperHeight += 3;}

                StdDraw.picture(x, 1, "lowerpole.png", 1, lowerHeight / 2);
                StdDraw.picture(x, 9, "upperpole.png", 1, upperHeight / 2);
            }

            x = (x - vx);
            StdDraw.picture(x, 1, "lowerpole.png", 1, lowerHeight / 2);
            StdDraw.picture(x, 9, "upperpole.png", 1, upperHeight / 2);

            if (x>4.75 && x<5.10 && yBird < 10 - ((upperHeight / 4) + 1) && yBird > (lowerHeight / 2) - 1 - 0.75){score += 1;StdAudio.play("sfx_point.wav");}


            if (StdDraw.isKeyPressed(38)|| StdDraw.isKeyPressed(32)) {
                upCounter += 0.5;
                yBird += 1 + (0.2 * upCounter);
                StdAudio.play("sfx_upkey.wav");
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            }
            else if (StdDraw.isKeyPressed(40)) {
                downCounter += 0.15;
                yBird -= 1 - (0.2 * downCounter);
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            }
            else {
                if (n==1){yBird-=0.15;} else if (n==2){yBird-=0.20;} else if (n==3){yBird-=0.25;}
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            }

            if (yBird <= 1) {
                StdAudio.play("sfx_tala:maathi.wav");
                break;
            }
            if (yBird >= 9.75) {
                StdAudio.play("sfx_tala:maathi.wav");
                break;
            }
            if (yBird >= 10 - ((upperHeight / 4) + 1) && x > 4.25 && x < 5.75) {
                StdAudio.play("sfx_pillar.wav");
                break;
            }
            if (yBird <= (lowerHeight / 2) - 1 - 0.75 && x > 4.75 && x < 5.25) {
                StdAudio.play("sfx_pillar.wav");
                break;
            }

            // StdDraw.clear(); //It is commented here because we draw a big picture of sky every time the loop happens.
            StdDraw.picture(5,5, "Background.jpg", 10, 10, 0);
            StdDraw.picture(9, 8.5, "Sun.png", 2, 2, 0);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(1, 9, "Score: "+ score);
            if (score>= highScore){
                highScore=score;
            }
            StdDraw.text(1.4, 8.5, "Highest Score: "+highScore);
           // End of while loop.
        }

        StdDraw.setPenColor(Color.black);
        StdDraw.text(5, 8, "GAME OVER");
        StdDraw.pause(200);
        StdDraw.text(5, 7, "Your score is " + (score));
        arrayOfScores[counter]= score;
        counter+=1;
        for (int i=0; i<counter; i++){
            if (arrayOfScores[i]>=highScore){
                highScore = arrayOfScores[i];
            }
        }
        StdDraw.pause(200);
        StdDraw.text(5, 6, "Highest Score: "+ highScore);
        StdDraw.text(5, 5, "Press the 'space' key to restart the game with same difficulty level");
        StdDraw.setPenColor(Color.red);
        StdDraw.text(5, 4, "Press the 'B' key to go back to the main menu");

        while (true) {
            if (StdDraw.isKeyPressed(38)|| StdDraw.isKeyPressed(32)) {
                StdDraw.clear();
                drawBars(n, 5);
                break;
            }
            else if (StdDraw.isKeyPressed(66)) {
                StdDraw.clear();
                startGame();
                break;
            }
        }
    }
}



