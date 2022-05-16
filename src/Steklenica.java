// Avtor: Marko Keber

// Deklariramo javni razred
public class Steklenica {
	
	// Deklariramo lastnosti (deklariramo s tipom spremenljivke!--->int) | PAZI!! spremenljivka tu ni inicializirana!!!===>veljajo za vse steklenice
	// primitivni podatkovni tipi:
	private int kapaciteta;					// v ml ---> te spremenljivke ne moremo spreminjati oz zunaj==>private - lahko dostopamo do te sprem. samo znotraj class!
	private int kolicinaVsebine;			// v ml
	private boolean jeOdprta;				// boolean je logična spremenljivka (true/false)
	// deklariramo objekt z imenom barva razreda String
	private String vsebina;	

	// Deklariramo in inicializiramo statično lastnost
	public static final String material = "steklo";      // vrednost spremenljivke velja za vse metode | final - se ne spreminja

	// Deklariramo javni KONSTRUKTOR - metoda, ki USTVARI nov objekt/steklenico===>PAZI!! isto ime kot class!!
	// ustvarimo polno zaprto steklenico
	// parametri: količina, vrsta vsebine
	// vrača:	  nov objekt razreda Steklenica
	public Steklenica(int k, String v) {
		
		// Inicializiramo spremenljivke (lastnosti)--->zgoraj deklariramo, ker velja splošno za vse steklenice; tu steklenico določeno z argumenti v metodi
		kapaciteta = k;
		kolicinaVsebine = k;
		jeOdprta = false;
		vsebina = v;
		
		// Izpišemo dogodek
		System.out.println("Ustvarjam steklenico prostornine " + kapaciteta + "ml z vsebino " + vsebina + ".");
	}
	
	// Metoda, ki odpre steklenico
	// parametri: -
	// vrača:	  uspešnost odpiranja
	public boolean odpri(){
	
		// če je steklenica že odprta
		if(jeOdprta) {                     // ne rabiš dodati == true ---> (jeOdprta) privzame, da je argument = true!
			System.out.println("Steklenica je že odprta.");
			return false;
		}
		// če je steklenica še zaprta
		else {
			System.out.println("Odpiram steklenico...");
			jeOdprta = true;
			return true;
		}
	}
	
	// Deklariramo metodo, ki zmanjša količino vsebine
	// parametri:  količina, ki jo želimo izprazniti
	// vrača:	   količina, ki je še ostala
	public int izprazni(int k) {						//mora biti public, da lahko kličemo iz drugega programa (HelloWorldApp) | int tip metode, ker vrne količino--->int vrednost
		
		// če je steklenica odprta
		if(jeOdprta == true) {
		
			// če je v steklenici še dovolj vsebine
			if(kolicinaVsebine >= k) {
		
				// od količine vsebine odštejemo količino za praznjenje
				kolicinaVsebine = kolicinaVsebine - k;
				System.out.println("Iz steklenice praznim " + k + "ml.");
			
			}
			// če v steklenici ni dovolj vsebine
			else {
				
				// izpraznimo vse, kar je v steklenici
				kolicinaVsebine = 0;
				System.out.println("Steklenica je prazna");
			
			}
		}
		//če je steklenica zaprta
		else {
		
			System.out.println("Steklenica je zaprta");
		
		}
		
		// vrnemo količino, ki je še ostala
		return kolicinaVsebine;
	}
	
	// GETTER METODA, ki vrne količino vsebine   
	public int getKolicinaVsebine() {				// ker sprem. kolicinaVsebine = private | ta metoda = public
		return kolicinaVsebine;
	}
	
	// GETTER METODA, ki vrne kapaciteto   
	public int getKapaciteta() {				// ker sprem. kolicinaVsebine = private | ta metoda = public
		return kapaciteta;
	}
}