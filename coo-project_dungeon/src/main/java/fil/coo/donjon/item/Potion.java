package fil.coo.donjon.item;

import fil.coo.donjon.character.*;


public  abstract class Potion implements Item {
	
		//ATTRIBUTS
		protected int points;
		
		//CONSTRUCTEUR
		
		public Potion (int Points){
			this.points = Points;
		}
		
		public Potion (){
			this.points = 10;
		}	
		
		//METHODES
		
		public abstract void use(DungeonCharacter dc);

		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Potion other = (Potion) obj;
			if (points != other.points)
				return false;
			return true;
		}
		
		public void DescribesItem()
		{
			System.out.println(this.toString());
		}
		
		
		
		
}

