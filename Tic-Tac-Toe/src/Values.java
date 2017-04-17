import java.awt.Toolkit;

public enum Values {
	
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
	boxHeight1{

		@Override
		public int getValue() {
			return 100;
		}
		
	},
	boxHeight2{

		@Override
		public int getValue() {
			return 200;
		}
		
	},
	boxHeight3{

		@Override
		public int getValue() {
			return 300;
		}
		
	},
	boxHeight4{

		@Override
		public int getValue() {
			return 400;
		}
		
	},
	boxHeight5{

		@Override
		public int getValue() {
			return 500;
		}
		
	},
	boxHeight6{

		@Override
		public int getValue() {
			return 600;
		}
	
	}, boxHeight7{

		@Override
		public int getValue() {
			return 700;
		}
		
	},
	boxHeight8{

		@Override
		public int getValue() {
			return 800;
		}
		
	},
	boxHeight9{

		@Override
		public int getValue() {
			return 900;
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
