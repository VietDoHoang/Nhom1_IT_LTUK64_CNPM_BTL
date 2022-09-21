package struct;

/*
 * Author: Do Hoang Viet
 */
public class Phone extends Device{
	protected double screen;
	protected double battery;
	protected double camera;

	public Phone(Device dv) {
		super(dv);
		this.screen =((Phone) dv).screen;
		this.battery = ((Phone) dv).battery;
		this.camera = ((Phone) dv).camera;
	}
	

	public Phone(String[] t) {
		super(t);
		screen = Double.parseDouble(t[8]);
		battery = Double.parseDouble(t[9]);
		camera = Double.parseDouble(t[10]);
	}
	
	public int getType() {
		return PHONE_TYPE;
	}
	
	@Override
	public String[] getStringArray() {
		// TODO Auto-generated method stub
		
		String t[] = new String[Device.PHONE_COLUMN_TITLE.length];
		t[0] = super.brand;
		t[1] = super.name;
		t[2] = super.model;
		t[3] = String.valueOf(super.year);
		t[4] = super.color;
		t[5] = String.valueOf(super.amount);
		t[6] = String.valueOf(super.sellPrice);
		t[7] = String.valueOf(super.costPrice);
		t[8] = String.valueOf(screen);
		t[9] = String.valueOf(battery);
		t[10] = String.valueOf(camera);
		return t;
	}
	
}
