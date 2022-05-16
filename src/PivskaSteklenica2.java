// Avtor:	Marko Keber

// Deklariramo javni razred
// razširja razred Steklenica (od nje podeduje vse lastnosti in metode)
// + implementira vmesnik AlkoholnaPijaca (predpisuje katere metode morajo biti implementirane, ko se program izvede)
public class PivskaSteklenica2 extends Steklenica implements AlkoholnaPijaca {      // extends - vzame spremenljivke + metode iz class Steklenica in doda vse spodaj

	// Vse lastnosti, ki jih imajo steklenice
	// Dodatne lastnosti, ki veljajo le za pivske steklenice:
	private double stopnjaAlkohola;  // v%
	private String proizvajalec;
	private String stil; 
	private double temperatura;		// v stC
	
	// KONSTRUKTOR - nov konstruktor, ker konstruktor v class Steklenica ne vsebuje novih lastnosti (zgoraj)
	// vhodi: velikost steklenice (pride iz class Steklenica), proizvajalec, stil, alkohol
	// vrne:  nov objekt tipa PivskaSteklenica
	public PivskaSteklenica2(int k, String p, String s, double a) {
		
		// Pokličemo konstruktor nadrazreda Steklenica
		super(k, "Pivo");							// super - pokliče: public Steklenica; potrebuje iste vhodne param. kot public Steklenica PAZI!!!
		
		// pivo vzamemo iz hladilnika
		temperatura = 8.0;
		
		// Inicializiramo dodatne lastnosti
		stopnjaAlkohola = a;
		proizvajalec = p;
		stil = s;
	}
	
	// Konstruktor, ki ustvari pivsko steklenico v kateri ni piva
	public PivskaSteklenica2(int k, String p) {					// primer za !! POLIMORFISM !!
		
		// Pokličemo konstruktor nadrazreda Steklenica
		super(k, p);							// super - pokliče: public Steklenica; potrebuje iste vhodne param. kot public Steklenica PAZI!!!
		
		// Inicializiramo dodatne lastnosti
		temperatura = 0.0;
		stopnjaAlkohola = 0.0;
		proizvajalec = p;
		stil = "";
	}
	
	// Metoda ogreje pivo za določeno število stopinj
	// vhodi: niz s temperaturo
	// vrne:  / (ne vrne nič, ker je void)
	public void ogrej(String tempS) throws Exception {			// throws Exception--->vrže izjemo v primeru napačnega vnosa; glej tudi spodaj!
		
		double tempD = 0.0;
		
		// Poskušamo pretvoriti niz v double
		try {
			tempD = Double.parseDouble(tempS);
		}
		catch(Exception e) {
			// Izpiše napako in vrže izjemo naprej  
			System.out.println("Napaka pri pretvorbi: " + e.toString());
			throw new Exception(tempS + " ni število!");
		}
		
		System.out.print("Pivo ogrevam s/z " + tempD); 

		// Če bi bila končna temperatura previsoka, vržemo izjemo:
		if(temperatura + tempD >= 100.0){
			temperatura = 100.0;
			throw new Exception("Pivo je zavrelo!");
		}
		
		// Če bi bila končna temperatura prenizka, vržemo izjemo:
		if(temperatura + tempD <= 0.0){
			temperatura = 0.0;
			throw new Exception("Pivo je zmrznilo!");
		}

		// povečamo temperaturo piva za <tempD>
		temperatura += tempD;
		
		System.out.println(" na " + temperatura + " stopinj.");
	}
	
	// Metoda, ki vrne vsebino nalepke
	// vhod: /
	// vrne: podatki na nalepki
	public String getNalepka() {
		
		String ret = "=== PIVO === \n";
		ret += "Vsebina: " + getKapaciteta() + "\n";
		ret += "Proizvajalec: " + proizvajalec + "\n";
		ret += "Stil: " + stil + "\n";
		ret += "Alkohol: " + stopnjaAlkohola + "%\n";
		ret += "=======================\n";
		
		return ret;
	}
	
	public double getStopnjaAlkohola() {
		
		return stopnjaAlkohola;
	}
}