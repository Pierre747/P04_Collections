/*
 * Nous allons utiliser quelques classes de l'API Java qui implémentent l'interface Collection.
 * Nous avons par exemple : ArayList, HashTable, etc...
 * 
 * Ici, nous allos créer notre propre classe collection : MesFerraris
 * 
 * 
 */

package fr.collections;

import java.util.*; // On met .* pour importer tous les utils 

public class MonProgramme
{

	public static void main(String[] args)
	{
		// Désormais, on va créer des objets:
		// On va commencer par créer des personnes
		Personne p = new Personne("Chirac", "Jacques");
		Automobile a1 = new Automobile("Ferrari", "noire", 200000);
		Automobile a2 = new Automobile("Ferrari", "rouge", 200000);
		Automobile a3 = new Automobile("Renault", "rouge", 200000);
		Automobile a4 = new Automobile("Ferrari", "rouge", 210000);
		
		// Pour que les valeurs puissent entrer dans ma collection, il faut que ce soir une Automobile de marque Ferrari et de couleur rouge
		
		// On va utiliser une ArrayList (une classe qui implémente les interfaces List qui hérite de l'interface Collection, qui hérite de l'interface Iterable)
		
		List<Object> al = new ArrayList<>(); // On pense à importer les deux java.util : List et ArrayList (sauf si on a mis .*)
		
		// Désormais, j'ajoute les valeurs à mon arraylist
		
		al.add(100);
		al.add(p);
		al.add(a1);
		al.add(a2);
		al.add(a3);
		al.add(a4);
		
		// Autre possibilité pour obtenir une liste : avec un aggrégat de valeurs
		
		List<Object> liste = Arrays.asList(100, p, a1, a2, a3, a4);
		
		// Quelle est la classe concrète qui a été créée par Arrays.asList ?
		
		System.out.println("La classe concrète créée par Arrays.asList est : " + liste.getClass().getName()); // Une ArrayList
		System.out.println();
		
		// On va désormais afficher la liste al :
		System.out.println("Contenu de l'ArrayList al en utilisant un accès par index :");
		afficherContenuAvecIndexes(al);
		System.out.println();
		
		// On va afficher la deuxième liste liste :
		System.out.println("Contenu de l'ArrayList index en parcourant le contenu avec un for étendu :");
		afficherContenuAvecExtendedFor(al);
		System.out.println();
		
		// On va afficher la liste al avec l'itérateur :
		System.out.println("Contenu de l'ArrayList en utilisant un Iterator :");
		afficherContenuAvecIterator(al);
		System.out.println();
		
		// Désormais, on va utiliser la méthode foreach des Listes et lui passer le traitement à exécuter pour chaque item de la liste
		// Deux cas de figure pour le foreach :
		// 1 - Une référence de méthode en faisant ::
		
		System.out.println("Contenu de l'ArrayList liste affiché avec le foreach est une référence de méthode:");
		liste.forEach(System.out::println);
		System.out.println();
		
		// 2 - Avec une expression lambda 
		System.out.println("Contenu de l'ArrayList liste affiché avec foreach et une expression lambda :");
		liste.forEach(o -> System.out.println(o));
		System.out.println();
		
		
		// On va créer une Map de type concret HashTable
		Map<Object, Object> ht = new Hashtable<>();
		
		// Désormais on va peuple la Map ht 
		ht.put("Mon entier", 100);
		ht.put("Ma valeur", 50);
		ht.put("Auto 1", a1);
		ht.put("Auto 2", a2);
		ht.put("Auto 3", a3);
		ht.put("Auto 4", a4);
		
		System.out.println("Contenu de la HashTable avec la méthode spécialisée pour le Map : ");
		// Méthode pour afficher le contenu d'une map
		 afficherContenuMap(ht);
		 System.out.println();
		
		 
		 // Afficher un contenu de la HashTable avec un ExtendedFor puis avec l'itérateur
		 System.out.println("Contenu de la HashTable avec la méthode ExtendedFor : ");
		 afficherContenuAvecExtendedFor(ht);
		 System.out.println();
		 
		 System.out.println("Contenu de la HashTable avec la méthode Iterator : ");
		 afficherContenuAvecIterator(ht);
		 System.out.println();
		 
		 
		 // Utiliser une méthode lambda avec notre Map
		 // On commence par récupérer l'ensemble du jeu de clés
		 System.out.println("Contenu de la HashTable en utilisant foreach et une expression Lambda : ");
		 ht.keySet().forEach(cle -> System.out.println("Clé : " + cle + " Valeur : " + ht.get(cle)));; // pour chaque clé, on va récupérer la clé et la valeur
		 
		 // Pour éviter de récupérer une clé de valeur null, on va devoir les tester :
		 // On recherche une clé sur le map :
		 
		 // Cherchons la clé "vélo"
		 String cle = "vélo";
		 
		 System.out.println("La HashTable " + (ht.containsKey(cle) ? "contient " : "ne contient pas ") + "la clé " + cle);
		 System.out.println();
		 
		 // Cherchons la clé "auto2"
		 String cle2 = "Auto 2";
		 
		 System.out.println("La HashTable " + (ht.containsKey(cle2) ? "contient " : "ne contient pas ") + "la clé " + cle2);
		 System.out.println();
		 
		 // ------------------------------------------------------------------------------ //
		 
		 // On va désormais utiliser la classe MesFerraris
		 MesFerraris mf = new MesFerraris();
		 
		 // On va la peupler
//		 mf.add(100); // Je ne peux pas ajouter 100 car c'est un int et add demande un argument du type Automobile
//		 mf.add(p); // Je ne peux pas ajouter p car c'est une Personne et add demande une Automobile
		 
		 // On va ajouter toute les automobiles
		 mf.add(a1);
		 mf.add(a2);
		 mf.add(a3);
		 mf.add(a4);
		 
		 // On veut afficher les items de ma Collection
		 System.out.println("Ma collection de Ferraris Rouges contient " + mf.size() + " exemplaire(s)");
		 
		 System.out.println("Les Ferraris de ma collection");
		 afficherContenuAvecExtendedFor(mf);
		 System.out.println("Le prix total de la collection est de : " + mf.getPrixTotal() + " euros");
		 System.out.println();
		 
		 // On va tester d'ajouter plus de Ferraris Rouges
		 Automobile a5 = new Automobile("Ferrari", "rouge", 970000);
		 Automobile a6 = new Automobile("Ferrari", "rouge", 550000);
		 
		 mf.add(a5);
		 
		 System.out.println();
		 
		 // On va tester si notre limite d'ajout fonctionne
		 
		 if(mf.add(a6))
		 {
			 System.out.println("La voiture a6 a été ajoutée");
			 System.out.println();
		 }
		 else
		 {
			 System.out.println("La voiture a6 n'a pas été ajoutée");
			 System.out.println();
		 }
		 ;
		 
		 System.out.println("Ma collection de Ferraris Rouges après la tentative d'ajout :");
		 afficherContenuAvecIterator(mf);
		 System.out.println();
		 System.out.println("Le prix total de la collection est de : " + mf.getPrixTotal() + " euros");
		 System.out.println();
		 
		
	} // Fin du main
	

	// Cette méthode va afficher le contenu d'une ArrayList en utilisant les index
	
	private static void afficherContenuAvecIndexes(List<Object> container)
	{
		// On va donc utiliser une boucle for indexée
		
		for(int i = 0; i < container.size(); i++)
		{
			System.out.println(container.get(i));
		}
	}
	
	// Cette méthode va afficher le contenu d'une ArrayList en parcourant le contenu
	
	private static void afficherContenuAvecExtendedFor(Object container)
	{
		// Méthode qui peut parcourir et afficher un tableau ou un ensemble itérable(Iterable => interface)
		
		// On va commencer par analyser l'objet passé en paramètre pour savoir si c'est un tableau ou un itérable (Map, TreeMap, etc...)
		
		if(container instanceof Object[])
		{
			System.out.println("J'affiche le contenu d'un tableau :");
			
			for(Object item : (Object[])container)
			{
				System.out.println(item);
			}
		}
		else // On vérifie si le container est un itérable au sens large (une Collection ou une Map ?)
		{
			Collection<?> cl;
			
			if(container instanceof Collection<?>) // Est-ce que le container est une Collection ?
			{
				cl = (Collection<?>)container; // C'est une Collection. Je caste l'objet passé en paramètre en Collection
			}
			else if(container instanceof Map<?, ?>) // Est-ce que le container est une Map ?
			{
				cl = ((Map<?, ?>)container).values(); // C'est une Map. Je caste le contenu en Map et je récupère la collection de valeurs
			}
			else
			{
				System.out.println("Container n'est ni un tableau, ni une Collection, ni une Map");
				return;
			}
			
			// On va parcourir la collection cl avec le for étendu
			
			for(Object o : cl)
			{
				System.out.println(o);
			}
		}
	
	} // fin méthode afficherContenuAvecExtendedFor
	
	private static void afficherContenuAvecIterator(Object container)
	{
		// L'itérateur d'une collection est l'objet qui permet de naviguer d'un élément de la colelction à l'autre avec la méthode next()
		// On peut tester s'il rest des eléments à visiter avec la méthode hasNext()
		
		Collection<?> cl;
		
		if(container instanceof Collection<?>) 
		{
			cl = (Collection<?>)container; 
		}
		else if(container instanceof Map<?, ?>) 
		{
			cl = ((Map<?, ?>)container).values(); 
		}
		else
		{
			System.out.println("Container n'est ni une Collection, ni une Map");
			return;
		}
		
		// Récupérer l'itérateur de la collection qui se trouve dans cl
		
		Iterator<?> it = cl.iterator(); // Je ne sais pas encore de quel type il sera : <?>
		
		while(it.hasNext()) // Tant que Iterator a un suivant
		{
			System.out.println(it.next()); // retourne moi l'élément suivant
		}
		
	} // Fin méthode afficherContenuAvecIterator
	
	private static void afficherContenuMap(Map<?, ?> map)
	{
		// Je récupère le jeu de clé valeur. Puis clé après clé, je récupère la valeur attachée à la clé courante
		
		// On fait donc une boucle for etendue
		for(Object cle : map.keySet())
		{
			System.out.println("Cle : " + cle + " <||> Valeur : " + map.get(cle));
		}
		
	}

} // Fin classe MonProgramme
