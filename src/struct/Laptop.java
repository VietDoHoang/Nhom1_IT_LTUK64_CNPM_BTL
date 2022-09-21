package struct;

/*
 * author: Do Hoang Viet
 */
public class Laptop extends Device {
	
	protected String cpu;
	protected double ram;
	protected double disk;

	public Laptop(Device dv) {
		super(dv);
		this.cpu =((Laptop) dv).cpu;
		this.ram = ((Laptop) dv).ram;
		this.disk = ((Laptop) dv).disk;
	}
	
	public Laptop(String[] t) {
		super(t);
		cpu = t[8];
		ram = Double.parseDouble(t[9]);
		disk = Double.parseDouble(t[10]);
	}

	public int getType() {
		return LAPTOP_TYPE;
	}
	@Override
	public String[] getStringArray() {
		// TODO Auto-generated method stub
		
		String t[] = new String[Device.LAPTOP_COLUMN_TITLE.length];
		t[0] = super.brand;
		t[1] = super.name;
		t[2] = super.model;
		t[3] = String.valueOf(super.year);
		t[4] = super.color;
		t[5] = String.valueOf(super.amount);
		t[6] = String.valueOf(super.sellPrice);
		t[7] = String.valueOf(super.costPrice);
		t[8] = cpu;
		t[9] = String.valueOf(ram);
		t[10] = String.valueOf(disk);
		return t;
	}
	
	
	
}
