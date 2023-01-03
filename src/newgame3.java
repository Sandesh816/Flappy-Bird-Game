import javax.imageio.IIOException;
import javax.lang.model.element.Name;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class newgame3 {
    private int [] arrayOfScores;
    public int counter;
    public int highScore;
    public String Name;

    public newgame3() {
        this.arrayOfScores = new int [50];
        this.counter=0;
        this.highScore=0;
    }

    public void fillArrayOfScores() {
        for (int i = 0; i < arrayOfScores.length; i++) {
            arrayOfScores[i] = 0;
            // Initially filling all places with zero. It is not a required step as Java automatically does that for us.
        }
    }
    public void askName(){
        System.out.println("Hello user! Please input your name here: ");
        Scanner name = new Scanner(System.in);
        Name = name.next();
        if (Name!=""){
            System.out.println( "Good luck "+ Name);
        }
        StdAudio.playInBackground("song.wav");
    }
    public void startGame() {
        StdDraw.setScale(0, 10);
        StdDraw.setFont(new Font("Calibre", Font.ITALIC, 50));
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(5,5, "Loading...");
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.picture(5, 5, "flappybirdstartingscreen.gif", 10, 10);
            StdDraw.setFont(new Font("Times", Font.BOLD, 20));
            StdDraw.picture(2, 1, "button.png", 2.5, 2.5);
            StdDraw.picture(5, 2.1, "button.png", 2.5, 2.5);
            StdDraw.picture(8, 1, "button.png", 2.5, 2.5);
            StdDraw.setPenColor(Color.blue);
            StdDraw.text(2, 1, "Rules");
            StdDraw.setPenColor(Color.green);
            StdDraw.text(5, 2.1, "Start");
            StdDraw.setPenColor(Color.red);
            StdDraw.text(8, 1, "Quit");
            if (StdDraw.isMousePressed()) {
                if (StdDraw.mouseX() > 0.75 && StdDraw.mouseX() < 3.25 && StdDraw.mouseY() > 0.25 && StdDraw.mouseY() < 2.25) {
                    // StdDraw.isKeyPressed(82)
                    StdDraw.disableDoubleBuffering();
                    StdDraw.clear();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.setFont(new Font("Calibre", Font.PLAIN, 16));
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
                    StdDraw.text(5, 3, " That is it. Enjoy the game. Good Luck " + Name + "  👍");
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
            }

            if (StdDraw.isMousePressed()) {
                if (StdDraw.mouseX() > 3.75 && StdDraw.mouseX() < 6.25 && StdDraw.mouseY() > 0.85 && StdDraw.mouseY() < 3.35) {
                    StdDraw.disableDoubleBuffering();
                    StdDraw.clear();
                    StdDraw.text(5, 8, "Please choose the Difficulty level you want to play.");
                    StdDraw.setPenColor(Color.green);
                    StdDraw.text(5, 6, "Press '1' for easy level difficulty");
                    StdDraw.setPenColor(Color.black);
                    StdDraw.text(5, 5, "Press '2' for medium level difficulty");
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.text(5, 4, "Press '3' for hard level difficulty");
                    StdDraw.setPenColor(Color.red);
                    StdDraw.text(5, 1, "Press the 'B' key to go back to main menu");

                    while (true) {
                        if (StdDraw.isKeyPressed(49)) {
                            StdDraw.clear();
                            drawBars(1, 5);
                            break;
                        } else if (StdDraw.isKeyPressed(50)) {
                            StdDraw.clear();
                            drawBars(2, 5);
                            break;
                        } else if (StdDraw.isKeyPressed(51)) {
                            StdDraw.clear();
                            drawBars(3, 5);
                            break;
                        } else if (StdDraw.isKeyPressed(66)) {
                            StdDraw.clear();
                            startGame();
                            break;
                        }
                    }
                    break;
                }
            }
            if (StdDraw.isMousePressed()) {
                if (StdDraw.mouseX() > 6.75 && StdDraw.mouseX() < 9.25 && StdDraw.mouseY() > 0.25 && StdDraw.mouseY() < 2.25) {
                    StdDraw.disableDoubleBuffering();
                    StdDraw.clear();
                    StdDraw.setPenColor(Color.black);
                    StdDraw.text(5, 6, "Are you sure you want to quit the game?");
                    StdDraw.setPenColor(Color.red);
                    StdDraw.text(3, 5, "Press 'Y' for YES");
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.text(7, 5, "Press 'N' for NO");
                    while (true)
                        if (StdDraw.isKeyPressed(89)) {
                            System.exit(1);
                        } else if (StdDraw.isKeyPressed(78)) {
                            StdDraw.clear();
                            startGame();
                            break;
                        }
                }
            }
            StdDraw.show();
            StdDraw.pause(20);
        }

        StdDraw.disableDoubleBuffering();
    }
    public void drawBars ( int n, double yofbird){
        StdAudio.playInBackground("song.wav");
        StdDraw.setFont(new Font("Calibre", Font.PLAIN, 20));
        int score = 0;
        StdDraw.setScale(0, 10);
        double x = 10;
        double vx=0;



        double gap= 1+ Math.random()*2;
        double upperHeight = 2+ Math.random()*10;
        double lowerHeight= 4*(10-gap-(upperHeight/2));
        double Sx = 0;



        double yBird = yofbird;
        int upCounter = 0;
        int downCounter = 0;

        StdDraw.enableDoubleBuffering();
        while (true) {

            if (n == 1) {
                vx = 0.45;
            } else if (n == 2) {
                vx = 0.65;
            } else if (n == 3) {
                vx = 0.85;
            }
            if ((x - vx) <= 0) {
                x = 10;
                 gap= 0.5+ Math.random()*1;
                 upperHeight = 2+ Math.random()*13;
                 lowerHeight= 4*(10-gap-(upperHeight/2));
                StdDraw.picture(x, 0, "lowerpole.png", 1, lowerHeight / 2);
                StdDraw.picture(x, 10, "upperpole.png", 1, upperHeight / 2);
            }

            x = (x - vx);
            StdDraw.picture(x, 0, "lowerpole.png", 1, lowerHeight / 2);
            StdDraw.picture(x, 10, "upperpole.png", 1, upperHeight / 2);

            if (x > 4.75 && x < 5.10 && yBird < 10 - ((upperHeight / 4) ) && yBird > (lowerHeight / 4)) {
                score += 1;
                StdAudio.playInBackground("sfx_point.wav");
            }


            if (StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(32)) {
                upCounter += 0.5;
                yBird += 1 + (0.2 * upCounter);
                StdAudio.playInBackground("sfx_wing.wav");
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            } else if (StdDraw.isKeyPressed(40)) {
                downCounter += 0.15;
                yBird -= 1 - (0.2 * downCounter);
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            } else {
                if (n == 1) {
                    yBird -= 0.15;
                } else if (n == 2) {
                    yBird -= 0.20;
                } else if (n == 3) {
                    yBird -= 0.30;
                    //  yBird -= 0.25;
                }
                StdDraw.picture(5, yBird, "Flappybirdgif-unscreen.gif", 1.65, 1.25);
                StdDraw.show();
                StdDraw.pause(50);
            }

            if (yBird <= 1) {
                StdAudio.playInBackground("sfx_die.wav");
                break;
            }
            if (yBird >= 9.75) {
                StdAudio.playInBackground("sfx_swooshing.wav");
                break;
            }
            if (yBird >= 10 - ((upperHeight / 4) ) && x > 4.25 && x < 5.75) {
                StdAudio.playInBackground("sfx_hit.wav");
                //  StdAudio.play("sfx_pillar.wav");
                break;
            }
            if (yBird <= (lowerHeight / 4)   && x > 4.75 && x < 5.25) {
                StdAudio.playInBackground("sfx_hit.wav");
                break;
            }

            // StdDraw.clear(); //It is commented here because we draw a big picture of sky every time the loop happens.
            Sx += 0.05;
            if (Sx <= 10) {
                StdDraw.picture(5, 5, "Background.jpg", 10, 10, 0);
                StdDraw.picture(Sx, 9, "Sun2-removebg-preview.png", 4, 4, 0);
            } else if (Sx > 10 && Sx<=20) {
                StdDraw.picture(5, 5, "flappybirddark.png", 10, 10, 0);
                StdDraw.picture(Sx-10, 9, "Moon2.png", 4, 4, 0);
            }else if (Sx > 20 && Sx<=30) {
                StdDraw.picture(5, 5, "Background.jpg", 10, 10, 0);
                StdDraw.picture(Sx-20, 9, "Sun2-removebg-preview.png", 4, 4, 0);
            }else if (Sx > 30 && Sx<=40) {
                StdDraw.picture(5, 5, "flappybirddark.png", 10, 10, 0);
                StdDraw.picture(Sx-30, 9, "Moon2.png", 4, 4, 0);
            }else if (Sx > 40 && Sx<=50) {
                StdDraw.picture(5, 5, "Background.jpg", 10, 10, 0);
                StdDraw.picture(Sx-40, 9, "Sun2-removebg-preview.png", 4, 4, 0);
            }else if (Sx > 50 && Sx<=60) {
                StdDraw.picture(5, 5, "flappybirddark.png", 10, 10, 0);
                StdDraw.picture(Sx-50, 9, "Moon2.png", 4, 4, 0);
            }else if (Sx > 60 && Sx<=70) {
                StdDraw.picture(5, 5, "Background.jpg", 10, 10, 0);
                StdDraw.picture(Sx-60, 9, "Sun2-removebg-preview.png", 4, 4, 0);
            }else if (Sx > 70 && Sx<=80) {
                StdDraw.picture(5, 5, "flappybirddark.png", 10, 10, 0);
                StdDraw.picture(Sx-70, 9, "Moon2.png", 4, 4, 0);
            }else if (Sx > 80 && Sx<=90) {
                StdDraw.picture(5, 5, "Background.jpg", 10, 10, 0);
                StdDraw.picture(Sx-80, 9, "Sun2-removebg-preview.png", 4, 4, 0);
            }else if (Sx > 90 && Sx<=100) {
                StdDraw.picture(5, 5, "flappybirddark.png", 10, 10, 0);
                StdDraw.picture(Sx-90, 9, "Moon2.png", 4, 4, 0);
            }
            if (score==100){
                StdDraw.text(5,5,"You won the game.");
                StdDraw.pause(500);
                break;
            }
            StdDraw.setPenColor(Color.white);
            StdDraw.setFont(new Font("Times New Roman", Font.BOLD, 75));
            StdDraw.text(5, 7, "" + score);
            StdDraw.setFont();
            if (score >= highScore) {
                highScore = score;
            }
            StdDraw.text(1.4, 9, "Highest Score: ");
            StdDraw.text(1.5, 8.5, ""+ Name + ": "+ highScore);
            StdDraw.text(1.2, 7.5, "Past Scores:" );
            for (int i=0; i<counter; i++){
                StdDraw.text(1, 7-(0.3*i), ""+ arrayOfScores[i] );
            }
            if (n==1&&score==25){n=2;}
            if (n==2&&score==50){n=3;}
            // End of while loop.
        }
        StdDraw.disableDoubleBuffering();
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
        StdDraw.text(5, 0.4, "Press the 'B' key to go back to the main menu");

        while (true)

        {
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




