import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class PlayField here.
 * 
 *  Name: Wyan Gregorio
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #3, Program #1
 * Date Last Modified: 11/9/2017 2:36 Pm
 * 
 * @author (your name) 
 * 
 */
public class PlayField extends World
{
    private boolean startGame = false;
    
    private static Ball theBall;
    private static Score player1Score;
    private static Score player2Score;
    
    /**
     * Constructor for objects of class PlayField.
     * 
     */
    public PlayField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        createBackground();
        initializePlayingField();
    }
    
    private void createBackground()
    {
        getBackground().setColor(Color.BLACK);
        getBackground().fillRect( 0, 0, getWidth(), getHeight() );
        
        getBackground().setColor(Color.GRAY);
        getBackground().fillRect( getWidth()/2 - 2, 0, 5, getHeight() );
        
        showText ("Press the spacebar to begin game!", 200, 550 );
    }
    
    private void initializePlayingField()
    {
        theBall = new Ball();
        
        player1Score = new Score(true);
        player2Score = new Score(false);
        
        addObject(theBall, getWidth()/2, getHeight()/2);
        addObject(player1Score, 200, 50 );
        addObject(player2Score, 600, 50);
        
        addObject(new Paddle(true), 10, getHeight()/2);
        addObject(new Paddle(false), getWidth()- 10, getHeight()/2 );
    }
    
    public void act()
    {
        
        if(startGame == false)
        {
            checkKeyPress();
            checkWin();
        }
        
    }
    
    private void checkKeyPress()
    {
        
        if( Greenfoot.isKeyDown("space"))
        {
            startGame = true;
            showText ("", 200, 550);
            theBall.setVelocity(5);
        }
        
    }
    
    public void reset()
    {
        theBall.setLocation( getWidth()/2, getHeight()/2);
        theBall.setVelocity(0);
        
        showText ("Press the spacebar to begin game!", 200, 550 );
        startGame = false;
    }
    
    private void checkWin()
    {
        GreenfootImage player1Win = new GreenfootImage( "Player 1 Wins!", 45, Color.GREEN ,Color.BLACK );
        GreenfootImage player2Win = new GreenfootImage( "Player 2 Wins!", 45,Color.RED , Color.BLACK );
        
        if( player1Score.getScore() >= 7 )
        {
                removeObjects( getObjects(null) );
				getBackground().setColor( Color.BLACK );
				getBackground().fillRect( 0, 0, getWidth(), getHeight() );
				getBackground().drawImage( player1Win, getWidth()/2, getHeight()/2);
        }
        else if( player2Score.getScore() >= 7 )
        {
                removeObjects( getObjects(null) );
				getBackground().setColor( Color.BLACK );
				getBackground().fillRect( 0, 0, getWidth(), getHeight() );
				getBackground().drawImage( player2Win, getWidth()/2, getHeight()/2);
        }
        
    }
       
    public boolean getStarted()
    {
        return startGame;
    }
    
}
