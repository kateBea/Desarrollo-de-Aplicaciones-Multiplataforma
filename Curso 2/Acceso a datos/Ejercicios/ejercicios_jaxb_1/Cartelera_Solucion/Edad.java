package dam2.org.cartelera;

public enum Edad {
	TODOSLOSPUBLICOS  {public String toString() {return "tp";}}, 
	MAYORES18 {public String toString() {return "+18";}},
	MAYORES14 {public String toString() {return "+14";}}
}
