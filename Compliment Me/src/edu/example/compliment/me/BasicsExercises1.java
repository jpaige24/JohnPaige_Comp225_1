package edu.example.compliment.me;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Random;

/** Loads a simple layout from main.xml. None of the GUI
 *  controls have any behavior, and strings are hardcoded
 *  in main.xml (not taken from strings.xml).
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class BasicsExercises1 extends Activity {
    /** Initializes the app when it is first created. */
	
	ArrayList<String> compliments;
	ArrayList<String> authors;
	protected int numClicks;
	protected LinearLayout layout;
	protected TextView complimentView;
	protected TextView authorView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	numClicks = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        System.out.println("compliment button id: " + findViewById(R.id.complimentButton));
        
        Button complimentButton = (Button) findViewById(R.id.complimentButton);
        complimentButton.setOnClickListener(new Toaster());
        complimentView = (TextView) findViewById(R.id.complimentView);
        authorView = (TextView) findViewById(R.id.authorView);
        layout = (LinearLayout) findViewById(R.id.background);
        
        compliments = new ArrayList<String>();
        authors = new ArrayList<String>();
        compliments.add("I like your jacket");
        authors.add("-Anonymous");
        compliments.add("Your voice is more soothing than Morgan Freeman's");
        authors.add("-Anonymous");
        compliments.add("You're more fun than bubble wrap");
        authors.add("-Anonymous, from Boston, MA");
        compliments.add("You intrigue me");
        authors.add("-Liz, from Pittsburgh, PA");
        compliments.add("I've had the time of my life, and I owe it all to you!");
        authors.add("-The Black Eyed Peas");
        compliments.add("You are full of youth");
        authors.add("-Anonymous");
        compliments.add("You're cooler than ice on the rocks");
        authors.add("-Anonymous");
        compliments.add("If you were around, I would enjoy doing my taxes.");
        authors.add("-Jim, Newtown, PA");
        compliments.add("You are the wind beneath my wings.");
        authors.add("-Steph, from Perkasie");
        compliments.add("I like the way your nostrils are placed on your nose.");
        authors.add("-Danielle and Grace");
        compliments.add("That looks nice on you.");
        authors.add("-Anonymous");
        compliments.add("You're tremendous!");
        authors.add("-Anonymous");
        compliments.add("Your T-shirt smells fresh.");
        authors.add("-Anonymous");
        compliments.add("You make me :)");
        authors.add("-Anonymous from Marlboro, NJ");
        compliments.add("Me like you is like a nerd without braces, a shoe without laces, asentencewithoutspaces.");
        authors.add("-Anonymous");
        compliments.add("You are like a spring flower; beutiful and vivacious");
        authors.add("-Anonymous");
        compliments.add("You look like you like to rock.");
        authors.add("-Anonymous");
        compliments.add("You have a good web-surfing stance.");
        authors.add("-Anonymous");
    }
    
    private class Toaster implements OnClickListener {
    	Random random;
    	Toaster() {
    		random = new Random();
    	}
    	
    	public void onClick(View clickedButton) {
    		int compID = random.nextInt(compliments.size());
    		String compliment = compliments.get(compID);
    		String author = authors.get(compID);
    		complimentView.setText(compliment);
    		authorView.setText(author);
    		
    		float i = random.nextFloat();
    		int c;
    		if(i < 1/3.0) c = Color.RED;
    		else if(i < 2/3.0) c = Color.GREEN;
    		else c = Color.BLUE;
    		layout.setBackgroundColor(c);
    		
    		numClicks++;
    		TextView compCounter = (TextView) findViewById(R.id.complimentCounter);
    		compCounter.setText("You have received " + numClicks + " compliments so far!");
    	}
    }
}