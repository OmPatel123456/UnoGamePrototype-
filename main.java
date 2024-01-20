import java.util.Random;
import java.util.Scanner;

public class UNOmain {

	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in); //creates scanner for user input
		
		Cards deck = new Cards(); //list for entire game deck
		Cards player1_hand = new Cards(); //creates empty list that holds the players hand
		Cards player2_hand = new Cards();
		Cards gamePile = new Cards(); //empty list for gamepile 
		
		int player1_points = 0; //variable that holds amount of points for players
		int player2_points = 0;
		
		System.out.println("Player 1 Name: ");
		String name1 = user_input.next();
		System.out.println("Player 2 Name: ");
		String name2 = user_input.next();
		
		player player1 = new player(name1, player1_points); //uses contructor to initialize player1
		player player2 = new player(name2, player2_points); //uses contructor to initialize player2
		
		for (int i = 0; i < 3; i++) { //for loop runs 3 times for game 
			
			String [] deckColour = {"red", "green", "yellow", "blue"}; //String variable that holds colours of cards
			int [] deckNum = {1,2,3,4,5,6,7,8,9}; //int variable that holds num values of cards
			
			for (int x = 0; x < 94; x++) { //creates 94 randomized cards shuffled for the game deck
				
				Random rand = new Random();
				Random rand2 = new Random();
				
				int rand_combo = rand.nextInt(3);
				int rand_combo2 = rand.nextInt(8);
				
				deck.insertCard(deckNum[rand_combo2], deckColour[rand_combo]);
			}	
			
			for (int x = 0; x < 7; x++) {
				
				Random rand = new Random(); //randoms for player 1
				Random rand2 = new Random();
				
				Random rand3 = new Random(); //randoms for player 2
				Random rand4 = new Random();
				
				int rand_combo = rand.nextInt(3); //random numbers generated for player 1
				int rand_combo2 = rand.nextInt(8);
				
				int rand_combo3 = rand.nextInt(3); //random numbers generated for player 2
				int rand_combo4 = rand.nextInt(8);
				
				player1_hand.insertCard(deckNum[rand_combo2], deckColour[rand_combo]); //creates 7 randomize cards shuffled for player1
				player2_hand.insertCard(deckNum[rand_combo4], deckColour[rand_combo3]); //creates 7 randomize cards shuffled for player2
			}
			
			Cards.card del = deck.deleteTopOfDeck(); // block of code can be used when you need to skip turn
			gamePile.AddatTop_GamePile(del.getcardNum(), del.getcardColour()); //card to start the game taken from top of the game deck
			Cards.card gameTop = gamePile.returnTop_GamePile();
		
			while (player1_hand.handLength() != 0 || player1_hand.handLength() != 0) {
			
				System.out.println("The card at the top of the gamepile is:");
				gameTop.printCard(); //prints the card at the top of the gamePile
		
				System.out.println("It is " + player1.getName() + " turn!");
				System.out.println("Here is your hand of cards: ");
				player1_hand.printHand();
				
				System.out.println("The number of the card to be discarded. Non-Valid input will skip your turn:");
				int discard_num = user_input.nextInt();
				System.out.println("The colour of the card to be discarded. Non-Valid input will skip your turn:");
				String discard_colour = user_input.next();
				
				boolean bool = player1_hand.isValid(discard_num, discard_colour, gameTop.getcardColour(), gameTop.getcardNum());
				
				if (bool == true) { //if the input is valid 
					
			//		System.out.print(bool);
					Cards.card removed = player1_hand.deleteCard_FromHand(discard_num, discard_colour);
					gamePile.AddatTop_GamePile(removed.getcardNum(), removed.getcardColour());
					System.out.println("Your card was added sucessfully added to the top of the gamepile!");
					
				}
				
				else { //if the input was not valid
					
			//		System.out.print(bool);
					Cards.card del1 = deck.deleteTopOfDeck(); //new card is added to the game pile
					gamePile.AddatTop_GamePile(del1.getcardNum(), del1.getcardColour()); 
					Cards.card gameTop1 = gamePile.returnTop_GamePile();
					System.out.println("The card at the top of the gamepile is:");
					gameTop1.printCard(); //prints the top of gamepile
					
					Cards.card del2 = deck.deleteTopOfDeck();
					player1_hand.insertCard(del2.getcardNum(), del2.getcardColour()); //player picks up a card from the deck
					System.out.println(player1.getName() + " has picked up a card from the deck and turn is skipped!");
				}
				
				if (player1_hand.handLength() == 1) {
					
					System.out.println(player1.getName() + " has UNO!");
				}
				
				System.out.println("It is " + player2.getName() + " turn!");
				System.out.println("Here is your hand of cards: ");
				player2_hand.printHand();
				
				System.out.println("The number of the card to be discarded. Non-Valid input will skip your turn:");
				int discard_num1 = user_input.nextInt();
				System.out.println("The colour of the card to be discarded. Non-Valid input will skip your turn:");
				String discard_colour2 = user_input.next();
				
				System.out.println("The card at the top of the gamepile is:");
				Cards.card gameTop3 = gamePile.returnTop_GamePile(); //prints top of the gamepile
				
				boolean bool1 = player1_hand.isValid(discard_num1, discard_colour2, gameTop3.getcardColour(), gameTop3.getcardNum());
				
				if (bool1 == true) {
					
					Cards.card removed2 = player1_hand.deleteCard_FromHand(discard_num1, discard_colour2);
					gamePile.AddatTop_GamePile(removed2.getcardNum(), removed2.getcardColour());
					System.out.println("Your card was added sucessfully added to the top of the gamepile!");
				}
				
				else {
					
					Cards.card del3 = deck.deleteTopOfDeck(); //new card is added to the game pile
					gamePile.AddatTop_GamePile(del3.getcardNum(), del3.getcardColour()); 
					Cards.card gameTop1 = gamePile.returnTop_GamePile();
					System.out.println("The card at the top of the gamepile is:");
					gameTop1.printCard(); //prints the card that starts the game
					
					Cards.card del4 = deck.deleteTopOfDeck();
					player1_hand.insertCard(del4.getcardNum(), del4.getcardColour()); //player picks up a card from the deck
					System.out.println(player1.getName() + " has picked up a card from the deck and turn is skipped!");
				}
				
				if (player2_hand.handLength() == 1) { // if  player has one card
					
					System.out.println(player2.getName() + " has UNO!");
				}
			}
			
			if (player1_hand.handLength() == 0) { //if player had 0 cards after round, then add 100 points to their points
				
				player1_points = player1_points + 100;
				System.out.println(player1.getName() + " receieves 100 points");
				
				player1.putPoints(player1_points);
			}
			
			else if (player2_hand.handLength() == 0) {
				
				player2_points = player1_points + 100;
				System.out.println(player2.getName() + " receives 100 points");
				
				player1.putPoints(player2_points);
			}
				
		}
		
		if (player1_points == 300) { //if player has 300 points after all three rounds then player wins
			
			System.out.println(player1.getName() + " has won!");
		}
		
		else if (player2_points == 300) {
			
			System.out.println(player2.getName() + " has won!");
		}
		
	}

}

