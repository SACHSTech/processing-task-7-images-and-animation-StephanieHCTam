import processing.core.PApplet;
import processing.core.PImage; // import the PImage library

/**
 * A program that has animation and images.
 * @author: Stephanie Tam
 */

public class Sketch extends PApplet {

  PImage imgSpace; // declare a global image variable
  PImage imgRocket;

  float rocketX = 200;
  float rocketY = 400;

  float xSpeed = 2;
  float ySpeed = 2;

  float circleX = 0;
  float circleY = 100;
  float circleAngle = 0;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(600, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    
    // load images
    imgSpace = loadImage("imgSpace.png");
    imgRocket = loadImage("Cartoon_space_rocket.png");
    imgRocket.resize(imgRocket.width/20, imgRocket.height/20); //resize Rocket
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    // draw background
    image(imgSpace, 0, 0);
	  
    // meteor (animate a shape)
    fill(165, 128, 190);
    noStroke();
    ellipse(circleX, circleY, 100, 100);

    // non-linear path for meteor
    circleX += 1;
    circleY = circleY + sin(circleAngle)*2; 
    circleAngle += PI/120;

    // reset meteor to reappear on screen
    if(circleX > width) {
      circleX = 0;
    }
    
    //rocket (animate an image)
    image(imgRocket, rocketX, rocketY);
    
    // speed of rocket
    rocketX += xSpeed;
    rocketY += ySpeed;

    // collisison detection for rocket
    //bounce off left and right
    if(rocketX < 0 || rocketX > width - 120) {
      xSpeed *= -1;
    }
    // bounce off top and bottom
    if(rocketY < 20 || rocketY > height - 115) {
      ySpeed *= -1;
    }

  }
}