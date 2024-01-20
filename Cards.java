import javax.imageio.plugins.bmp.BMPImageWriteParam;

public class Cards { //linked list that holds cards of players 
	
	card head;
//_____________________________________________________________________	
	class card{
		 // 
		private String colour; //privated field that holds colour of the card 
		private int num; //privated field that holds the number of the card
		card link; //links to next card in the linked list
		
		card(String c, int n, card l){ //constructor for card object that has three parameters 
			
			colour = c;
			num = n;
			link = l;
		}
		
		public int getcardNum() {
			
			return num;
		}
		
		public String getcardColour() {
			
			return colour;
		}
		
		public void printCard(){ //prints card information such as colour and number
			
			System.out.print(num);
			System.out.print(" ");
			System.out.println(colour);
		}
	}
//______________________________________________________________________ instance methods for list below
	
	public void insertCard(int card_num, String card_colour) { //inserts a card into deck, in a least to greatest number of the card manner
		
		card current = head;
		card previous = null;
		boolean located = false;
		
		while (located == false && current != null) {
			
			if (card_num < current.num) { 
				
				located = true;
			}
			
			else {
				
				previous = current; //moves along the list if located is still false
				current = current.link;	
			}
		}
		
		card newCard = new card(card_colour, card_num, current);
		
		if (current == head) { //if new card was inserted into an empty list
			
			head = newCard;
		}
		
		else {
			
			previous.link = newCard;
		}
	}
	
	public card deleteCard(int card_num, String card_colour, String gamepile_topColour, int gamepile_topNumber) { //deletes the card with the matching the number OR colour passed in
		
		card current = head;
		card previous = null;
		boolean found = false;
		
		while (found == false && current != null) {
			
			if ((card_num == current.num && current.num == gamepile_topNumber) || (card_colour.equals(current.colour) && (current.colour.equals(gamepile_topColour)))) { //if a VALID match is found
				
				found = true;
			}
			
			else {
				
				previous = current; //moves along the list if 
				current = current.link;
			}
		}
		
		if (found == true) { //if card in the list was matched with number passed in
			
			if (current == head) {
				
				head = head.link; //if the card being removed is the first node
			}
			
			else {
				
				previous.link = current.link; 
			}
		}
		
		return current;
	}
	
	public void printHand() { //prints entire hand of player
		
		for (card temp = head; temp != null; temp = temp.link) {
			
			temp.printCard();
		}
	}
	
	public card deleteTopOfDeck() { //this method removes the TOP card from the deck to be inserted into hand
		
		//this method needs an accessor to work in the main
		
		card top_card = head;
		
		head = head.link;
		
		return top_card;
	}
	
	public void handLength() {
		
		int num_of_cards = 0;
		for (card temp = head; temp != null; temp = temp.link) {
			
			num_of_cards = num_of_cards + 1;
		}
		
		if (num_of_cards == 1) {
			
			System.out.println("UNO!");

		}
		
		else if (num_of_cards == 0) {
			
			System.out.println("Congrats, you won");
		}
	}
	
	public void AddatTop_GamePile(int discarded_card_num, String discarded_card_colour) { //inserts discards pile from hand to the top 
		
		//this method needs an accessor to work in the main
		
		head = new card(discarded_card_colour, discarded_card_num, head);
	}

