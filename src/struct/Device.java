package struct;

/*
 * Author: Do Hoang Viet
 */
public abstract class Device {
	 
	protected String brand;
	protected String name;
	protected String model;
	protected int year;
	protected String color;
	protected int amount;
	protected double sellPrice;
	protected double costPrice;
	
	public final static int LAPTOP_TYPE = 0;
	public final static int PHONE_TYPE = 1;
	public final static String[] LAPTOP_COLUMN_TITLE = { "Brand", "Name", "Model", "Year", "Color", "Amount", "Sell Price", "Cost Price", "CPU", "RAM (GB)", "Hard Disk (GB)" };
	public final static String[] PHONE_COLUMN_TITLE = { "Brand", "Name", "Model", "Year", "Color", "Amount", "Sell Price", "Cost Price", "Screen Size (inchs)", "Battery Life (hous)", "Camera (MP)" };

	/*
	 * data used to demo
	 */
	/*
	public final static String [][]LAPTOP_TEST_DATA = {
			{"Acer", "Aspire VX5-591G", "VX5-591G-62YZ", "2017", "Black", "1", "890", "700", "Intel Core i5 7300HQ", "8", "1000"},
			{"Dell", "Vostro 3500", "V5I3001W", "2020", "Black", "1", "550", "434.4", "Intel Core I5 1035G1", "8", "256"} ,
			{"Acer", "Aspire A315-56-502X", "NX.HS5SV.00F", "2019", "Black", "1", "569.99", "478.2", "Intel Core I5 1035G1", "4", "256"}, 
			{"Lenovo", "Ideapad Slim 3 ", "14ITL6 82H700DNVN ", "2018", "Grey", "1", "549.9", "456", "Intel Core I3 1115G4", "8", "512"}, 
			{"MSI", "Modern 14 ", "B10MW-482VN ", "2020", "Blue Stone", "1", "599.99", "443.4", "Intel Core I3 10110U", "8", "256"} ,
			{"HP", "HP 245 G8 ", "345R8PA ", "2019", "Silver", "1", "590", "478", "Ryzen 5 3500U", "4", "256"},
			{"Dell ", "Inspiron 7490 ", "N4I5106W ", "2018", "Silver", "1", "1110", "869.9", "Intel Core I5 10210U", "8", "512"},
			{"Acer", "Swift 3X SF314 510G 5742", "NX.A10SV.003 ", "2020", "Gold", "1", "1109.99", "800", "Intel Core I5 1135G7", "16", "1000"},
			{"LG ", "Gram 14ZD90N ", "V.AX53A5", "2019", "White", "1", "1099.99", "869.5", "Intel Core I5 1035G7", "8", "256"},
			{"LG", "Liber V14 ", "NS14A8VNF561", "2021", "Grey", "1", "749.9", "521.9", "Intel Core I5 10210U", "8", "256"},
			{"Apple", "Macbook Pro", "MYD82", "2020", "Space Gray", "1", "799.9", "500", "Apple M1", "8", "256"}
	};
	
	public final static String [][]PHONE_TEST_DATA = {
			{"Apple", "Iphone 11 Pro", "A2160", "2019", "Space Gray", "1", "809.99", "605", "5.8" , "3190", "12"},
			{"SamSung", "SamSung galaxy S21+", "Exynos 2100", "2020", "Grey", "1", "1199.99", "600", "6.7" , "4800", "64"},
			{"SamSung", "Samsung Galaxy A31", "A315G", "2021", "Red", "1", "267.2", "99.3", "7.59", "5000", "64"},
			{"Sony", "Xperia 1 II", "XQ-AT52", "2019", "White", "1", "1179.99", "693", "6.5", "5100", "128"},
			{"Realme", "Realme 7", "RMX2155", "2020", "White", "1", "293.99", "100", "6.5", "5000", "48"},
			{"Oppo", "OPPO Reno2 Z", "CPH1951", "2020", "Luminous Black", "1", "494.97", "294", "6.5", "5000", "48.0"}
			
	};
	*/
	
	public Device(Device dv) {
		this.brand = dv.brand;
		this.name = dv.name;
		this.model = dv.model;
		this.year = dv.year;
		this.color = dv.color;
		this.amount = dv.amount;
		this.sellPrice = dv.sellPrice;
		this.costPrice = dv.costPrice;
	}
	
	public Device(String[] t) {
		this.brand = t[0];
		this.name = t[1];
		this.model = t[2];
		this.year = Integer.parseInt(t[3]);
		this.color = t[4];
		this.amount = Integer.parseInt(t[5]);
		this.sellPrice = Double.parseDouble(t[6]);
		this.costPrice = Double.parseDouble(t[7]);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Device d = (Device) obj;
		if (!model.equals(d.model)) return false;
		if (!name.equals(d.name)) return false;
		if (!brand.equals(d.brand)) return false;
		if (year != d.year) return false;
		if (!color.equals(d.color)) return false;
		if (sellPrice != d.sellPrice) return false;
		if (costPrice != d.costPrice) return false;
		return true;
	}

	public abstract int getType();
	
	public abstract String[] getStringArray();	
	
}
