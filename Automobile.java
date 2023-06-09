package fr.collections;

public class Automobile
{
	private String marque, couleur;
	private float prix;
	
	public Automobile(String marque, String couleur, float prix) {
		this.marque = marque;
		this.couleur = couleur;
		this.prix = prix;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Automobile [marque=" + marque + ", couleur=" + couleur + ", prix=" + prix + "]";
	}
	
	
	
}
