package fil.coo.donjon.item;

import java.util.Random;
import fil.coo.donjon.item.*;
import fil.coo.donjon.character.*;
import fil.coo.donjon.room.*;

import java.util.*;


/**
 * One Armed Bandit
 * In exchange of some gold, he will generate a random Item, who'll be use instantaneously by the player
 * @author DEROISSART / SASU
 *
 */

public class OneArmedBandit implements Item {
	
	//ATTRIBUTS
	
	private List<Item> sellingItems;
	
	Gold price;
	
	//CONSTRUCTEURS
	
	public OneArmedBandit (int price){
		this.price = new Gold (price);
		this.sellingItems = new ArrayList<Item>();
		this.sellingItems.add(new LifePotion());
		this.sellingItems.add(new StrengthPotion());
	}
	
	public OneArmedBandit (){
		this.price = new Gold (100);
		this.sellingItems = new ArrayList<Item>();
		this.sellingItems.add(new LifePotion());
		this.sellingItems.add(new StrengthPotion());
	}

	//METHODES
	
	/**
	 * Use one armed bandit
	 */
	public void use(DungeonCharacter dc){
		if (dc.getGold().getQuantity() >= this.price.getQuantity()){
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(this.sellingItems.size());
			Item p = this.sellingItems.get(randomInt);
			dc.subtractGold(this.price);
			p.use(dc);
			System.out.println("Player lost " + this.price);
			dc.getRoom().removeItem(this);
		}	
		else
			{
			dc.getRoom().removeItem(this);
			}
	}

	public String toString() {
		return " OneArmedBandit : price=" + price;
	}
	
	public void DescribesItem()
	{
		System.out.println(this.toString());
	}
	
	
}