import java.awt.Toolkit;

public enum Values {
	//XXX Add any values that never change here!
	lineOnePosition{

		@Override
		public int getValue() {
			
			return 300;
		}
		
	},
	lineTwoPosition{

		@Override
		public int getValue() {
			
			return 600;
		}
		
	},
	
	frameWidth{

		@Override
		public int getValue() {
			return 900;
		}
	},
	frameHeight{

		@Override
		public int getValue() {
			return 900;
		}

	},
	screenWidth{

		@Override
		public int getValue() {
			return (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		}

	},
	screenHeight{

		@Override
		public int getValue() {
			return (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		}

	};
//Required method for each value.
	public abstract int getValue();

}
